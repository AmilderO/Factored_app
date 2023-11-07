package org.lysmmorklair.api.repository;

import java.util.List;
import java.util.Optional;

import org.lysmmorklair.api.model.entity.Token;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
            SELECT t FROM Token t INNER JOIN User u\s
            on t.user.id = u.id\s
            WHERE u.id = :id\s
            """)
    List<Token> findAllTokenByUser(Integer id);

    @Modifying
    @Query("DELETE FROM Token t WHERE t.user.id = :id")
    void deleteAllTokenByUser(@Param("id") Integer id);

    Optional<Token> findByToken(String token);

    Integer deleteByToken(String token);
}
