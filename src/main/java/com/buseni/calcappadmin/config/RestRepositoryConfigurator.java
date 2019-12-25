package com.buseni.calcappadmin.config;

import com.buseni.calcappadmin.domain.Project;
import com.buseni.calcappadmin.domain.User;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

/**
 * RestRepositoryConfigurator
 */
@Component
public class RestRepositoryConfigurator implements RepositoryRestConfigurer{
@Override
public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Project.class, User.class);
}
    
}