package com.example.teacheraddress.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 3,max = 10,message = "name must ber more than 3 and less than 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;
    @NotNull(message = "age should not be empty")
    @Positive(message = "age must be positive")
    @Column(columnDefinition = "int not null ")
    private Integer age;
    @Email(message = "enter valid email")
    @NotEmpty(message = "email should not be empty")
    @Column(columnDefinition = "varchar not null unique")
    private String email;
    @NotNull(message = "salary should not be empty")
    @Positive(message = "salary must be positive")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
