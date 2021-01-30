package com.foody.repository;

import com.foody.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="SELECT * FROM user u WHERE u.username=:username", nativeQuery = true)
    User findUserByUserName(String username);

    @Query(value="call `AddNewUser`(:address, :email, :first_name, :last_name, :password, :phone_number, :username, :role_id)",
            nativeQuery = true)
    int addNewUser(String address, String email,  String first_name, String last_name,
                    String password, String phone_number, String username, int role_id);
}
