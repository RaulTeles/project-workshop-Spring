package com.firstProjectRT.projectRT.repositories;

import com.firstProjectRT.projectRT.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
