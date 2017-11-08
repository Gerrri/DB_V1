package db_v1;

public class Index {

	int artnr_di, offset_di;
	
	Index (Artikel art){
		artnr_di=art.getArtnr();
	}
}
