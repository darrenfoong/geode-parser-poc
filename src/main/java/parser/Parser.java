package parser;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler {
    private static final Logger LOGGER = LogManager.getLogger(Parser.class);

    private static final String DISALLOW_DOCTYPE_DECL_FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
    private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private SAXParser parser;

    public Parser(String impl) throws ParserConfigurationException, SAXException {
        System.setProperty("javax.xml.parsers.SAXParserFactory", impl);
        LOGGER.info("Using " + impl);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature(DISALLOW_DOCTYPE_DECL_FEATURE, false);
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        parser = factory.newSAXParser();
        parser.setProperty(JAXP_SCHEMA_LANGUAGE, XMLConstants.W3C_XML_SCHEMA_NS_URI);
    }

    public void parse(InputStream is) throws SAXException, IOException {
        LOGGER.info("parsing started");
        parser.parse(is, this);
        LOGGER.info("parsing complete");
    }

    private String getString(char[] ch, int start, int length) {
        String res = "[" + length + "][";

        res += StringEscapeUtils.escapeJava(new String(ch).substring(start, start + length));

        return res + "]";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        LOGGER.info("character: " + getString(ch, start, length));
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("end document");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        LOGGER.info("end element: " + uri + "; " + localName + "; " + qName);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        LOGGER.info("end prefix mapping: " + prefix);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        LOGGER.info("ignorable whitespace: " + getString(ch, start, length));
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        LOGGER.info("process instruction: " + target + "; " + data);
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        LOGGER.info("set document locator");
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        LOGGER.info("skipped entity: " + name);
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("start document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        LOGGER.info("start element: " + uri + "; " + localName + "; " + qName);
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        LOGGER.info("start prefix mapping: " + prefix + "; " + uri);
    }
}
