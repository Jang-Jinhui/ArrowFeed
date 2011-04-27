package com.protory.arrow.feed.parser;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class FeedParser {

    public void parse(FeedParserListener listener, String resource) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resource);
        String root = doc.getDocumentElement().getNodeName();
        if ("rss".equals(root)) {
            RSS2FeedParser.parser(listener, doc);
            return;
        }

        throw new IllegalStateException("Not support feed.");
    }
}
