package models.controllers;

import models.entities.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
class UserController {

  @GetMapping("/get/all")
  public List<UserEntity> getAllUsers() {
    ArrayList<UserEntity> list = new ArrayList<>();
      list.add(new UserEntity("Test user", "QA", "test@test.test", 23));
    return list;
  }
}