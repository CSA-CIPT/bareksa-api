package com.ciptadana.bareksaapi.config;

import com.ciptadana.bareksaapi.config.jpa.BareksaPostgresJpaProperties;
import com.ciptadana.bareksaapi.config.jpa.HibernateProperties;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
        basePackages = "com.ciptadana.bareksaapi.database.postgres",
        entityManagerFactoryRef = "postgresBareksaEntityManagerFactory",
        transactionManagerRef = "postgresBareksaTransactionManager")
public class BareksaPostgresDatabaseConfiguration {

    @Autowired
    private BareksaPostgresJpaProperties jpaProperties;

    @Bean(name = "postgresBareksaPreDataSourceProperties")
    @ConfigurationProperties("spring.postgres-bareksa.datasource")
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
            properties.put("hibernate.order_inserts", hibernate.isOrderInserts());
            properties.put("hibernate.default_batch_fetch_size", hibernate.getDefaultBatchFetchSize());

        }
        properties.put("hibernate.show_sql", jpaProperties.isShowSql());
        properties.put("hibernate.open-in-view", jpaProperties.isOpenInView());
        return properties;
    }


    @Bean(name = "postgresBareksaDataSource")
    @ConfigurationProperties("spring.postgres-bareksa.datasource.hikari")
    public DataSource preDataSource() {
        return preDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "postgresBareksaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgresBareksaDataSource") DataSource dataSource
    ) {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(dataSource)
                .packages("com.ciptadana.bareksaapi.database.postgres")
                .persistenceUnit("postgres")
                .build();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(hibernateProperties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "postgresBareksaTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("postgresBareksaEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
