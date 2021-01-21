package com.example.demo2.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSourceRouting extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return BranchContextHolder.getBranchContext();
    }

    public void initDatasources(List<LemonDriverManagerDataSource> dataSourceList) {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        for(LemonDriverManagerDataSource lemonDriverManagerDataSource : dataSourceList){
            dataSourceMap.put(lemonDriverManagerDataSource.getDbname(), lemonDriverManagerDataSource);
        }
        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(dataSourceList.get(0));
    }
}
