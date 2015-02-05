package org.karolgurecki.collector.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.h2.Driver;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by goreckik on 2015-02-03.
 */
@Configuration
public class AppConfig {

    @Bean
    public LocalSessionFactoryBean h2SessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(h2DataSource());
        sessionFactory.setPackagesToScan("org.karolgurecki.collector.model");
        sessionFactory.setHibernateProperties(getHibernateProps());

        return sessionFactory;
    }

    @Bean
    public DataSource h2DataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:h2:file:~/h2db.db;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE;SCHEMA=PUBLIC;MVCC=TRUE;TRACE_LEVEL_FILE=1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    private Properties getHibernateProps() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.id.new_generator_mappings", "true");

        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
