package com.prank.spring.jpa.hibernate.models;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "book_info")
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String author;
    @Positive
    Integer cost;

}
