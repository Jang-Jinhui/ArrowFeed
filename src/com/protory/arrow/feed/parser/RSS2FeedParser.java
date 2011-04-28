package com.protory.arrow.feed.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RSS2FeedParser {
    private static final String PUB_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";

    public static void parser(FeedParserListener listener, Document doc) {
        readyChannel(listener, doc);
        readyImage(listener, doc);
        readyItems(listener, doc);
    }

    private static void readyChannel(FeedParserListener listener, Document doc) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            String title = ((Node) xPath.evaluate("//channel/title", doc, XPathConstants.NODE)).getTextContent();
            String link = ((Node) xPath.evaluate("//channel/link", doc, XPathConstants.NODE)).getTextContent();
            String description = ((Node) xPath.evaluate("//channel/description", doc, XPathConstants.NODE))
                    .getTextContent();
            String pubDate = ((Node) xPath.evaluate("//channel/pubDate", doc, XPathConstants.NODE)).getTextContent();

            listener.onChannel(title, link, description, parseDate(pubDate, PUB_DATE_PATTERN));
        } catch (Exception e) {
            throw new FeedParserException(e);
        }
    }

    private static void readyImage(FeedParserListener listener, Document doc) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            Node imageNode = (Node) xPath.evaluate("//channel/image", doc, XPathConstants.NODE);
            if (imageNode == null) {
                return;
            }

            String url = ((Node) xPath.evaluate("url", imageNode, XPathConstants.NODE)).getTextContent();
            String title = ((Node) xPath.evaluate("title", imageNode, XPathConstants.NODE)).getTextContent();
            String link = ((Node) xPath.evaluate("link", imageNode, XPathConstants.NODE)).getTextContent();

            listener.onImage(url, title, link);
        } catch (Exception e) {
            throw new FeedParserException(e);
        }
    }

    private static void readyItems(FeedParserListener listener, Document doc) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            NodeList items = ((NodeList) xPath.evaluate("//channel/item", doc, XPathConstants.NODESET));
            for (int i = 0; i < items.getLength(); ++i) {
                String author = ((Node) xPath.evaluate("author", items.item(i), XPathConstants.NODE)).getTextContent();
                String title = ((Node) xPath.evaluate("title", items.item(i), XPathConstants.NODE)).getTextContent();
                String description = ((Node) xPath.evaluate("description", items.item(i), XPathConstants.NODE))
                        .getTextContent();
                String link = ((Node) xPath.evaluate("link", items.item(i), XPathConstants.NODE)).getTextContent();
                String guid = ((Node) xPath.evaluate("guid", items.item(i), XPathConstants.NODE)).getTextContent();
                String pubDate = ((Node) xPath.evaluate("pubDate", items.item(i), XPathConstants.NODE)).getTextContent();

                listener.onItem(author, title, description, link, guid, parseDate(pubDate, PUB_DATE_PATTERN));
            }
        } catch (Exception e) {
            throw new FeedParserException(e);
        }
    }

    private static Date parseDate(String value, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern, Locale.ENGLISH).parse(value);
    }

}
