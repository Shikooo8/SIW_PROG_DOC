package it.uniroma3.siw_festival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactAppController {

    @GetMapping("/react")
    public String forwardRoot() {
        return "forward:/react/index.html";
    }

    @GetMapping("/react/{path:[^\\.]*}")
    public String forwardShallow() {
        return "forward:/react/index.html";
    }

    @GetMapping("/react/{path1}/{path2:[^\\.]*}")
    public String forwardTwoLevels() {
        return "forward:/react/index.html";
    }

    @GetMapping("/react/{path1}/{path2}/{path3:[^\\.]*}")
    public String forwardThreeLevels() {
        return "forward:/react/index.html";
    }
}