package qwe.asd.zxc.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import qwe.asd.zxc.domains.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ParseServiceImpl implements ParseService {

    @Override
    public Student parseFile(MultipartFile multipartFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
        Student student = new Student();
        student.setName(bufferedReader.readLine().split(":")[1]);
        student.setAge(Integer.parseInt(bufferedReader.readLine().split(":")[1]));
        student.setInterest(bufferedReader.readLine().split(":")[1]);
        return student;
    }
}
