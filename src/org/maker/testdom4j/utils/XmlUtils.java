package org.maker.testdom4j.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by DELL on 2014/4/11.
 */
public class XmlUtils {

    public static Document getDocument() {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("src/exam.xml"));
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write2xml(Document document) {
        OutputFormat format = new OutputFormat(null, false, "UTF-8");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileOutputStream(new File("src/exam.xml")), format);
            writer.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
