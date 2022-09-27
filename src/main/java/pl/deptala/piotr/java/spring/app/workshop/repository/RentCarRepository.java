package pl.deptala.piotr.java.spring.app.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.deptala.piotr.java.spring.app.workshop.repository.entity.RentCarEntity;

@Repository
public interface RentCarRepository extends JpaRepository<RentCarEntity,Long> {

}
