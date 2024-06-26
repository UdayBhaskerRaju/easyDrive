package com.companyname.easyDrive.repository;

import com.companyname.easyDrive.Enum.Gender;
import com.companyname.easyDrive.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmailId(String email);
    List<Customer> findByName(String name);

    //writing a custom Sql query using query language
//    @Query(value = "select * from customer_db where gender = :gender and age >= :age",nativeQuery = true)
//    List<Customer> findAllByGenderAndAgeGreaterThen(String gender,int age);


    //writing a custom query using HQL(Hibernate query language)
    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age")
    List<Customer> findAllByGenderAndAgeGreaterThen(Gender gender, int age);

}
