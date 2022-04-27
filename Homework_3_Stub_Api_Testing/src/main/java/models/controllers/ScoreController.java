package models.controllers;

import models.entities.ScoreEntity;
import models.entities.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
class ScoreController {

  @GetMapping("/get/{id}")
  public List<ScoreEntity> getScoreOfUser() {
    ArrayList<ScoreEntity> list = new ArrayList<>();
    list.add(new ScoreEntity("Test user", 78 ));
    return list;
  }
}