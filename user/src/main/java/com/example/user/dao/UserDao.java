package com.example.user.dao;

import com.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> { //AbstractHibernateDAO<User> {

    @Query("select u from User u where u.email = ?1")
    public User getUserByEmail(String email);

    @Modifying
    @Query("update User u set u.name = ?1, u.lastName = ?2 where u.email = ?3")
    public Integer updateUser(String name, String lastName, String email);

}