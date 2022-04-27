package models.controllers;

import models.entities.CourseEntity;
import models.entities.ScoreEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

  @RestController
  @RequestMapping("/cource")
  class CourcesController {

    @GetMapping("/get/all")
    public List<CourseEntity> getCourses() {
      ArrayList<CourseEntity> list = new ArrayList<>();
      list.add(new CourseEntity("QA java", 15000  ));
      list.add(new CourseEntity("Java", 12000 ));
      return list;
    }
  }
