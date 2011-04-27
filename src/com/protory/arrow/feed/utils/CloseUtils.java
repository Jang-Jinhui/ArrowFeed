package com.protory.arrow.feed.utils;

import java.io.IOException;
import java.io.InputStream;

import com.protory.arrow.feed.parser.FeedParserException;

public class CloseUtils {

    public static void closeQuietly(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
            throw new FeedParserException(e);
        }
    }
}
