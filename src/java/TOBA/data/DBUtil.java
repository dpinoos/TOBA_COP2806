package TOBA.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David
 */
class DBUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("TOBAPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }

}
