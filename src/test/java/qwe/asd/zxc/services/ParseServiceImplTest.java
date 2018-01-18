package qwe.asd.zxc.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import qwe.asd.zxc.domains.Student;

import java.io.FileInputStream;

import static org.junit.Assert.*;

public class ParseServiceImplTest {

    MultipartFile multipartFile;
    ParseServiceImpl parseService;

    @Before
    public void setUp() throws Exception {
        parseService = new ParseServiceImpl();
        multipartFile = new MockMultipartFile("data", "student.txt", "text/plain", "some xml".getBytes());
    }

    @Test
    public void parseFile() throws Exception {

        //give
        Student student = new Student();

        /*//when
        Mockito.when(parseService.parseFile(multipartFile)).thenReturn(student);*/



    }

}