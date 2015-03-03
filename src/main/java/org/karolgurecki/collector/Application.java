package org.karolgurecki.collector;


import org.karolgurecki.collector.domain.dao.RolesRepository;
import org.karolgurecki.collector.domain.dao.UserRepository;
import org.karolgurecki.collector.domain.model.User;
import org.karolgurecki.collector.domain.model.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

/**
 * Created by: Karol Górecki
 * <a href="mailto:kagurecki@gmail.com?Subject=Autotask Question" target="_top">kagurecki (at) gmail.com</a>
 * Version: 0.01
 * Since: 0.01
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class Application {

    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        LOGGER.debug("Application started");

        UserRepository userRepository = ctx.getBean(UserRepository.class);

        LOGGER.debug("Saving something");
        userRepository.save(new User("u", "o"));
        userRepository.save(new User("k", "l"));

        LOGGER.debug("getting u o");
        User user = userRepository.findByUsernameAndPassword("u", "o");

        LOGGER.debug(user.toString());

        RolesRepository rolesRepository = ctx.getBean(RolesRepository.class);

        rolesRepository.save(new UserRole("kj"));

        List<UserRole> userRoleList = (List<UserRole>) rolesRepository.findAll();

        for (UserRole userRole : userRoleList) {
            LOGGER.debug(userRole.toString());
        }

    }

}