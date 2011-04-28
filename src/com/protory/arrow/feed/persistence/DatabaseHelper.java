package com.protory.arrow.feed.persistence;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.code.microlog4android.Logger;
import com.google.code.microlog4android.LoggerFactory;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OpenHelperManager.SqliteOpenHelperFactory;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.protory.arrow.feed.domain.Feed;
import com.protory.arrow.feed.domain.Image;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseHelper.class);
    static {
        OpenHelperManager.setOpenHelperFactory(new SqliteOpenHelperFactory() {
            public OrmLiteSqliteOpenHelper getHelper(Context context) {
                return new DatabaseHelper(context);
            }
        });
    }

    private static final String DATABASE_NAME = "arrowfeed.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Feed.class);
            TableUtils.createTable(connectionSource, Image.class);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Create database successful!!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }
}
