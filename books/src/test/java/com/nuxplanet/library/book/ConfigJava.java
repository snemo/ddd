package com.nuxplanet.library.book;

import com.nuxplanet.library.db.H2Config;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author oleciwoj
 */
@Configuration
@ComponentScan("com.nuxplanet.library.book")
@ComponentScan("com.nuxplanet.library.db")
public class ConfigJava {

    @Bean
    public DataSource dataSource() {
        return H2Config.inMemoryDataSource();
    }

    @Bean
    public DataSourceConnectionProvider dataSourceConnectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider(dataSource);
    }

    @Bean
    public DefaultConfiguration configuration(DataSource dataSource,
                                              DataSourceConnectionProvider dataSourceConnectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(dataSourceConnectionProvider);

        SQLDialect dialect = SQLDialect.H2;
        jooqConfiguration.set(dialect);

        return jooqConfiguration;
    }

    @Bean
    public DefaultDSLContext dsl(DataSource dataSource,
                                 DataSourceConnectionProvider dataSourceConnectionProvider) {
        return new DefaultDSLContext(configuration(dataSource, dataSourceConnectionProvider));
    }
}
