package com.jobayed.mockito_test.user.dao;

import com.jobayed.mockito_test.user.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userRepo")
public interface UserRepository extends JpaRepository<User,Integer> {

}
