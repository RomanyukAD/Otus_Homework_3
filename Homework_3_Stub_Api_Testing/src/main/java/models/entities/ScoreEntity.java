package models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScoreEntity {
  private final String name;
  private final Integer score;
}
