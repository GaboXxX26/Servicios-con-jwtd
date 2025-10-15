package com.test.ecuservicies.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.ecuservicies.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END " +
            "FROM User u JOIN u.systems s " +
            "WHERE u.id = :userId AND s.id = :systemId")
    boolean hasAccessToSystem(@Param("userId") Long userId, @Param("systemId") Long systemId);
}
