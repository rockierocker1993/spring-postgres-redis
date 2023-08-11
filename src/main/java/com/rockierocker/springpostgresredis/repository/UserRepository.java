package com.rockierocker.springpostgresredis.repository;


import com.rockierocker.springpostgresredis.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User>, CrudRepository<User, Long> {

    List<User> findAll();

}
