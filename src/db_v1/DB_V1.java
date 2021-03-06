/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_v1;

import java.io.*;
import java.util.*;
import java.util.Collections;

/**
 *
 * @author Dustin Asbach & Axel Lammertz
 */
public class DB_V1 {

	public static void main(String[] args) throws IOException {
		FileReader fr1 = new FileReader("Artikel.dat");
		BufferedReader br1 = new BufferedReader(fr1);
		ArrayList<Artikel> art_list = new ArrayList<Artikel>();
		ArrayList<Index> ind_list = new ArrayList<Index>();
		RandomAccessFile raf = new RandomAccessFile("Artikel.dat", "rw");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String temp_str;
		Artikel temp_art;
		Index temp_ind;
		int h_1;
		int h_2 = 0;

		temp_str = br1.readLine();
		raf.seek(0);
		while (temp_str != null) {
			h_1 = temp_str.length();
			temp_art = new Artikel(temp_str);
			art_list.add(temp_art);

			temp_ind = new Index(temp_art.getArtnr(), raf.getFilePointer());
			ind_list.add(temp_ind);

			temp_str = br1.readLine();

			h_2 += h_1+1;

			raf.seek(h_2);
		}
		
		
		
		fr1.close();

		int choice;
		do {
			System.out.println("Fuer die erfassung neuer Nutzerdaten geben Sie bitte '1'ein.");
			System.out.println("Fuer den sequenziellen Zugriff geben Sie bitte '2' ein.");
			System.out.println("Fuer die Suche nach einem Artikel bitte '3' eingeben.");
			System.out.println("Zum beenden des Programms und abspeichern der INDEX-Liste bitte '4' eingeben.");
			choice = Integer.parseInt(in.readLine());
			switch (choice) {

			case 1:
				FileWriter fw1 = new FileWriter("Artikel.dat",true);
				PrintWriter pw1 = new PrintWriter(fw1);
				System.out.println("Erfassen neuer Nutzerdaten");
				System.out.println("Bitte geben Sie die neuen Nuterdaten im Format : 'artnr;artbez;mge;preis;steu' ein.");
				temp_str = in.readLine();
				raf.seek(h_2);
				pw1.println(temp_str);
				h_1 = temp_str.length();
				temp_art = new Artikel(temp_str);
				art_list.add(temp_art);
				temp_ind = new Index(temp_art.getArtnr(), raf.getFilePointer());
				ind_list.add(temp_ind);
				h_2 += h_1+1;
				pw1.close();
				break;

			case 2:
				for (int i = 0; i < art_list.size(); i++) {
					art_list.get(i).ausgabe();
				}
				break;

			case 3:
				Collections.sort(ind_list);
				for (int i=0;i<ind_list.size();i++) {
					ind_list.get(i).ausgabe();
				}
				System.out.println();
				System.out.println("Bitte geben Sie eine Artikelnummer ein, nach der Sie suchen moechten.");
				int suche = Integer.parseInt(in.readLine());
				int kontrolle = -1;
				for (int i=0;i<ind_list.size();i++) {
					if (suche==ind_list.get(i).getartnr()) {
						kontrolle = i;
						break;
					}
				}
				if (kontrolle != -1) {
					raf.seek(ind_list.get(kontrolle).getoffset());
					System.out.println(raf.readLine());
					/*for (int k=0;k<art_list.size();k++) {
						if(suche==art_list.get(k).getArtnr()) {
							art_list.get(k).ausgabe();
							break;
						}
					}*/
				}else {
					System.out.println("Es wurde kein Artikel mit dieser Artikelnummer gefunden.");
				}
				
				break;

			case 4:
				FileWriter fw2 = new FileWriter("Artikel.idx");
				PrintWriter pw2 = new PrintWriter(fw2);
				Collections.sort(ind_list);
				for (int i=0;i<ind_list.size();i++) {
					pw2.println(String.valueOf(ind_list.get(i).getartnr())+";"+String.valueOf(ind_list.get(i).getoffset()));
				}
				pw2.close();
				break;
			}

		} while (choice != 4);

	}
	
	
	
	
	/*static ArrayList<Index> sort(ArrayList<Index> ind_list) {
    	ArrayList<Index> ind_list2 = new ArrayList<Index>();
		Index temp;
		int index;
		while (ind_list.size() != 0) {
			temp = ind_list.get(0);
			index = 0;
			
			if (ind_list.size() > 1) {
				for (int i = 1; i < ind_list.size(); i++) {
					if(temp.getartnr()>ind_list.get(i).getartnr()) {
						temp = ind_list.get(i);
						index = i;
					}
				}
			}
			ind_list2.add(temp);
			ind_list.remove(index);
		}
		return ind_list2;
    }
	/*
	 * static void einlesen(ArrayList<String> einlesen, ArrayList<Artikel> art_list,
	 * ArrayList<Index> ind_list) throws IOException { String name; String temp_str;
	 * Artikel temp_art; Index temp_ind; BufferedReader in = new BufferedReader(new
	 * InputStreamReader(System.in));
	 * 
	 * System.out.println("Bitte geben Sie den Dateinamen ein."); name =
	 * in.readLine(); FileReader fr1 = new FileReader(name); BufferedReader br1 =
	 * new BufferedReader(fr1);
	 * 
	 * temp_str = br1.readLine(); while (temp_str != null) { einlesen.add(temp_str);
	 * temp_str = br1.readLine(); }
	 * 
	 * fr1.close();
	 * 
	 * for(int i = 0; i < einlesen.size();i++) { temp_art = new
	 * Artikel(einlesen.get(i)); art_list.add(temp_art); temp_ind = new
	 * Index(temp_art); ind_list.add(temp_ind);
	 * 
	 * } }
	 */
}
