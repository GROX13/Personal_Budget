package org.giorgi.personalbudget.database;

import java.util.ArrayList;
import java.util.List;

/**
 * I have no phone so I'll be using this.
 * <p/>
 * Created by Giorgi on 6/21/2015.
 */
public class StubMessageBase implements MessageBaseAdapter {

    @Override
    public List<String> readUnreadMessages() {
        List<String> transactions = new ArrayList<>();
        transactions.add("sakartvelos banki: gasavlis operacia tanxa: GEL1476.35 angarishidan: " +
                "[აქ ანგარიშის სახელი] tarigi: 29/10/2012");
        transactions.add("sakartvelos banki: gasavlis operacia tanxa: GEL34.65 angarishidan: " +
                "[აქ ანგარიშის სახელი] tarigi: 16/07/2013");

        // 2. ბანკომატიდან თანხის გატანა
        transactions.add("sakartvelos banki: sabarate operacia. operaciis tipi: ganagdeba " +
                "baratis bolo 4 cipri: XXXX tanxa: GEL360.00 obiekti: BOG ATM7 TBS>TBILISI    " +
                "              GE tarigi: 29/10/2012");
        transactions.add("sakartvelos banki: sabarate operacia operaciis tipi: ganagdeba " +
                "baratis bolo 4 cipri: XXXX tanxa: GEL 1000.00 nashti angarishze: GEL X,XXX.XX " +
                "xelmisacvdomi Express kulebi: 30 obiekti: BOG ATM AGMASHENEBELI ALLEY>TBILISI " +
                "/Georgia/ tarigi: 06/01/2014");

        // 3. თანხის ჩარიცხვა
        transactions.add("sakartvelos banki: tanxis charicxva tanxa: GEL165.34 angarishze: " +
                "[აქ ანგარიშის სახელი] tarigi: 30/10/2012");

        // 4. საბარათე ოპერაცია
        transactions.add("sakartvelos banki: sabarate operacia operaciis tipi: gadaxda " +
                "baratis bolo 4 cipri: XXXX tanxa: GEL 50.20 nashti angarishze: GEL X,XXX.XX " +
                "xelmisacvdomi Express kulebi: 30 obiekti: LTD FRESCO SHOPING CENTER> TBILISI " +
                "/Georgia/ tarigi: 30/04/2014");

        transactions.add("sakartvelos banki: sabarate operacia operaciis tipi: gadaxda " +
                "baratis bolo 4 cipri: XXXX tanxa: GEL 3.00 nashti angarishze: GEL XX,XXX.XX.49" +
                " xelmisacvdomi Express kulebi: 400 obiekti: JSC SMART RETAIL>TBILISI /Georgia/ " +
                "tarigi: 02/05/2014");

        transactions.add("sakartvelos banki: sabarate operacia operaciis tipi: gadaxda baratis " +
                "bolo 4 cipri: XXXX tanxa: GEL 30.00 nashti angarishze: GEL X,XXX.XX " +
                "xelmisacvdomi Express kulebi: 80 obiekti: CARREFOUR>TBILISI /Georgia/ " +
                "tarigi: 08/05/2014");

        // თი ბი სი ბანკი

        // 1. თანხის ჩარიცხვა
        transactions.add("Tanxis charicxva  01/11/2013  Angarishi: VISA ELECTRON  " +
                "Tanxa: 100.00 GEL  Gmadlobt");

        // 2. ბანკომატიდან თანხის გატანა
        transactions.add("Sabarate operacia  02/11/2013 11:00:31  Barati: VISA ELECTRON  " +
                "Tanxa: 100.00 GEL  ATM TBC-155 (Kutaisi 7)>Kutaisi GE  Xelmisatsvdomi: " +
                "XXXX.XX GEL  Gmadlobt");

        // 3. ბარათით გადახდა
        transactions.add("Sabarate operacia  02/11/2013 17:58:38  Barati: PRIME CARD CLASSIC  " +
                "Tanxa: 100.00 GEL  LTD GEOINVEST>ZESTAFONI GE  Xelmisatsvdomi: " +
                "XXXX.XX GEL  Gmadlobt");
        transactions.add("Sabarate operacia  02/11/2013 20:41:18  Barati: PRIME CARD CLASSIC  " +
                "Tanxa: 100.00 GEL  LTD NIKORA TRADE>TBILISI GE  " +
                "Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt");
        transactions.add("Sabarate operacia  04/11/2013 16:12:36  Barati: PRIME CARD CLASSIC  " +
                "Tanxa: 100.00 GEL  CARREFOUR>TBILISI GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt");
        transactions.add("Sabarate operacia  04/11/2013 20:38:56  Barati: PRIME CARD CLASSIC  " +
                "Tanxa: 100.00 GEL  LUKOIL - 2>Tbilisi GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt");
        transactions.add("Sabarate operacia  10/11/2013 16:51:04  Barati: PRIME CARD CLASSIC  " +
                "Tanxa: 100.00 GEL  GPC (Chavchavadze 50)>Tbilisi GE  Xelmisatsvdomi: " +
                "XXXX.XX GEL  Gmadlobt");

        // 4. სხვაფასხვა გადასახადები
        transactions.add("Mobiluri balansis shevseba: 04/11/2013 Servisi: Lai-Lai ID: XXXXXXXXX " +
                "Tanxa: 20.00 Gmadlobt");
        transactions.add("Komunaluri gadaxda: 04/11/2013 Servisi: Telasi ID: XXXXXX " +
                "Tanxa: 25.00 Gmadlobt");
        transactions.add("Komunaluri gadaxda: 04/11/2013 Servisi: UnitedWater ID: XXXXXX " +
                "Tanxa: 3.56 Gmadlobt");
        transactions.add("Komunaluri gadaxda: 04/11/2013 Servisi: Akhteli ID: XXXXXXXXX " +
                "Tanxa: 0.36 Gmadlobt");

        return transactions;
    }

}
