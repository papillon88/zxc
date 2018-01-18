package qwe.asd.zxc.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qwe.asd.zxc.domains.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {
}
