package cn.edu.bupt.aiswitchboard.utils;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreUtils {


    // 直接计算编辑距离，
    public static double basicEditDistance(String s1, String s2) {
        int distance = LevenshteinDistance.getDefaultInstance().apply(s1, s2);
        return 1 - (double) distance / Math.max(s1.length(), s2.length());
    }

    // 两个字符串按照空格分割，先转成list后
    public static double strHashEditDistance(String s1, String s2) {
        String[] s1List = s1.split(" ");
        String[] s2List = s2.split(" ");

//        System.out.println(s1);
//        System.out.println(s2);

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < s1List.length; i++) {
            char c = (char) (s1List[i].hashCode() % 0x10ffff);
            sb1.append(c);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s2List.length; i++) {
            char c = (char) (s2List[i].hashCode() % 0x10ffff);
            sb2.append(c);
        }

        String s1Hash = sb1.toString();
        String s2Hash = sb2.toString();

        int distance = LevenshteinDistance.getDefaultInstance().apply(s1Hash, s2Hash);
        return 1 - (double) distance / Math.max(s1Hash.length(), s2Hash.length());
    }

    public static double setScore(String s1, String s2) {
        String[] s1List = s1.split(" ");
        String[] s2List = s2.split(" ");

        Set<String> set1 = new HashSet<>(Arrays.asList(s1List));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2List));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        int intersectionSize = intersection.size();

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        int unionSize = union.size();

//        System.out.println("交集大小: " + intersectionSize);
//        System.out.println("并集大小: " + unionSize);
//        System.out.println("交集大小与并集大小的比例: " + (double) intersectionSize / unionSize);
        return (double) intersectionSize / unionSize;
    }
}
