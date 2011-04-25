package com.protory.arrow.feed.controller;

import java.sql.SQLException;

import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.protory.arrow.feed.domain.Feed;

public class FeedListAdapter extends OrmLiteBaseAdapter<Feed, Integer> {

    public FeedListAdapter(Context context, OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper) {
        super(context, ormLiteSqliteOpenHelper);
    }

    @Override
    public Dao<Feed, Integer> getCreateDao() throws SQLException {
        return BaseDaoImpl.createDao(getOrmLiteSqliteOpenHelper().getConnectionSource(), Feed.class);
    }

}
