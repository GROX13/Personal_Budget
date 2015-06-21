# Personal_Budget

თქვენი ამოცანაა დაწეროთ აპლიკაცია რომელიც დაგვეხმარება ხარჯების აღრიცხვაში. როგორც იცით საბარათე ოპერაციის დროს ზოგიერთი ბანკი გზავნის შეტყობინებას რა მოცულობის თანხა ჩამოგეჭრათ, რამდენი დარჩა ბალანსზე, პოს ტერმინალის დასახელებას და სხვა სასარგებლო ინფორმაციას(TBC და BOG ჩვენთვის ყველა საჭირო მონაცემს აგზავნის, სხვა ბანკების შესახებ არ ვიცი). აპლიკაციამ უნდა უსმინოს ბანკიდან შემოსულ SMS ებს, გაანალიზოს შეტყობინების შინაარსი და შემდეგ ასახოს პროგრამაში 
სხვადასხვა ჩარტების სახით.

1. მომხმარებელს უნდა შეეძლოს ხარჯების კატეგორიის შექმნა, შეცვლა და წაშლა. თავდაპირველად აპლიკაციას უნდა მოყვებოდეს სტანდარტული ისეთი კატეგორიები როგორიცაა: კომუნალური ხარჯები, გართობა, კვება, ბენზინი, მობილური, სხვა ხარჯები და ასე შემდეგ.

2. ოპერაციების დიდი ნაწილისთვის აპლიკაცია ავტომატურად უნდა ხვდებოდეს თუ რომელ კატეგორიაში უნდა გაანაწილოს ხარჯი.

3. თუ დანახარჯისთვის გაურკვეველია რომელ კატეგორიას ეკუთვნის, აპლიკაციამ უნდა მიაკუთვნოს "სხვა ხარჯი" კატეგორიას.

4. მომხმრებელს ნებისმიერი დანახარჯისთვის უნდა შეეძლოს კატეგორიის შესაბამება, რის დროსაც მიუთითებს ეს წესი ერთჯერადია თუ მუდმივი. მუდმივის არჩევის შემთხვევაში ანალოგიური ხარჯი ავტომატურად უნდა ჩავარდეს არჩეულ კატეგორიაში. ამ ოპერაციის ხარჯზე დროდადრო პრობგრამა დაჭკვიანდება და თითქმის ყველა ხარჯს სწორად გაანაწილებს კატეგორიების მიხედვით.

5. კატეგორიებში განაწილების გასამარტივებლად მომხმარებელს უნდა შეეძლოს წესების შემოტანა, რომლის მიხედვითაც მოხდება განაწილება. ასევე უნდა შეიძლებოდეს არსებული წესების წაშლა და შეცვლა.

6. აპლიკაციაში უნდა არსებობდეს შემდეგი სქრინები:
  - კატეგორიების ჩამონათვალი, კონკრეტული კატეგორიის არჩევის შემთხვევაში უნდა გამოჩნდეს ამ კატეგორიაში არსებული დანახარჯები, დასორტირებული დროის მიხედვით.
  - ამონაწერის ფორმა, სადაც მომხმარებელს შეეძლება პერიოდის, კატეგორიის, დანახარჯის შუალედის მიხედვით ხარჯების გამოტანა.
  - ფორმა სადაც გრაფიკის საშუალებით იქნება ნაჩვენები თქვეების მიხედვით გასავალი და შემოსავალი.
  - ფორმა სადაც ჩარტის საშუალებით იქნება ნაჩვენები ხარჯები კატეგორიების მიხედვით.

საქართვეკის ბანკის sms ები
-------------------------
1. გასავალი ოპერაცია, გაურკვეველი მიზეზით

> sakartvelos banki: gasavlis operacia tanxa: GELX,XXX.XX angarishidan: [აქ ანგარიშის სახელი] tarigi: 29/10/2012
> sakartvelos banki: gasavlis operacia tanxa: USDXX.XX angarishidan: [აქ ანგარიშის სახელი] tarigi: 16/07/2013

2. ბანკომატიდან თანხის გატანა

> sakartvelos banki: sabarate operacia. operaciis tipi: ganagdeba baratis bolo 4 cipri: XXXX tanxa: GELXXX.XX obiekti: BOG ATM7 TBS>TBILISI                  GE tarigi: 29/10/2012
> sakartvelos banki: sabarate operacia operaciis tipi: ganagdeba baratis bolo 4 cipri: XXXX tanxa: GEL X,XXX.XX nashti angarishze: GEL X,XXX.XX xelmisacvdomi Express kulebi: 30 obiekti: BOG ATM AGMASHENEBELI ALLEY>TBILISI /Georgia/ tarigi: 06/01/2014

3. თანხის ჩარიცხვა

> sakartvelos banki: tanxis charicxva tanxa: GELX,XXX,XXX.XX angarishze: [აქ ანგარიშის სახელი] tarigi: 30/10/2012

4. საბარათე ოპერაცია

> sakartvelos banki: sabarate operacia operaciis tipi: gadaxda baratis bolo 4 cipri: XXXX tanxa: GEL XX.XX nashti angarishze: GEL X,XXX.XX xelmisacvdomi Express kulebi: 30 obiekti: LTD FRESCO SHOPING CENTER> TBILISI /Georgia/ tarigi: 30/04/2014

> sakartvelos banki: sabarate operacia operaciis tipi: gadaxda baratis bolo 4 cipri: XXXX tanxa: GEL X.XX nashti angarishze: GEL XX,XXX.XX.49 xelmisacvdomi Express kulebi: 400 obiekti: JSC SMART RETAIL>TBILISI /Georgia/ tarigi: 02/05/2014

> sakartvelos banki: sabarate operacia operaciis tipi: gadaxda baratis bolo 4 cipri: XXXX tanxa: GEL XX.XX nashti angarishze: GEL X,XXX.XX xelmisacvdomi Express kulebi: 80 obiekti: CARREFOUR>TBILISI /Georgia/ tarigi: 08/05/2014


თი ბი სი ბანკი
==============
1. თანხის ჩარიცხვა

> Tanxis charicxva  01/11/2013  Angarishi: VISA ELECTRON  Tanxa: XXXX.XX GEL  Gmadlobt

2. ბანკომატიდან თანხის გატანა

> Sabarate operacia  02/11/2013 11:00:31  Barati: VISA ELECTRON  Tanxa: XXXX.XX GEL  ATM TBC-155 (Kutaisi 7)>Kutaisi GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt

3. ბარათით გადახდა

> Sabarate operacia  02/11/2013 17:58:38  Barati: PRIME CARD CLASSIC  Tanxa: XX.XX GEL  LTD GEOINVEST>ZESTAFONI GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt
> Sabarate operacia  02/11/2013 20:41:18  Barati: PRIME CARD CLASSIC  Tanxa: X.XX GEL  LTD NIKORA TRADE>TBILISI GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt
> Sabarate operacia  04/11/2013 16:12:36  Barati: PRIME CARD CLASSIC  Tanxa: XX.XX GEL  CARREFOUR>TBILISI GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt
> Sabarate operacia  04/11/2013 20:38:56  Barati: PRIME CARD CLASSIC  Tanxa: XX.XX GEL  LUKOIL - 2>Tbilisi GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt
> Sabarate operacia  10/11/2013 16:51:04  Barati: PRIME CARD CLASSIC  Tanxa: XX.XX GEL  GPC (Chavchavadze 50)>Tbilisi GE  Xelmisatsvdomi: XXXX.XX GEL  Gmadlobt

4. სხვაფასხვა გადასახადები

> Mobiluri balansis shevseba: 04/11/2013 Servisi: Lai-Lai ID: XXXXXXXXX Tanxa: 20.00 Gmadlobt
> Komunaluri gadaxda: 04/11/2013 Servisi: Telasi ID: XXXXXX Tanxa: XX.00 Gmadlobt
> Komunaluri gadaxda: 04/11/2013 Servisi: UnitedWater ID: XXXXXX Tanxa: X.XX Gmadlobt
Komunaluri gadaxda: 04/11/2013 Servisi: Akhteli ID: XXXXXXXXX Tanxa: X.XX Gmadlobt


