package com.protory.arrow.feed.parser;

import java.util.Date;

public class DefaultFeedParserListener implements FeedParserListener {

    @Override
    public void onChannel(String title, String link, String description, Date pubDate) {
    }

    @Override
    public void onImage(String url, String title, String link) {
    }

    @Override
    public void onItem(String author, String title, String description, String link, String guid, Date pubDate) {
    }

}
