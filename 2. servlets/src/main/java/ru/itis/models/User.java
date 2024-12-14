package ru.itis.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private Integer age;
}
