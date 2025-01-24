package com.ciptadana.bareksaapi.config.jpa;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.oracle-frontoffice.jpa")
public class OracleFOJpaProperties {

    private boolean showSql;
    private boolean openInView;
    private HibernateProperties hibernate;
}
