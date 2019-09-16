package BikeSharing.Erd.repository.impl;

import BikeSharing.Erd.entity.TestEntity;
import BikeSharing.Erd.repository.interfaces.TestEntityRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestEntityRepositoryImpl implements TestEntityRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveTestEntity(TestEntity testEntity) {
        sessionFactory.getCurrentSession().save(testEntity);
    }
}