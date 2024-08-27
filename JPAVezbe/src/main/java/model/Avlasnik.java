package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;


/**
 * The persistent class for the AVLASNIK database table.
 * 
 */
@Entity
@NamedQuery(name="Avlasnik.findAll", query="SELECT a FROM Avlasnik a")
public class Avlasnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AVLASNIK_IDV_GENERATOR", sequenceName="AVLASNIK_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AVLASNIK_IDV_GENERATOR")
	private long idv;

	private String brtel;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Astan
	@OneToMany(mappedBy="avlasnik")
	private List<Astan> astans;

	public Avlasnik() {
		this.astans = new ArrayList<Astan>();
	}

	public long getIdv() {
		return this.idv;
	}

	public void setIdv(long idv) {
		this.idv = idv;
	}

	public String getBrtel() {
		return this.brtel;
	}

	public void setBrtel(String brtel) {
		this.brtel = brtel;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Astan> getAstans() {
		return this.astans;
	}

	public void setAstans(List<Astan> astans) {
		this.astans = astans;
	}

	public Astan addAstan(Astan astan) {
		getAstans().add(astan);
		astan.setAvlasnik(this);

		return astan;
	}

	public Astan removeAstan(Astan astan) {
		getAstans().remove(astan);
		astan.setAvlasnik(null);

		return astan;
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}

}