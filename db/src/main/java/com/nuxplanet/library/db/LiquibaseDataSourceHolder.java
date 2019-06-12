package com.nuxplanet.library.db;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import javax.sql.DataSource;

/**
 * @author oleciwoj
 */
public class LiquibaseDataSourceHolder {

    private static DataSource dataSource;
    private static DSLContext dslContext;

    public static synchronized DataSource getDataSource() throws Exception {
        if (dataSource != null) {
            return dataSource;
        }

        DataSource ds = H2Config.inMemoryDataSource();

        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(
                        new JdbcConnection(ds.getConnection()));

        Liquibase liquibase = new Liquibase("liquibase/master.xml", new ClassLoaderResourceAccessor(), database);
        liquibase.update(new Contexts());

        return dataSource = ds;
    }

    public static synchronized DSLContext getDSLContext() throws Exception {
        if (dslContext != null)
            return dslContext;

        return dslContext = DSL.using(getDataSource(), SQLDialect.H2);
    }

}
