package com.example.demo1811.repository;

import com.example.demo1811.entity.UserTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserTest, Integer>, JpaSpecificationExecutor<UserTest> {
    //    Page<UserTest> findAll(Pageable pageable);


    @Query(value = "SELECT e FROM UserTest e where e.userName = :name")
    UserTest findUserByUserName(@Param("name") String name);

//    @Query("SELECT e FROM User e where e.id = :name")
//    Optional checkUserByUserName(@Param("name") String name);
}
