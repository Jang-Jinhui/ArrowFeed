package com.protory.arrow.feed.domain;

import com.j256.ormlite.field.DatabaseField;

public class Image implements Model<Integer> {
    private static final long serialVersionUID = -5211680916655515149L;

    public static final String _ID = "_id";
    public static final String URL = "url";
    public static final String TITLE = "title";
    public static final String LINK = "link";
    public static final String FEED_ID = "feed_id";

    @DatabaseField(generatedId = true, columnName = _ID)
    private Integer id;
    @DatabaseField(columnName = URL, canBeNull = false)
    private String url;
    @DatabaseField(columnName = LINK)
    private String link;
    @DatabaseField(columnName = TITLE)
    private String title;
    @DatabaseField(columnName = FEED_ID, foreign = true)
    private Feed feed;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getContent() {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

}
