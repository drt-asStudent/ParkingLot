package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        LOG.info("findingAllCars");
        try {
        TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
        List<Car> cars = typedQuery.getResultList();
        return copyCarsToDTo(cars);
        }
        catch(Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<CarDto> copyCarsToDTo(List<Car> cars) {
        return cars.stream().map(car -> new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getOwner().getUsername())).toList();
    }
}
