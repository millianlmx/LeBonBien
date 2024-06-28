package fr.michka.lebonbien.dao;

import fr.michka.lebonbien.model.AnnonceEntity;
import fr.michka.lebonbien.model.BienEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@FilterDef(
        name="byAgent",
        parameters = @ParamDef(
                name="ID_AGENT",
                type=int.class
        )
)
@Filter(
        name="byTypeTiers",
        condition="ID_AGENT = :ID_AGENT"
)
public class BienDAO implements DAOInterface<BienEntity>{
    private static EntityManager entityManager;
    public BienDAO() {}

    public static void initialize(EntityManager entityManager) {
        BienDAO.entityManager = entityManager;
    }
    @Override
    public int create(BienEntity data) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        System.out.println("Transaction created: " + transaction);
        entityManager.persist(data);
        System.out.println("Data persisted: " + data);
        transaction.commit();
        System.out.println("Transaction committed: " + transaction);
        return 0;
    }
    @Override
    public int update(BienEntity data) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.merge(data);
         transaction.commit();
         return 0;
    }
    @Override
    public int delete(BienEntity data) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.remove(data);
         transaction.commit();
         return 0;
    }
    @Override
    public BienEntity findById(int id) {
        return entityManager.find(BienEntity.class, id);
    }

    @Override
    public BienEntity[] findAll() {
        return entityManager.createQuery("from BienEntity", BienEntity.class).getResultList().toArray(new BienEntity[0]);
    }

    public BienEntity[] findAllRelatedToAgent(int agentId) {
        entityManager.unwrap(Session.class).enableFilter("byIdAgent").setParameter("ID_AGENT", agentId);
        return entityManager.createQuery("from BienEntity ", BienEntity.class).getResultList().toArray(new BienEntity[0]);
    }
}
