package com.UserDemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.UserDemo.Model.User;

public interface UserDao extends JpaRepository<User , Long>{

}
// Long is of primary key datatype