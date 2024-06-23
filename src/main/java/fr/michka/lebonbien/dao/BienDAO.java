package fr.michka.lebonbien.dao;

import fr.michka.lebonbien.model.BienEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BienDAO implements DAOInterface<BienEntity>{
    private static EntityManager entityManager;
    public BienDAO() {}

    public static void initialize(EntityManager entityManager) {
        BienDAO.entityManager = entityManager;
    }
    @Override
    public int create(BienEntity data) {
        EntityTransaction transaction = entityManager.getTransaction();
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
         entityManager.merge(data);
         transaction.commit();
         return 0;
    }
    @Override
    public int delete(BienEntity data) {
         EntityTransaction transaction = entityManager.getTransaction();
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
}
