package tiidelab.tiidelabass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tiidelab.tiidelabass.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findByName(String name);

}
