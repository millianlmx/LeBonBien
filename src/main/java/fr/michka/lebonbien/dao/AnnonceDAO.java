package fr.michka.lebonbien.dao;

import fr.michka.lebonbien.model.AnnonceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;

public class AnnonceDAO implements DAOInterface<AnnonceEntity>{
    private static EntityManager entityManager;
    public AnnonceDAO() {}

    public static void initialize(EntityManager entityManager) {
        AnnonceDAO.entityManager = entityManager;
    }
    @Override
    public int create(AnnonceEntity data) {
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
    public int update(AnnonceEntity data) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.merge(data);
         transaction.commit();
         return 0;
    }
    @Override
    public int delete(AnnonceEntity data) {
         EntityTransaction transaction = entityManager.getTransaction();
         transaction.begin();
         entityManager.remove(data);
         transaction.commit();
         return 0;
    }
    @Override
    public AnnonceEntity findById(int id) {
        return entityManager.find(AnnonceEntity.class, id);
    }

    @Override
    public AnnonceEntity[] findAll() {
        return entityManager.createQuery("from AnnonceEntity", AnnonceEntity.class).getResultList().toArray(new AnnonceEntity[0]);
    }

    public AnnonceEntity[] findAllRelatedToAgent(int agentId) {
        entityManager.unwrap(Session.class).enableFilter("byAgent").setParameter("ID_AGENT", agentId);
        return entityManager.createQuery("from AnnonceEntity", AnnonceEntity.class).getResultList().toArray(new AnnonceEntity[0]);
    }
}
