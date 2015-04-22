package org.tommy.stationery.ink.daemon;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.daemon.component.CacheDataUtil;
import org.tommy.stationery.ink.daemon.config.ParametersConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(includeFilters = @ComponentScan.Filter({Service.class, Component.class}), useDefaultFilters = false, basePackages = {"org.tommy.stationery.ink.daemon", "org.tommy.stationery.ink"})
@EnableTransactionManagement
@EnableAsync
@EnableAspectJAutoProxy
public class RestApplicationConfig {

    private ParametersConfig parametersConfig;

    public RestApplicationConfig() {
        parametersConfig = parametersConfig();
    }


    @Bean
    public ParametersConfig parametersConfig() {
        ParametersConfig parametersConfig = new ParametersConfig("config");
        return parametersConfig;
    }

    @Bean
    public ConfigProperties configProperties() throws IOException {
        ConfigProperties configProperties = new ConfigProperties(ParametersConfig.StringValue(parametersConfig.getConfig().get("inkconfig").get("filepath")));
        return configProperties;
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException, SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        if (ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("id")) != null) {
            dataSource.setUsername(ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("id")));
        }
        if (ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("password")) != null) {
            dataSource.setPassword(ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("password")));
        }
        if (ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("driverClassName")) != null) {
            dataSource.setDriverClassName(ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("driverClassName")));
        }
        dataSource.setDriverClassName(ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("driverClassName")));
        dataSource.setUrl(ParametersConfig.StringValue(parametersConfig.getConfig().get("metastore").get("url")));
        dataSource.setInitialSize(ParametersConfig.IntegerValue(parametersConfig.getConfig().get("metastore").get("initPoolSize")));
        dataSource.setMaxActive(ParametersConfig.IntegerValue(parametersConfig.getConfig().get("metastore").get("maxPoolSize")));
        dataSource.setMinIdle(ParametersConfig.IntegerValue(parametersConfig.getConfig().get("metastore").get("minPoolSize")));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("/sqlmaps/sqlmap-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("/sqlmaps/mapper/**/*.xml"));
        return factoryBean;
    }

    @Bean
    public ShardedJedisPool shardedJedisPool() {
        List<JedisShardInfo> shards = CacheDataUtil.generateShardInfo(
                ParametersConfig.StringValue(parametersConfig.getConfig().get("redis").get("host"))
                , ParametersConfig.StringValue(parametersConfig.getConfig().get("redis").get("password"))
                , 10000
        );
        GenericObjectPool.Config config = new GenericObjectPool.Config();
        config.whenExhaustedAction = GenericObjectPool.WHEN_EXHAUSTED_GROW;
        config.maxActive = 100;
        return new ShardedJedisPool(config, shards);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.tommy.stationery.ink.mapper.metastore");
        mapperScannerConfigurer.afterPropertiesSet();
        return mapperScannerConfigurer;
    }
}
