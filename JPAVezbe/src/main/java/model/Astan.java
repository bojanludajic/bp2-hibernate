package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ASTAN database table.
 * 
 */
@Entity
@NamedQuery(name="Astan.findAll", query="SELECT a FROM Astan a")
public class Astan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AstanPK id;

	private BigDecimal brojstana;

	private BigDecimal kvadratura;

	private BigDecimal sprat;

	//bi-directional many-to-one association to Avlasnik
	@ManyToOne
	@JoinColumn(name="VLASNIK_IDV")
	private Avlasnik avlasnik;

	//bi-directional many-to-one association to Azgrada
	@ManyToOne
	@MapsId("zgradaIdz")
	@JoinColumn(name="ZGRADA_IDZ")
	private Azgrada azgrada;

	public Astan() {
	}

	public AstanPK getId() {
		return this.id;
	}

	public void setId(AstanPK id) {
		this.id = id;
	}

	public BigDecimal getBrojstana() {
		return this.brojstana;
	}

	public void setBrojstana(BigDecimal brojstana) {
		this.brojstana = brojstana;
	}

	public BigDecimal getKvadratura() {
		return this.kvadratura;
	}

	public void setKvadratura(BigDecimal kvadratura) {
		this.kvadratura = kvadratura;
	}

	public BigDecimal getSprat() {
		return this.sprat;
	}

	public void setSprat(BigDecimal sprat) {
		this.sprat = sprat;
	}

	public Avlasnik getAvlasnik() {
		return this.avlasnik;
	}

	public void setAvlasnik(Avlasnik avlasnik) {
		this.avlasnik = avlasnik;
	}

	public Azgrada getAzgrada() {
		return this.azgrada;
	}

	public void setAzgrada(Azgrada azgrada) {
		this.azgrada = azgrada;
	}
	
	

}