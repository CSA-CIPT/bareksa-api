package com.ciptadana.bareksaapi.config.jpa;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.oracle-backoffice.jpa")
public class OracleBOJpaProperties {

    private boolean showSql;
    private boolean openInView;
    private HibernateProperties hibernate;
}
