package com.ciptadana.bareksaapi.config;

import com.ciptadana.bareksaapi.config.jpa.HibernateProperties;
import com.ciptadana.bareksaapi.config.jpa.OracleFOJpaProperties;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.ciptadana.bareksaapi.database.oracle.frontoffice",
        entityManagerFactoryRef = "oracleFOEntityManagerFactory",
        transactionManagerRef = "oracleFOTransactionManager")
public class OracleFOConfiguration {

    @Autowired
    private OracleFOJpaProperties jpaProperties;

    @Bean(name = "oracleFOPreDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.oracle-frontoffice.datasource")
    public DataSourceProperties preDataSourceProperties() {
        return new DataSourceProperties();
    }

    private Map<String, Object> hibernateProperties() {
        Map<String, Object> properties = new HashMap<>();
        HibernateProperties hibernate = jpaProperties.getHibernate();
        if (hibernate != null) {
            properties.put("hibernate.hbm2ddl.auto", hibernate.getDdlAuto());
            properties.put("hibernate.format_sql", hibernate.getFormatSql());
            properties.put("hibernate.jdbc.batch_size", hibernate.getJdbc().getBatchSize());
        }
        properties.put("hibernate.show_sql", jpaProperties.isShowSql());
        properties.put("hibernate.open-in-view", jpaProperties.isOpenInView());
        return properties;
    }

    @Bean(name = "oracleFODataSource")
    @ConfigurationProperties("spring.oracle-frontoffice.datasource.hikari")
    public DataSource preDataSource() {
        return preDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "oracleFOEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("oracleFODataSource") DataSource dataSource
    ) {

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(dataSource)
                .packages("com.ciptadana.bareksaapi.database.oracle.frontoffice")
                .persistenceUnit("oracle")
                .build();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(hibernateProperties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "oracleFOTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("oracleFOEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
