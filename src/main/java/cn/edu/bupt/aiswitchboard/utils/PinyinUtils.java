package cn.edu.bupt.aiswitchboard.utils;

import cn.edu.bupt.aiswitchboard.exceptions.NotImplementedException;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.dictionary.py.PinyinDictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PinyinUtils {

    public static String getPinyin(String chineseStr, String type){
        StringBuilder sb = new StringBuilder();
        List<Pinyin> basePinyins = PinyinDictionary.convertToPinyin(chineseStr);
        if (type.equals("withTone")) {
            for (Pinyin basePinyin : basePinyins) {
                sb.append(basePinyin.getPinyinWithToneMark()).append(" ");
            }
        } else if (type.equals("withoutTone")){
            for (Pinyin basePinyin : basePinyins) {
                sb.append(basePinyin.getPinyinWithoutTone()).append(" ");
            }
        } else {
            throw new NotImplementedException();
        }
//        System.out.println(pinyins);
        return sb.toString();
    }

    public static String toMandarinSet(String x) {
        Pattern pattern = Pattern.compile("((?<!\\w)"
                + "(zh|ch|sh|y|w|b|p|m|f|d|t|l|n|g|k|h|j|q|x|z|c|s|r)?"
                + "(ang|eng|ing|ong|uan|uang|uai|iang|ian|iao|"
                + "ai|ei|ui|ao|ou|iv|ie|ve|ua|ue|uo|er|an|en|in|un|vn|"
                + "a|o|e|i|u|v)"
                + "(?!\\w))");
        Matcher matcher = pattern.matcher(x);
        Set<String> st = new HashSet<>();

        String[] fuzzyMand = {"zh", "sh", "ch", "ang", "eng", "ing"};
        String[] fuzzyMandReplacements = {"z", "s", "c", "an", "en", "in"};

        while (matcher.find()) {
            String a = matcher.group(1);
            String b = matcher.group(2);
            String c = matcher.group(3);

            for (int i = 0; i < fuzzyMand.length; i++) {
                a = a.replace(fuzzyMand[i], fuzzyMandReplacements[i]);
                b = b.replace(fuzzyMand[i], fuzzyMandReplacements[i]);
                c = c.replace(fuzzyMand[i], fuzzyMandReplacements[i]);
            }
            st.add(a);
            st.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (String str: st) {
            sb.append(str).append(" ");
        }
        return sb.toString();
    }

}
