package pl.project.charity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CharityAppConfig implements WebMvcConfigurer {

    public void addVewControllers(final ViewControllerRegistry registry){
        registry.addViewController("/login");
    }

}
