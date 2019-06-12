package com.nuxplanet.library.book

import com.nuxplanet.library.db.H2Config
import org.h2.jdbcx.JdbcDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

/**
 *
 * @author oleciwoj
 */
@Configuration
@ComponentScan("com.nuxplanet.library.book")
@ComponentScan("com.nuxplanet.library.db")
class Config {

    @Bean
    JdbcDataSource dataSource() {
         H2Config.inMemoryDataSource()
    }

    @Bean
    DataSourceConnectionProvider dataSourceConnectionProvider(DataSource dataSource) {
        new DataSourceConnectionProvider(dataSource);
    }

    @Bean
    DefaultConfiguration configuration(DataSource dataSource,
                                              DataSourceConnectionProvider dataSourceConnectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(dataSourceConnectionProvider);

        SQLDialect dialect = SQLDialect.H2;
        jooqConfiguration.set(dialect);

        jooqConfiguration
    }

    @Bean
    DefaultDSLContext dsl(DataSource dataSource,
                                 DataSourceConnectionProvider dataSourceConnectionProvider) {
        new DefaultDSLContext(configuration(dataSource, dataSourceConnectionProvider))
    }

}
