package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
    // Repository/DAO zajmuje się dostępem do utrwaonych danych
}
