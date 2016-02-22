package edu.scu.coen268.lecture19xmlandjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class SaxParser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax_parser);

        try {
            String document = "<foo>Hello World!</foo>";

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(document));

            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    System.out.println("Start document");
                } else if (eventType == XmlPullParser.END_DOCUMENT) {
                    System.out.println("End document");
                } else if (eventType == XmlPullParser.START_TAG) {
                    System.out.println("Start tag: " + xpp.getName());
                } else if (eventType == XmlPullParser.END_TAG) {
                    System.out.println("End tag: " + xpp.getName());
                } else if (eventType == XmlPullParser.TEXT) {
                    System.out.println("Text: " + xpp.getText());
                }
                eventType = xpp.next();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
