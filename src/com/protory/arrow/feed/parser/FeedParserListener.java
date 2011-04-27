package com.protory.arrow.feed.parser;

import java.util.Date;

public interface FeedParserListener {

    void onChannel(String title, String link, String description, Date pubDate);

    void onImage(String url, String title, String link);

    void onItem(String author, String title, String description, String link, String guid, Date pubDate);

}
