package com.example.DimaKorn.Controller;

import com.example.DimaKorn.Dao.SystemFileDao;
import com.example.DimaKorn.Entity.SystemFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class SystemFileController {

    @Autowired
    private SystemFileDao systemFileDao;

    @RequestMapping("/")
    public String listSystemFiles(Model model) throws IOException {
        List<SystemFile> systemFiles = systemFileDao.findAll();
        model.addAttribute("systemFiles", systemFiles);
        return "system-files";
    }

    @PostMapping("/system-files")
    public String createSystemFile(@RequestParam String name, @RequestParam String content) throws IOException {
        SystemFile systemFile = new SystemFile(name, content);
        systemFileDao.save(systemFile);
        return "redirect:/";
    }

    @PostMapping("/system-files/update")
    public String editSystemFile(@RequestParam String name, @RequestParam String content) throws IOException {
        SystemFile systemFile = new SystemFile(name, content);
        systemFileDao.update(systemFile);
        return "redirect:/";
    }

    @PostMapping("/system-files/delete")
    public String deleteSystemFile(@RequestParam String name) {
        systemFileDao.delete(name);
        return "redirect:/";
    }
}
