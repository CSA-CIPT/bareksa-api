package com.ciptadana.bareksaapi.config.jpa;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mysql-security.jpa")
public class MYSQLSecurityJpaProperties {
    private boolean showSql;
    private boolean openInView;
    private HibernateProperties hibernate;
}
