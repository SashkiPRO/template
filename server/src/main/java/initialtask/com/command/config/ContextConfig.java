package initialtask.com.command.config;

import initialtask.com.filters.EncodingFilter;
import org.springframework.context.annotation.*;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.servlet.Filter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"net.sf.oval.integration.spring", "initialtask.com.*"})
@PropertySource("classpath:database.properties")
@Import({HibernateConfiguration.class})
public class ContextConfig extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(JstlView.class);
       resolver.setSuffix(".html");
        return resolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*").addResourceLocations("/");
    }

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ContextConfig.class};
    }

    @Nullable
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Nullable
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new EncodingFilter()};
    }


}
