package models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserEntity {
    private final String name;
    private final String cource;
    private final String email;
    private final Integer age;
}


