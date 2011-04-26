package com.protory.arrow.feed.controller;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.code.microlog4android.Logger;
import com.google.code.microlog4android.LoggerFactory;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.protory.arrow.feed.domain.Model;
import com.protory.arrow.feed.utils.ConvertUtils;

public abstract class OrmLiteBaseAdapter<T extends Model<ID>, ID> extends BaseAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(OrmLiteBaseAdapter.class);

    private final Object mLock = new Object();

    private Context mContext;
    private OrmLiteSqliteOpenHelper mOrmLiteSqliteOpenHelper;
    private Dao<T, ID> mDao;
    private List<T> mObjects;
    private LayoutInflater mInflater;
    private int mResourceId;
    private int mTextViewResourceId;

    public OrmLiteBaseAdapter(Context context, OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper) {
        init(context, ormLiteSqliteOpenHelper, android.R.layout.simple_list_item_1, 0);
    }

    private void init(Context context, OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper, int resourceId,
            int textViewResourceId) {
        try {
            mContext = context;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mOrmLiteSqliteOpenHelper = ormLiteSqliteOpenHelper;
            mResourceId = resourceId;
            mTextViewResourceId = textViewResourceId;
            mDao = getCreateDao();
            mObjects = mDao.queryForAll();
        } catch (SQLException e) {
            LOG.fatal(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public Context getContext() {
        return mContext;
    }

    public OrmLiteSqliteOpenHelper getOrmLiteSqliteOpenHelper() {
        return mOrmLiteSqliteOpenHelper;
    }

    public abstract Dao<T, ID> getCreateDao() throws SQLException;

    public Dao<T, ID> getDao() {
        return mDao;
    }

    @Override
    public void notifyDataSetChanged() {
        try {
            synchronized (mLock) {
                mObjects = mDao.queryForAll();
                super.notifyDataSetChanged();
            }
        } catch (SQLException e) {
            LOG.fatal(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public void add(T object) {
        try {
            int result = mDao.create(object);
            if (result == 1) {
                notifyDataSetChanged();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int position) {

    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public T getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ConvertUtils.asLong(getItem(position).getId(), position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, mResourceId, mTextViewResourceId);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent, int resourceId,
            int textViewResourceId) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(resourceId, parent, false);
        }

        TextView textView;
        try {
            if (textViewResourceId == 0) {
                textView = (TextView) view;
            } else {
                textView = (TextView) view.findViewById(textViewResourceId);
            }
        } catch (ClassCastException e) {
            LOG.error(e.getMessage(), e);
            throw new IllegalStateException("Requires the resource ID to be a TextView", e);
        }

        T item = getItem(position);
        textView.setText(item.getContent());

        return view;
    }
}
