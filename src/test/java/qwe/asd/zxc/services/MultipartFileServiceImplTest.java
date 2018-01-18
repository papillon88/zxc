package qwe.asd.zxc.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import qwe.asd.zxc.domains.Student;
import qwe.asd.zxc.repos.StudentRepo;

import static org.junit.Assert.*;

public class MultipartFileServiceImplTest {

    @Mock
    StudentRepo studentRepo;

    MultipartFileServiceImpl multipartFileService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        multipartFileService = new MultipartFileServiceImpl(studentRepo);
    }

    @Test
    public void saveStudent() throws Exception {
        //given
        Student student = new Student("manish",30,"java");

        //when
        Mockito.when(studentRepo.save(student)).thenReturn(student);

        //then
        assertNotNull(multipartFileService.saveStudent(student));
        assertEquals(student,multipartFileService.saveStudent(student));

        Mockito.verify(studentRepo,Mockito.times(2)).save(student);


    }

}