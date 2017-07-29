package parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {
	@Test
	public void testInternal() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		Parser parser = new Parser("com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

		InputStream is = new BufferedInputStream(new FileInputStream(new File("config/cache-whitespace.xml")));

		parser.parse(is);
		is.close();
	}

	@Test
	public void testXerces() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		Parser parser = new Parser("org.apache.xerces.jaxp.SAXParserFactoryImpl");

		InputStream is = new BufferedInputStream(new FileInputStream(new File("config/cache-whitespace.xml")));

		parser.parse(is);
		is.close();
	}
}
