/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dustin
 * Created: 08.11.2017
 */

/*A2*/

    /*a*/
    Select * FROM ARTIKEL , KUNDE , LAGER , LAGERBESTAND

    /*b*/
    Select * FROM ARTIKEL , KUNDE , LAGER , LAGERBESTAND WHERE LAGERBESTAND.ARTNR = ARTIKEL.ARTNR

    /*c*/
    Select * FROM Artikel , Lagerbestand where Lagerbestand.artnr = Artikel.artnr and lagerbestand.lnr = 3 AND lagerbestand.menge>0

    /*d*/
    Select * FROM Artikel , Lagerbestand where Lagerbestand.artnr = Artikel.artnr  AND lagerbestand.menge>0

    /*e*/
    select Lager.LORT , sum(menge) from LAGER left join LAGERBESTAND on (Lager.LNR = LAGERBESTAND.LNR) Group by Lager.LORT

    /*g*/
    select avg(ARTIKEL.Preis), sum(Lagerbestand.menge) , Artikel.Steu FROM LAGERBESTAND , ARTIKEL WHERE LAGERBESTAND.ARTNR= ARTIKEL.ARTNR Group by ARTIKEL.STEU

    /*h*/
    update ARTIKEL Set ARTBEZ = 'Judge' Where Artbez='Delorian';

    /*i*/
    INSERT INTO ARTIKEL (Artbez, mge,preis,steu) VALUES ('Krankenwagen', 2 , 50, 19);
    INSERT INTO ARTIKEL (Artbez, mge,preis,steu) VALUES ('Krankenwagen', 2 , 50, 19);
    INSERT INTO LAGERBESTAND (ARTNR, LNR, MENGE) VALUES (41, 3 , 4);
    
    /*j*/
    DELETE FROM ARTIKEL;