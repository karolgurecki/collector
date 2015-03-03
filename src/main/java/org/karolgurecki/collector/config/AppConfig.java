package org.karolgurecki.collector.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.h2.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

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

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true); //Auto creating scheme when true
        hibernateJpaVendorAdapter.setDatabase(Database.H2);//Database type
        return hibernateJpaVendorAdapter;
    }
}
