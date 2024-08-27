package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ASTAN database table.
 * 
 */
@Embeddable
public class AstanPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASTAN_IDS_GENERATOR")
    @SequenceGenerator(name = "ASTAN_IDS_GENERATOR", sequenceName = "ASTAN_PK_SEQ", allocationSize = 1)
    @Column(name = "IDS")
    private long ids;

	@Column(name="ZGRADA_IDZ", insertable=false, updatable=false)
	private long zgradaIdz;

	public AstanPK() {
	}
	public long getIds() {
		return this.ids;
	}
	public void setIds(long ids) {	
		this.ids = ids;
	}
	public long getZgradaIdz() {
		return this.zgradaIdz;
	}
	public void setZgradaIdz(long zgradaIdz) {
		this.zgradaIdz = zgradaIdz;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AstanPK)) {
			return false;
		}
		AstanPK castOther = (AstanPK)other;
		return 
			(this.ids == castOther.ids)
			&& (this.zgradaIdz == castOther.zgradaIdz);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ids ^ (this.ids >>> 32)));
		hash = hash * prime + ((int) (this.zgradaIdz ^ (this.zgradaIdz >>> 32)));
		
		return hash;
	}
}