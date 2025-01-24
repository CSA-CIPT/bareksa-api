package com.ciptadana.bareksaapi.config.jpa;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.postgres-bareksa.jpa")
public class BareksaPostgresJpaProperties {
    private boolean showSql;
    private boolean openInView;
    private HibernateProperties hibernate;
}

