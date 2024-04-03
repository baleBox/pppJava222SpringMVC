package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars;

    public CarDaoImpl() {
        cars = new ArrayList<>();

        cars.add(new Car("BMW", "black", 250));
        cars.add(new Car("Subaru", "white", 230));
        cars.add(new Car("Audi", "green", 270));
        cars.add(new Car("KIA", "red", 190));
        cars.add(new Car("Lada", "silver", 180));

    }

    @Override
    public List<Car> getCarsByCount(int count) {
        if (count <= 0) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
