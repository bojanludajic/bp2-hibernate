package crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Astan;
import model.Azgrada;
import utils.PersistenceUtil;

public class ZgradaCrud {

	
	public static List<Azgrada> listZgrade() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String s = "Select z from Azgrada z";
		Query q = em.createQuery(s);
		List<Azgrada> zgrade = q.getResultList();
		em.close();
		return zgrade;
	}
	
	public static boolean deleteZgrada(Azgrada z) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			Azgrada cur = em.find(Azgrada.class, z.getIdz());
			if(cur != null) {
				List<Astan> stanovi = cur.getAstans();
				if(stanovi != null) {
					List<Astan> copy = new ArrayList<>(stanovi);
					for(Astan s : copy) {
						cur.removeAstan(s);
						em.remove(s);
					}
				}
				em.remove(cur);
			}
			em.flush();
			et.commit();
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}
	}
	
}
