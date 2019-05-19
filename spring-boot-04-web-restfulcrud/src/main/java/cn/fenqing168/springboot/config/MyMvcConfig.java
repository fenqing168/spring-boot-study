package cn.fenqing168.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurer可以扩展Springmvc的功能
 */
@Configuration
//@EnableWebMvc 不要接管SpringMvc
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(ViewControllerRegistry registry);
        registry.addViewController("/fenqing168").setViewName("success");
    }

    /**
     * 所有的WebMvcConfigurerAdapter组件都会一起起作用
     */


    /**
     * 添加webMvcConfigurer组件
     * @return
     *  @Bean 将组件放入到容器中
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }

        };

        return webMvcConfigurer;

    }
}
