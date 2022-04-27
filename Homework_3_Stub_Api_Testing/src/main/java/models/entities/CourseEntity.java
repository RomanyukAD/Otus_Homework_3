package models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CourseEntity {
  private final String name;
  private final Integer price;
}
