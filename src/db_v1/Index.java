package db_v1;

public class Index implements Comparable<Index>{

	private int artnr_di;
	private long offset_di;
	
	Index (int artnr, long offset){
		artnr_di=artnr;
		offset_di=offset;
	}
	
	void ausgabe() {
		System.out.println("Die Artikelnummer ist: "+artnr_di+" und der Offset ist: "+offset_di);
		System.out.println();
	}
	
	int getartnr() {
		return artnr_di;
	}
	
	long getoffset() {
		return offset_di;
	}
	
	@Override
	public int compareTo(Index index) {
		if (this.artnr_di < index.getartnr()) {
			return -1;
		} else if (this.artnr_di == index.artnr_di) {
			return 0;
		} else {
			return 1;
		}
	}

}
