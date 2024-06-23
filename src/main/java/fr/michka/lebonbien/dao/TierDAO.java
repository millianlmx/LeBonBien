package fr.michka.lebonbien.dao;

import fr.michka.lebonbien.model.TiersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;

public class TierDAO implements DAOInterface<TiersEntity>{
    private static EntityManager entityManager;
    public TierDAO() {}

    public static void initialize(EntityManager entityManager) {
        TierDAO.entityManager = entityManager;
    }
    @Override
    public int create(TiersEntity data) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        System.out.println("Transaction created: " + transaction);
        entityManager.persist(data);
        System.out.println("Data persisted: " + data);
        transaction.commit();
        System.out.println("Transaction committed: " + transaction);
        return 0;
    }
    @Override
    public int update(TiersEntity data) {
         EntityTransaction transaction = this.entityManager.getTransaction();
         entityManager.merge(data);
         transaction.commit();
         return 0;
    }
    @Override
    public int delete(TiersEntity data) {
         EntityTransaction transaction = entityManager.getTransaction();
         entityManager.remove(data);
         transaction.commit();
         return 0;
    }
    @Override
    public TiersEntity findById(int id) {
        return entityManager.find(TiersEntity.class, id);
    }

    @Override
    public TiersEntity[] findAll() {
        return entityManager.createQuery("from TiersEntity", TiersEntity.class).getResultList().toArray(new TiersEntity[0]);
    }

    public TiersEntity[] findallProprietaires() {
        entityManager.unwrap(Session.class).enableFilter("byTypeTiers").setParameter("TYPE_TIERS", 2);
        return entityManager.createQuery("from TiersEntity", TiersEntity.class).getResultList().toArray(new TiersEntity[0]);
    }

    public TiersEntity[] findallAgents() {
        entityManager.unwrap(Session.class).enableFilter("byTypeTiers").setParameter("TYPE_TIERS", 3);
        return entityManager.createQuery("from TiersEntity", TiersEntity.class).getResultList().toArray(new TiersEntity[0]);
    }
}
