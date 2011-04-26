package com.protory.arrow.feed.parser;

public interface FeedParserListener {

    void onChannel(String title, String link, String description);

}
