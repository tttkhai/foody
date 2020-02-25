package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.State;
import com.foody.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
