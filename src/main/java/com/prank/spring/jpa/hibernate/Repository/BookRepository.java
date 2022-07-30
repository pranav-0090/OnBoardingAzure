package com.prank.spring.jpa.hibernate.Repository;

import com.prank.spring.jpa.hibernate.models.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookInfo, Integer> {
}
