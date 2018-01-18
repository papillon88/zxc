package qwe.asd.zxc.controllers;

import com.sun.xml.internal.ws.util.ReadAllStream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qwe.asd.zxc.domains.Student;
import qwe.asd.zxc.services.MultipartFileService;
import qwe.asd.zxc.services.ParseService;

import static org.junit.Assert.*;

public class FileControllerTest {

    @Mock
    ParseService parseMultipartFileService;

    @Mock
    MultipartFileService multipartFileService;

    @Mock
    MultipartFile multipartFile;

    @Mock
    RedirectAttributes redirectAttributes;

    MockMvc mockMvc;
    FileController fileController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        fileController = new FileController(parseMultipartFileService, multipartFileService);
        mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
    }

    @Test
    public void getIndexPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getStudentOnIndexPageAfterFileUpload() throws Exception {

        // given
        Student student = new Student("manish", 30, "java");

        // when
        Mockito.when(parseMultipartFileService.parseFile(multipartFile)).thenReturn(student);
        Mockito.when(multipartFileService.saveStudent(student)).thenReturn(student);
        Mockito.when(multipartFile.getContentType()).thenReturn("dummy content");


        // then
        /*mockMvc.perform(MockMvcRequestBuilders.post("/upload")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .requestAttr("file",multipartFile))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(multipartFile,Mockito.times(1)).getContentType();*/




    }

}