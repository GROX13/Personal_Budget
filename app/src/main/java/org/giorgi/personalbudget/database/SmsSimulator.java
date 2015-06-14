package org.giorgi.personalbudget.database;

import org.giorgi.personalbudget.api.MessageReader;
import org.giorgi.personalbudget.sms.Sms;

import java.util.List;

public class SmsSimulator implements MessageReader {

    /*
        This is real way of putting message in database but it doesn't work on
        androids higher than 4.4 I think.

        ContentValues values = new ContentValues();
        values.put("address", "4444");
        values.put("read", false);
        values.put("body", "sakartvelos banki:
            gasavlis operacia tanxa: GEL265.25 angarishidan: [saxeli] tarigi: 29/10/2012");
        getContentResolver().insert(Uri.parse("content://sms/inbox"), values);
     */
    @Override
    public List<Sms> getAllMessages() {
        return null;
    }

}
