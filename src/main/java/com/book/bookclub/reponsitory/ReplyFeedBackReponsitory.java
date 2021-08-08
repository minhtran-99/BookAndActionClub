package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.ReplyFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReplyFeedBackReponsitory extends JpaRepository<ReplyFeedback, Integer> {
}