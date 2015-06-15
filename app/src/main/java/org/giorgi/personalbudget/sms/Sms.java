package org.giorgi.personalbudget.sms;

/**
 * Container class for message.
 */
public class Sms {
    public static final String BOG = "BOG";
    public static final String TBC = "TBC";

    private String source;
    private String text;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
