package com.protory.arrow.feed.parser;

public class FeedParserException extends RuntimeException {
    private static final long serialVersionUID = -5196297962906375281L;

    public FeedParserException(Throwable e) {
        super(e);
    }

    public FeedParserException(String message) {
        super(message);
    }

    public FeedParserException(String message, Throwable e) {
        super(message, e);
    }
}
