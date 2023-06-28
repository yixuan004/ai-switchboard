package cn.edu.bupt.aiswitchboard.init;

import cn.edu.bupt.aiswitchboard.dao.WorkerDao;
import cn.edu.bupt.aiswitchboard.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class InitWorkerData {
    public static List<Worker> workerList;

    // 注入Dao
    @Autowired
    private WorkerDao workerDao;

    @PostConstruct
    public void init() {
        System.out.println("冷启动加载数据库数据到内存中...");
        workerList =  workerDao.selectList(null);
    }
    @PreDestroy
    public void destroy() {
        System.out.println("系统启动成功，workerList加载完成！");
    }
}
