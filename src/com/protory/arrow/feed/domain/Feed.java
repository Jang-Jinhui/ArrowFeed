package com.protory.arrow.feed.domain;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "feed")
public class Feed implements Model<Integer> {
    public static final String _ID = "_id";
    public static final String URI = "uri";
    public static final String GENERATE_DATE = "registDate";

    @DatabaseField(generatedId = true, columnName = _ID)
    private Integer id;
    @DatabaseField(columnName = URI, canBeNull = false)
    private String uri;
    @DatabaseField(columnName = GENERATE_DATE, canBeNull = false)
    private Date generateDate;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getContent() {
        return uri;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }
}
