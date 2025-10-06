package br.com.fiap.recipes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload.dir}")
    private String uploadDir;

    @Value("${app.image.base-url}")
    private String baseUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Obtain the absolute path and normalize it
        String absolutePath = Paths.get(uploadDir).toAbsolutePath().normalize().toString();
        System.out.println("************ ABSOLUTE PATH: " + absolutePath);

        // Define the local where spring boot must find the files using the "file:" prefix
        String resourceLocation = "file:" + absolutePath + "/";
        System.out.println("************ RESOURCE LOCATION: " + resourceLocation);

        System.out.println("************ RESOURCE HANDLER: " + baseUrl + "/**");
        registry.addResourceHandler(baseUrl + "/**").addResourceLocations(resourceLocation);

        //WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
