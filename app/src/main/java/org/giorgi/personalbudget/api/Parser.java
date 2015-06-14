package org.giorgi.personalbudget.api;

import android.provider.Telephony;

public interface Parser {

    Info parseMessage(Telephony.Sms message);

}
