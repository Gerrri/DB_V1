/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_v1;

import java.io.*;
import java.util.*;

/**
 *
 * @author Dustin
 */
public class DB_V1 {

    public static void main(String[] args) throws IOException {
        ArrayList<Artikel> art_list = new ArrayList<Artikel>();
        ArrayList<Index> ind_list = new ArrayList<Index>();
        RandomAccessFile raf = new RandomAccessFile("/user/Speedster/Artikel.dat","rw");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp_str;
        Artikel temp_art;
        Index temp_ind;
        int h_1;
        int h_2;

        FileReader fr1 = new FileReader("Artikel.txt");
        BufferedReader br1 = new BufferedReader(fr1);

        temp_str = br1.readLine();
        raf.seek(0);
        while (temp_str != null) {
        	h_1 = temp_str.length();
        	temp_art = new Artikel(temp_str);
            art_list.add(temp_art);
            
            temp_ind = new Index(temp_art.getArtnr(),raf.getFilePointer());
            ind_list.add(temp_ind);

        	temp_str = br1.readLine();
        	
        	h_2 += h_1;
            
        }

        fr1.close();


        int choice;
        do {
            System.out.println("Fuer die erfassung neuer Nutzerdaten geben Sie bitte '1'ein.");
            System.out.println("Fuer den sequenziellen Zugriff geben Sie bitte '2' ein.");
            System.out.println("Was auch immert");
            System.out.println("Zum beenden des Programms und abspeichern der INDEX-Liste bitte '4' eingeben.");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {

                case 1:
                    System.out.println("Erfassen neuer Nutzerdaten");
                    System.out.println("Bitte geben Sie die neuen Nuterdaten im Format : 'artnr;artbez;mge;preis;steu' ein.");
                    temp_str = in.readLine();
                    temp_art = new Artikel(temp_str);
                    art_list.add(temp_art);
                    temp_ind = new Index(temp_art.getArtnr(),raf.getFilePointer());
                    ind_list.add(temp_ind);
                    break;

                case 2:
                    for (int i =0; i<art_list.size();i++){
                        art_list.get(i).ausgeben();
                    }
                    break;

                case 3:
                    
                    break;

                case 4:
                    
                    break;
            }

        } while (choice != 4);

    }

    /* static void einlesen(ArrayList<String> einlesen, ArrayList<Artikel> art_list, ArrayList<Index> ind_list) throws IOException {
    	String name;
    	String temp_str;
    	Artikel temp_art;
    	Index temp_ind;
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Bitte geben Sie den Dateinamen ein.");
    	name = in.readLine();
    	FileReader fr1 = new FileReader(name);
        BufferedReader br1 = new BufferedReader(fr1);
        
        temp_str = br1.readLine();
        while (temp_str != null) {
        	einlesen.add(temp_str);
        	temp_str = br1.readLine();
        }
        
        fr1.close();
        
        for(int i = 0; i < einlesen.size();i++) {
        	temp_art = new Artikel(einlesen.get(i));
        	art_list.add(temp_art);
        	temp_ind = new Index(temp_art);
        	ind_list.add(temp_ind);
        	
        }
    }*/
}
