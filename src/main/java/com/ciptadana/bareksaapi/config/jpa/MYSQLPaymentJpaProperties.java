package com.ciptadana.bareksaapi.config.jpa;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mysql-payment.jpa")
public class MYSQLPaymentJpaProperties {
    private boolean showSql;
    private boolean openInView;
    private HibernateProperties hibernate;
}
