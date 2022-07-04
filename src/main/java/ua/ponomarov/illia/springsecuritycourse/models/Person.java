package ua.ponomarov.illia.springsecuritycourse.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "person")

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов.")
    @Column(name = "username")
    private String username;

    @Min(value = 1918, message = "Год рождения должен быть больше, чем 1918.")
    @Column(name = "year_of_birth")
    private int year_of_birth;

    @Column(name = "password")
    private String password;

    public Person(String username, int year_of_birth) {
        this.username = username;
        this.year_of_birth = year_of_birth;
    }
}
