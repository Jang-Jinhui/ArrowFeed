package com.protory.arrow.feed.domain;

public class FeedItem implements Model<Integer> {
    private static final long serialVersionUID = 7260896144448222172L;

    private int id;
    private String title;

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

}
