package BikeSharing.Erd.repository.interfaces;

import BikeSharing.Erd.entity.Bike;

public interface BikeRepository {
    void saveBike(Bike bike);
}