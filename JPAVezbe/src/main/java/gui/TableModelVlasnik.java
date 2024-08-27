package gui;

import javax.swing.table.AbstractTableModel;

import crud.VlasnikCrud;

import java.util.List;
import model.Astan;
import model.Avlasnik;

public class TableModelVlasnik extends AbstractTableModel {
	
	Avlasnik v;
	VlasnikCrud vc = new VlasnikCrud();
	List<Astan> stanovi;
	private String[] kolone = {"Broj", "Kvadratura", "Sprat"};
	
	public TableModelVlasnik(Avlasnik v) {
		this.v = v;
		this.stanovi = vc.stanoviVlasnika(v);
	}

	@Override
	public int getRowCount() {
		return stanovi.size() + 1;
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(rowIndex == 0) {
			switch (columnIndex) {
			case 0:
				return "Broj";
			case 1:
				return "Kvadratura";
			case 2:
				return "Sprat";
			default:
				return null;
			}
		} else {
			Astan cur = stanovi.get(rowIndex - 1);
			switch (columnIndex) {
			case 0:
				return cur.getBrojstana();
			case 1:
				return cur.getKvadratura();
			case 2:
				return cur.getSprat();
			default: 
				return null;
			}
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	
	

}
