package com.prank.spring.jpa.hibernate.requests;
import com.prank.spring.jpa.hibernate.models.BookInfo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {
    @NotBlank
    String name;
    @NotBlank
    String author;
    @Positive
    Integer cost;

    public BookInfo toBook(){
        return BookInfo.builder()
                .name(this.name)
                .author(this.author)
                .cost(this.cost)
                .build();
    }
}
