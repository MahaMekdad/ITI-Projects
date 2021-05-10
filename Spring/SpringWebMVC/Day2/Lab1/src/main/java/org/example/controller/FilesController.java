package org.example.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesController {

    @RequestMapping(value="/uploadFile", method= RequestMethod.GET)
    public String getUploadFileHandler(Model model){
        return "uploadFile";
    }

    @RequestMapping(value="/uploadFile", method= RequestMethod.POST)
    // @ResponseBody
    public String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, Model model) throws IOException{
        if(!file.isEmpty()){
            System.out.println(file.getOriginalFilename());
            FileCopyUtils.copy(file.getBytes(), new File("D:\\Servlets&JSP\\Day7\\" + file.getOriginalFilename()));
            model.addAttribute("fileName", file.getOriginalFilename());
            return "uploaded";
        } else {
            return "failed";
        }
    }
    
}
