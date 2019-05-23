package cn.fenqing168.springboot.config;

import cn.fenqing168.springboot.component.LoginHandlerInterceptor;
import cn.fenqing168.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源 *.css, *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/user/login", "/");
            }
        };

        return webMvcConfigurer;

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
