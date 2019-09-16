package BikeSharing.Erd.repository.impl;

import BikeSharing.Erd.entity.Bike;
import BikeSharing.Erd.repository.interfaces.BikeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BikeRepositoryImpl implements BikeRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveBike(Bike bike) {
        sessionFactory.getCurrentSession().save(bike);
    }
}