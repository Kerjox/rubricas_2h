package com.kerjox.bloque6rubrica4.repos;

import com.kerjox.bloque6rubrica4.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
