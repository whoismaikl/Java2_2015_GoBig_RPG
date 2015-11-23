package lv.javaguru.java2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by AST on 2015.11.20..
 */
    @Configuration
    @ComponentScan(basePackages = {"lv.javaguru.java2", "Java2_2015_GoBig_RPG"})
    public class SpringConfig {

    private static final String DATABASE_PROPERTIES_FILE = "database.properties";

}
