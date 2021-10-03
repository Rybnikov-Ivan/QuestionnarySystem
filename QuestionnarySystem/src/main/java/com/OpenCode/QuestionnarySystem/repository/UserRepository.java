package com.OpenCode.QuestionnarySystem.repository;

import com.OpenCode.QuestionnarySystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
