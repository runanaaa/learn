package edu.hubu.learn.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "info")
@Data
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String USERNAME;

    private String GRADE;

    private String  PHONE;

    private String  NUMBER;
    @Column(name="avatar_url")
    private String avatar;
}
