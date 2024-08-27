package crud;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Astan;
import model.AstanPK;
import model.Avlasnik;
import model.Azgrada;
import utils.PersistenceUtil;

public class StanCrud {
	
	public static void insertStan(AstanPK id, Avlasnik v, Azgrada z, BigDecimal broj, BigDecimal kvadratura, BigDecimal sprat) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			v = em.merge(v);
			z = em.merge(z);
			
			Astan s = new Astan();
			s.setAvlasnik(v);
			s.setAzgrada(z);
			s.setBrojstana(broj);
			s.setKvadratura(kvadratura);
			s.setSprat(sprat);
			
			s.setId(id);
			
			z.addAstan(s);
			v.addAstan(s);
			
			em.persist(s);
			em.merge(v);
			em.merge(z);
			
			em.flush();
			et.commit();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
	}
	
	public void deleteStan(Astan s) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.remove(s);
			em.flush();
			et.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
			if(et != null && et.isActive()) {
				et.rollback();
			}
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
	}

}
