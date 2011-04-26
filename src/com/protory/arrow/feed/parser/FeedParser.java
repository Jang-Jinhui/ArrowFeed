package com.protory.arrow.feed.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FeedParser {

    public void parse(FeedParserListener feedParserListener, String resource) throws Exception {
        InputStream is = null;
        try {
            URL url = new URL(resource);
            is = url.openStream();

        } catch (Exception e) {
            throw new FeedParserException(e);
        } finally {
            closeQuietly(is);
        }
    }

    private void closeQuietly(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
            throw new FeedParserException(e);
        }
    }
}
