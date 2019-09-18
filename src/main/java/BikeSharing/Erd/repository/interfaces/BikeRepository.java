package BikeSharing.Erd.repository.interfaces;

import BikeSharing.Erd.entity.Bike;

import java.io.Serializable;
import java.util.List;

public interface BikeRepository {
    Serializable saveBike(Bike bike);

    List<Bike> findAll();

    boolean delById(long id);

    Bike getById(long id);

    Bike updateById(long id, Bike bike);
}