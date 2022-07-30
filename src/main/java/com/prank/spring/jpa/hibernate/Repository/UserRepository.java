package com.prank.spring.jpa.hibernate.Repository;

import com.prank.spring.jpa.hibernate.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    // we can use openJPA persistence dependency as well
    //UserRepository need to be interface here, to avoid implementing methods of jparepository
    //JpaRepository is only valid for SQL databases but not for NoSQL
    // e.g. we need to add Spring Data MongoDb dependency for its repository.
    // mongo DB require Spring Data MongoDB dependencies here to work and uses @Document in place @Entity
    // @Transactional ...s
}
