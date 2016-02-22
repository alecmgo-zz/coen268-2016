package edu.scu.coen268.lecture19xmlandjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom);

        try {
            // Normally the input stream is from a file or the internet,
            // but we define it inline here for demo purposes.
            // <foo id="123">Hello World!</foo>
            String xml = "<foo id=\"123\">Hello World!</foo>";
            InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));

            // Boilerplate code to set up the parser
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(stream);
            doc.getDocumentElement().normalize();

            // Analyze the doc
            NodeList nodeList = doc.getElementsByTagName("foo");

            // Analyze the first element
            Node item = nodeList.item(0);
            System.out.println("Element name: " + item.getNodeName());
            System.out.println("Text content: " + item.getTextContent());

            // Analyze the first attribute
            Node attribute = item.getAttributes().item(0);
            System.out.println("Attribute name: " + attribute.getNodeName());
            System.out.println("Attribute value: " + attribute.getNodeValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
