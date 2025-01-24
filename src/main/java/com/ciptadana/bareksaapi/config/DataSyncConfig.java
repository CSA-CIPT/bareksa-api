package com.ciptadana.bareksaapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "data-sync")
public class DataSyncConfig {

    private boolean migrate;
}
