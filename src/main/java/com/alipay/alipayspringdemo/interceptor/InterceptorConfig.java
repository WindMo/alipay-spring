package com.alipay.alipayspringdemo.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author WindShadow
 * @verion 2019/12/28.
 */

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 添加拦截路径
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/*").
                excludePathPatterns("/login").
                excludePathPatterns("/index").
                excludePathPatterns("/recharge/notify");// 这里放行支付宝异步通知，原因是请求不来自用户，把通知拦截了就不对了

        super.addInterceptors(registry);
    }

    // 静态资源不过滤
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }


}
