package com.salihcanhiz.finalcase.dao;

import com.salihcanhiz.finalcase.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
