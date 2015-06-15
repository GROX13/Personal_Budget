package org.giorgi.personalbudget.api;

import org.giorgi.personalbudget.sms.Sms;

public interface Parser {

    Transaction parseMessage(Sms message);

}
