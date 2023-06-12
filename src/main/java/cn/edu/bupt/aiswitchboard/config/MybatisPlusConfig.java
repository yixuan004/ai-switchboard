package cn.edu.bupt.aiswitchboard.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.edu.bupt.aiswitchboard.dao")
public class MybatisPlusConfig {
}
