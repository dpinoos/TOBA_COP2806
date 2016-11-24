package TOBA.data;

import TOBA.business.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author David
 */

public class AccountDB {
        public static void insert(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
