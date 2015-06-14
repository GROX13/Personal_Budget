package org.giorgi.personalbudget.api;

import org.giorgi.personalbudget.sms.Sms;

import java.util.List;

public interface MessageReader {

    List<Sms> getAllMessages();

}
