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

public class RSS2FeedParser {
    private static final String PUB_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";

    public static void parser(FeedParserListener listener, Document doc) {
        readyChannel(listener, doc);
        readyImage(listener, doc);
        readyItems(listener, doc);
    }

    private static void readyChannel(FeedParserListener listener, Document doc) {
        XPath xpath = XPathFactory.newInstance().newXPath();


        try {
            System.out.println(xpath.evaluate("//channel/title", doc, XPathConstants.NODE));
            String title = ((Node) xpath.evaluate("/channel/title", doc, XPathConstants.NODE)).getNodeValue();
//            String link = ((Node) xpath.evaluate("/channel/link", doc, XPathConstants.NODE)).getNodeValue();
//            String description = ((Node) xpath.evaluate("/channel/description", doc, XPathConstants.NODE)).getNodeValue();
//            String pubDate = ((Node) xpath.evaluate("/channel/pubDate", doc, XPathConstants.NODE)).getNodeValue();

//            listener.onChannel(title, link, description, parseDate(pubDate, PUB_DATE_PATTERN));
        } catch (Exception e) {
            throw new FeedParserException(e);

        }
        // String title =
        // doc.selectSingleNode("//channel/title").getStringValue();
        // String link =
        // doc.selectSingleNode("//channel/link").getStringValue();
        // String description =
        // doc.selectSingleNode("//channel/description").getStringValue();
        // String pubDate =
        // doc.selectSingleNode("//channel/pubDate").getStringValue();
        //
        // try {
        // listener.onChannel(title, link, description, parseDate(pubDate,
        // PUB_DATE_PATTERN));
        // } catch (Exception e) {
        // throw new FeedParserException(e);
        // }
    }

    private static void readyImage(FeedParserListener listener, Document doc) {
        // Node imageNode = doc.selectSingleNode("//channel/image");
        // if (imageNode == null) {
        // return;
        // }
        //
        // String url =
        // doc.selectSingleNode("//channel/image/url").getStringValue();
        // String title =
        // doc.selectSingleNode("//channel/image/title").getStringValue();
        // String link =
        // doc.selectSingleNode("//channel/image/link").getStringValue();
        //
        // listener.onImage(url, title, link);
    }

    @SuppressWarnings("unchecked")
    private static void readyItems(FeedParserListener listener, Document doc) {
        // List<Element> nodes = doc.selectNodes("//channel/item");
        // for (Element element : nodes) {
        // String author = element.element("author").getStringValue();
        // String title = element.element("title").getStringValue();
        // String description = element.element("description").getStringValue();
        // String link = element.element("link").getStringValue();
        // String guid = element.element("guid").getStringValue();
        // String pubDate = element.element("pubDate").getStringValue();
        // try {
        // listener.onItem(author, title, description, link, guid,
        // parseDate(pubDate, PUB_DATE_PATTERN));
        // } catch (Exception e) {
        // throw new FeedParserException(e);
        // }
        // }
    }

    private static Date parseDate(String value, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern, Locale.ENGLISH).parse(value);
    }

}
