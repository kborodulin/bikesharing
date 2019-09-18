package BikeSharing.Erd.repository.impl;

import BikeSharing.Erd.entity.Bike;
import BikeSharing.Erd.repository.interfaces.BikeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class BikeRepositoryImpl implements BikeRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Serializable saveBike(Bike bike) {
        return sessionFactory.getCurrentSession().save(bike);
    }

    @Override
    public List<Bike> findAll() {
        List<Bike> bikes = sessionFactory.getCurrentSession().
                createQuery("from Bike", Bike.class).list();
        return bikes;
    }

    @Override
    public boolean delById(long id) {
        try {
            Bike temp = sessionFactory.getCurrentSession().load(Bike.class, id);
            sessionFactory.getCurrentSession().delete(temp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Bike getById(long id) {
        Bike temp = sessionFactory.getCurrentSession().get(Bike.class, id);
        return temp;
    }

    @Override
    public Bike updateById(long id, Bike bike) {
        Bike temp = sessionFactory.getCurrentSession().get(Bike.class, id);
        temp.setDescription(bike.getDescription());
        temp.setModel(bike.getModel());
        temp.setType(bike.getType());
        return temp;
    }
}