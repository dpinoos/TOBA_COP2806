package TOBA.data;

import TOBA.business.Account;
import TOBA.business.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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

    public static Account selectAccount(String accntType, User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a "
                + "WHERE a.accountType = :accountType AND a.accountOwner = :accountOwner";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("accountType", accntType);
        q.setParameter("accountOwner", user);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
