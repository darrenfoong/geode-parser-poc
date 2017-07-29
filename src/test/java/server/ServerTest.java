package server;

import org.apache.geode.InternalGemFireError;
import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.junit.Test;

public class ServerTest {
    @Test
    public void testWhitespaceInternal() {
        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
        Cache cache = new CacheFactory().set("cache-xml-file", "config/cache-whitespace.xml").create();
        cache.close();
    }

    @Test(expected=InternalGemFireError.class)
    public void testWhitespaceXerces() {
        System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
        Cache cache = new CacheFactory().set("cache-xml-file", "config/cache-whitespace.xml").create();
        cache.close();
    }

    @Test
    public void testTrimmedInternal() {
        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
        Cache cache = new CacheFactory().set("cache-xml-file", "config/cache-trimmed.xml").create();
        cache.close();
    }

    @Test
    public void testTrimmedXerces() {
        System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
        Cache cache = new CacheFactory().set("cache-xml-file", "config/cache-trimmed.xml").create();
        cache.close();
    }
}
