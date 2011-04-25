package com.protory.arrow.feed.persistence;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.protory.arrow.feed.domain.Feed;

public class FeedDao {
    private static FeedDao instance;
    private Dao<Feed, Integer> dao;

    private FeedDao(ConnectionSource connectionSource) {
        try {
            dao = BaseDaoImpl.createDao(connectionSource, Feed.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static FeedDao instanceOf(ConnectionSource connectionSource) {
        if (instance == null) {
            instance = new FeedDao(connectionSource);
        }
        return instance;
    }

    public List<Feed> listAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
