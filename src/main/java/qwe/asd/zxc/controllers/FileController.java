package qwe.asd.zxc.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qwe.asd.zxc.domains.Student;
import qwe.asd.zxc.services.MultipartFileService;
import qwe.asd.zxc.services.ParseService;

import java.io.IOException;


@Slf4j
@Controller
public class FileController {

    private ParseService parseMultipartFileService;
    private MultipartFileService multipartFileService;


    @Autowired
    public FileController(ParseService parseMultipartFileService, MultipartFileService multipartFileService) {
        this.parseMultipartFileService = parseMultipartFileService;
        this.multipartFileService = multipartFileService;
    }


    @RequestMapping(value = {"/index","","/"},method = RequestMethod.GET)
    public String getIndexPage(){
        log.debug("******************** LOADED INDEX");
        return "index";
    }

    @RequestMapping(value = {"/upload"}, method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public String getStudentOnIndexPageAfterFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        log.debug("###########################################"+file.getContentType());
        Student student = null;
        try {
            student = multipartFileService.saveStudent(parseMultipartFileService.parseFile(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message","You successfully uploaded ");
        redirectAttributes.addFlashAttribute("student",student);
        return "redirect:/index";
    }




}
