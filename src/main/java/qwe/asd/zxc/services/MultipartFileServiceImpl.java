package qwe.asd.zxc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qwe.asd.zxc.domains.Student;
import qwe.asd.zxc.repos.StudentRepo;

@Service
public class MultipartFileServiceImpl implements MultipartFileService{

    private StudentRepo studentRepo;

    @Autowired
    public MultipartFileServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
}
