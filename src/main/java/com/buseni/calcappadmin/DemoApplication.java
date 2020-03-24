package com.buseni.calcappadmin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.BiFunction;

import com.buseni.calcappadmin.domain.Project;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableMongoAuditing
@Slf4j 
//@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoApplication {

   
    @Bean
    BiFunction<Project, ObjectId, Boolean> owner(){
        return (project, userId) -> project.getUserId().equals(userId);

    }

	public static void main(String[] args) {
        log.info("Starting application with args {}", Arrays.toString(args));
		SpringApplication.run(DemoApplication.class, args);
	}

	// Fix the CORS errors
    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration();  
        config.setAllowCredentials(true); 
        // *** URL below needs to match the Vue client URL and port ***
        config.setAllowedOrigins(Collections.singletonList("*")); 
        config.setAllowedMethods(Collections.singletonList("*"));  
        config.setAllowedHeaders(Collections.singletonList("*"));  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    } 

    private MappedJwtClaimSetConverter claimSetConverter(){
        Converter<Object, ObjectId> converter = value -> new ObjectId(value.toString());
        return MappedJwtClaimSetConverter.withDefaults(Collections.singletonMap("userId", converter));
    }
    @Autowired
    void jwtDecoder(JwtDecoder jwtDecoder){
        ((NimbusJwtDecoder)jwtDecoder).setClaimSetConverter(claimSetConverter());
    }
}
