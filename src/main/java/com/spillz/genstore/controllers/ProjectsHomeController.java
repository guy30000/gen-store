package com.spillz.genstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ProjectsHomeController {
    //Displays the Home page of the entire app
    // Used when multiple sub-projects are used
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Select an App");
        System.out.println("ProjectsHomeController");
        return "projectHome";
    }

}