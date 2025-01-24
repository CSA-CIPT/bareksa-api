package com.ciptadana.bareksaapi.config.jpa;

import lombok.Data;

@Data
public class HibernateProperties {

    private Boolean formatSql;
    private String ddlAuto;
    private JdbcProperties jdbc;
    private boolean orderInserts;
    private int defaultBatchFetchSize;

    @Data
    public static class JdbcProperties{
        private int batchSize;
    }
}
