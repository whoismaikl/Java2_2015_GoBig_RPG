package lv.javaguru.java2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by AST on 2016.01.21..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lv.javaguru.java2"})
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //  viewResolver.setPrefix("/");
        //  viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
