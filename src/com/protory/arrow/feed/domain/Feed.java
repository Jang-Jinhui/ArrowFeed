package com.protory.arrow.feed.domain;

import java.util.Calendar;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "feed")
public class Feed implements Model<Integer> {
    private static final long serialVersionUID = -1610158081900273974L;

    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String LINK = "link";
    public static final String DESCRIPTION = "description";
    public static final String PUB_DATE = "pubDate";
    public static final String GENERATE_DATE = "generateDate";

    @DatabaseField(generatedId = true, columnName = _ID)
    private Integer id;
    @DatabaseField(columnName = LINK, canBeNull = false)
    private String link;
    @DatabaseField(columnName = TITLE, canBeNull = false)
    private String title;
    @DatabaseField(columnName = DESCRIPTION)
    private String description;
    @DatabaseField(columnName = PUB_DATE, canBeNull = false)
    private Date pubDate;
    @DatabaseField(columnName = GENERATE_DATE, canBeNull = false)
    private Date generateDate = Calendar.getInstance().getTime();

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getContent() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }

}
