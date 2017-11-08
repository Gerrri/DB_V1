package db_v1;

import java.io.*;
import java.util.ArrayList;

public class Artikel {

	private String artbez;
	private int artnr, mge, preis, steu, cnt;
	
	Artikel(String csv){
		String[] dat_array=csv.split(";");
		if (dat_array.length==5) {
			try {
				artnr = Integer.parseInt(dat_array[0]);
				artbez = dat_array[1];
				mge = Integer.parseInt(dat_array[2]);
				preis = Integer.parseInt(dat_array[3]);
				steu = Integer.parseInt(dat_array[4]);
				cnt = 1;
			}catch(NumberFormatException e) {cnt = -1;}
		}else {
			cnt=-1;		
		}
		if (cnt==1) {
			
		}
		
	}

	public String getArtbez() {
		return artbez;
	}

	public int getArtnr() {
		return artnr;
	}

	public int getMge() {
		return mge;
	}

	public int getPreis() {
		return preis;
	}

	public int getSteu() {
		return steu;
	}

	public int getCnt() {
		return cnt;
	}
	
	
}
