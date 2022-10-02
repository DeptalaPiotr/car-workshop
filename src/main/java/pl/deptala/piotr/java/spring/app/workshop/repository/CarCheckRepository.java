package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.CarCheckEntity;

@Repository
public interface CarCheckRepository extends JpaRepository<CarCheckEntity,Long> {
}
