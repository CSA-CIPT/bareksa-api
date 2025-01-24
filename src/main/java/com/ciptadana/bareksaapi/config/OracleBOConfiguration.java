package com.ciptadana.bareksaapi.config;

import com.ciptadana.bareksaapi.config.jpa.HibernateProperties;
import com.ciptadana.bareksaapi.config.jpa.OracleBOJpaProperties;
import com.ciptadana.bareksaapi.config.jpa.OracleFOJpaProperties;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.ciptadana.bareksaapi.database.oracle.backoffice",
        entityManagerFactoryRef = "oracleBOEntityManagerFactory",
        transactionManagerRef = "oracleBOTransactionManager")
public class OracleBOConfiguration {

    @Autowired
    private OracleBOJpaProperties jpaProperties;

    @Bean(name = "oracleBOPreDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.oracle-backoffice.datasource")
    public DataSourceProperties preDataSourceProperties() {
        return new DataSourceProperties();
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> properties = new HashMap<>();
        HibernateProperties hibernate = jpaProperties.getHibernate();
        log.info(jpaProperties.toString());
        if (hibernate != null) {
            log.info(hibernate.toString());
            properties.put("hibernate.hbm2ddl.auto", hibernate.getDdlAuto());
            properties.put("hibernate.format_sql", hibernate.getFormatSql());
            properties.put("hibernate.jdbc.batch_size", hibernate.getJdbc().getBatchSize());
        }
        properties.put("hibernate.show_sql", jpaProperties.isShowSql());
        properties.put("hibernate.open-in-view", jpaProperties.isOpenInView());


        return properties;
    }

    @Bean(name = "oracleBODataSource")
    @ConfigurationProperties("spring.oracle-backoffice.datasource.hikari")
    public DataSource preDataSource() {
        return preDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "oracleBOEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("oracleBODataSource") DataSource dataSource
    ) {

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(dataSource)
                .packages("com.ciptadana.bareksaapi.database.oracle.backoffice")
                .persistenceUnit("oracle")
                .build();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(hibernateProperties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "oracleBOTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("oracleBOEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
