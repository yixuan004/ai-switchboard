package cn.edu.bupt.aiswitchboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
    @Value("${weight.char}")
    private double weightChar;

    @Value("${weight.pinyin-tone}")
    private double weightPinyinTone;

    @Value("${weight.pinyin-without-tone}")
    private double weightPinyinWithoutTone;

    @Value("${weight.set}")
    private double weightSet;

    public double getWeightChar() {
        return weightChar;
    }

    public void setWeightChar(double weightChar) {
        this.weightChar = weightChar;
    }

    public double getWeightPinyinTone() {
        return weightPinyinTone;
    }

    public void setWeightPinyinTone(double weightPinyinTone) {
        this.weightPinyinTone = weightPinyinTone;
    }

    public double getWeightPinyinWithoutTone() {
        return weightPinyinWithoutTone;
    }

    public void setWeightPinyinWithoutTone(double weightPinyinWithoutTone) {
        this.weightPinyinWithoutTone = weightPinyinWithoutTone;
    }

    public double getWeightSet() {
        return weightSet;
    }

    public void setWeightSet(double weightSet) {
        this.weightSet = weightSet;
    }
}