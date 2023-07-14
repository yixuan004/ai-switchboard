package cn.edu.bupt.aiswitchboard.service;

import cn.edu.bupt.aiswitchboard.config.ApplicationConfig;
import cn.edu.bupt.aiswitchboard.dao.WorkerDao;
import cn.edu.bupt.aiswitchboard.exceptions.NotImplementedException;
import cn.edu.bupt.aiswitchboard.init.InitWorkerData;
import cn.edu.bupt.aiswitchboard.model.NameFinderFindRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderInsertRequest;
import cn.edu.bupt.aiswitchboard.model.NameFinderUpdateRequest;
import cn.edu.bupt.aiswitchboard.model.Worker;
import cn.edu.bupt.aiswitchboard.utils.ScoreUtils;
import cn.edu.bupt.aiswitchboard.utils.PinyinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NameFinderServiceImpl implements NameFinderService{

    // 注入Config
    private final ApplicationConfig applicationConfig;
    public NameFinderServiceImpl(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    // 注入Dao
    @Autowired
    private WorkerDao workerDao;

    @Override
    public Object find(NameFinderFindRequest requestParameters) {
        String test_simple_case;
        String test[];

        // 制作初始值，并添加透传信息
        Map<String, Object> data = new HashMap<>();
        data.put("corpId", requestParameters.getCorpId());
        data.put("taskId", requestParameters.getTaskId());
        data.put("version", requestParameters.getVersion());

        // 开始执行处理
        String content = requestParameters.getContent();
        String version = requestParameters.getVersion();
//        System.out.println("content: " + content);
//        System.out.println(content.getClass());

        // 分词，过滤，并制作对于传入文字的分词（传入很可能是更长的）
        String mandarinContent = PinyinUtils.getPinyin(content, "withTone");  // 含拼音的分词
        String mandarinStripContent = PinyinUtils.getPinyin(content, "withoutTone");  // 不含拼音的分词
        String mandarinSetContent = PinyinUtils.toMandarinSet(mandarinStripContent);

        // 执行数据筛选
        List<Map<String, Object>> matchRes = new ArrayList<>();
        if (version.equals("1.0")) {
            // 方法1，数据库select+在线实时分词：从数据库里面选出数据，然后用PinyinUtils执行分词
            List<Worker> workerList = workerDao.selectList(null);
            for (Worker worker: workerList) {
                String dbPer = worker.getPer();
                String dbDep = worker.getDep();
                String dbMandarinPer = PinyinUtils.getPinyin(dbPer, "withTone");
                String dbMandarinStripPer =  PinyinUtils.getPinyin(dbPer, "withoutTone");
                String dbMandarinDep = PinyinUtils.getPinyin(dbDep, "withTone");
                String dbMandarinStripDep = PinyinUtils.getPinyin(dbDep, "withoutTone");
                String dbMandarinSet =  PinyinUtils.toMandarinSet(dbMandarinStripPer) + PinyinUtils.toMandarinSet(dbMandarinStripDep);

                double scoreChar = ScoreUtils.basicEditDistance(content, dbPer+dbDep);  // 原字符级别的编辑距离
                double scorePinyinTone = ScoreUtils.strHashEditDistance(mandarinContent, dbMandarinPer+dbMandarinDep);  // 含拼音级别的编辑距离
                double scorePinyinWithoutTone = ScoreUtils.strHashEditDistance(mandarinStripContent, dbMandarinStripPer+dbMandarinStripDep);  // 不含拼音级别的编辑距离
                double scoreSet = ScoreUtils.setScore(mandarinSetContent, dbMandarinSet);
                double totalScore = applicationConfig.getWeightChar() * scoreChar + applicationConfig.getWeightPinyinTone() * scorePinyinTone +
                        applicationConfig.getWeightPinyinWithoutTone() * scorePinyinWithoutTone + applicationConfig.getWeightSet() * scoreSet;

                Map<String, Object> mp = new HashMap<>();
                mp.put("per", dbPer);
                mp.put("dep", dbDep);
                mp.put("score", totalScore);
                matchRes.add(mp);
            }
        } else if (version.equals("2.0")) {
            // 方法2，离线预分词+数据库select：从数据库里select把所有的select出来，然后完成逐条的进行匹配，并制作逐条匹配的返回结果
            List<Worker> workerList = workerDao.selectList(null);
            for (Worker worker : workerList) {
                String dbPer = worker.getPer();
                String dbDep = worker.getDep();
                String dbMandarinPer = worker.getMandarinPer();
                String dbMandarinStripPer = worker.getMandarinStripPer();
                String dbMandarinDep = worker.getMandarinDep();
                String dbMandarinStripDep = worker.getMandarinStripDep();
                String dbMandarinSet = worker.getMandarinSet();

                double scoreChar = ScoreUtils.basicEditDistance(content, dbPer+dbDep);  // 原字符级别的编辑距离
                double scorePinyinTone = ScoreUtils.strHashEditDistance(mandarinContent, dbMandarinPer+dbMandarinDep);  // 含拼音级别的编辑距离
                double scorePinyinWithoutTone = ScoreUtils.strHashEditDistance(mandarinStripContent, dbMandarinStripPer+dbMandarinStripDep);  // 不含拼音级别的编辑距离
                double scoreSet = ScoreUtils.setScore(mandarinSetContent, dbMandarinSet);
                double totalScore = applicationConfig.getWeightChar() * scoreChar + applicationConfig.getWeightPinyinTone() * scorePinyinTone +
                        applicationConfig.getWeightPinyinWithoutTone() * scorePinyinWithoutTone + applicationConfig.getWeightSet() * scoreSet;

                Map<String, Object> mp = new HashMap<>();
                mp.put("per", dbPer);
                mp.put("dep", dbDep);
                mp.put("score", totalScore);
                matchRes.add(mp);
            }
        } else if (version.equals("3.0")) {
            // 方法3，直接预加载在内存中（这可能类似于redis的思想了，但是这里没有用到）
            // 这种加载方式在启动多份的时候会有问题，多线程数据不同步的问题，自己使用redis给出过一套解决方案
            for (Worker worker : InitWorkerData.workerList) {
                String dbPer = worker.getPer();
                String dbDep = worker.getDep();
                String dbMandarinPer = worker.getMandarinPer();
                String dbMandarinStripPer = worker.getMandarinStripPer();
                String dbMandarinDep = worker.getMandarinDep();
                String dbMandarinStripDep = worker.getMandarinStripDep();
                String dbMandarinSet = worker.getMandarinSet();

                double scoreChar = ScoreUtils.basicEditDistance(content, dbPer+dbDep);  // 原字符级别的编辑距离
                double scorePinyinTone = ScoreUtils.strHashEditDistance(mandarinContent, dbMandarinPer+dbMandarinDep);  // 含拼音级别的编辑距离
                double scorePinyinWithoutTone = ScoreUtils.strHashEditDistance(mandarinStripContent, dbMandarinStripPer+dbMandarinStripDep);  // 不含拼音级别的编辑距离
                double scoreSet = ScoreUtils.setScore(mandarinSetContent, dbMandarinSet);
                double totalScore = applicationConfig.getWeightChar() * scoreChar + applicationConfig.getWeightPinyinTone() * scorePinyinTone +
                        applicationConfig.getWeightPinyinWithoutTone() * scorePinyinWithoutTone + applicationConfig.getWeightSet() * scoreSet;

                Map<String, Object> mp = new HashMap<>();
                mp.put("per", dbPer);
                mp.put("dep", dbDep);
                mp.put("score", totalScore);
                matchRes.add(mp);
            }
        } else {
            throw new NotImplementedException();
        }

        // 按照score字段降序排序，然后把结果加入到data里面
        Collections.sort(matchRes, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                double score1 = (double) o1.get("score");
                double score2 = (double) o2.get("score");
                return Double.compare(score2, score1);  // 降序排序
            }
        });
        data.put("match", matchRes.subList(0, 5));

        return data;
    }

    public Object insert(NameFinderInsertRequest requestParameters) {
        // 制作初始值，并添加透传信息
        Map<String, Object> data = new HashMap<>();

        // 提取参数
        String corpId = requestParameters.getCorpId();
        String dep = requestParameters.getDep();
        String per = requestParameters.getPer();

        // 执行转化为拼音的一些处理，返回用空格分割的String可行
        String mandarinPer = PinyinUtils.getPinyin(per, "withTone");
        String mandarinStripPer = PinyinUtils.getPinyin(per, "withoutTone");
        String mandarinDep = PinyinUtils.getPinyin(dep, "withTone");
        String mandarinStripDep = PinyinUtils.getPinyin(dep, "withoutTone");

        // 执行转化为音节的一些处理
        String mandarinSet = PinyinUtils.toMandarinSet(mandarinStripPer) + PinyinUtils.toMandarinSet(mandarinStripDep);
        System.out.println("mandarinSet: " + mandarinSet);

        // 插入数据库
        Worker worker = new Worker(corpId, dep, per, "12345678", "12345678", mandarinPer, mandarinStripPer, mandarinDep, mandarinStripDep, mandarinSet, "", "");
        workerDao.insert(worker);

        return data;
    }

    public Object update(NameFinderUpdateRequest requestParameters) {
        // 制作初始值，并添加透传信息
        Map<String, Object> data = new HashMap<>();

        // 把数据库中的数据重新加载
        InitWorkerData.workerList =  workerDao.selectList(null);

        return data;
    }
}