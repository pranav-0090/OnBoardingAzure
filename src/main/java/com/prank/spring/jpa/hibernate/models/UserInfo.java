package com.prank.spring.jpa.hibernate.models;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity  //Act as bean for jpa mapping to relational db
//here hibernate will create a table name same as class UserInfo, using @Table it can be customised.
public class UserInfo {

    @Id  //Act as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; //use IDENTITY with Integer and AUTO with UUID

    String name;

    @Column(name = "email_id", length = 255) //can cutomised like this, here hibernate will take
    // email_id as column name instead of email as defined in variable.
    String email;
    String address;
    Integer phone;

//    [
//    {
//        "cloudName": "AzureCloud",
//            "homeTenantId": "74eeccdb-2501-4f7f-a3d3-87bc68d041b7",
//            "id": "1896f4db-1c90-47e1-925f-9c8dd31b3c85",
//            "isDefault": true,
//            "managedByTenants": [],
//        "name": "Free Trial",
//            "state": "Enabled",
//            "tenantId": "74eeccdb-2501-4f7f-a3d3-87bc68d041b7",
//            "user": {
//        "name": "pranav.cloud20@gmail.com",
//                "type": "user"
//    }
//    }
//]

}
