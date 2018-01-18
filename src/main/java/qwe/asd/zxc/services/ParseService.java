package qwe.asd.zxc.services;

import org.springframework.web.multipart.MultipartFile;
import qwe.asd.zxc.domains.Student;

import java.io.IOException;

public interface ParseService {

    Student parseFile(MultipartFile multipartFile) throws IOException;
}
