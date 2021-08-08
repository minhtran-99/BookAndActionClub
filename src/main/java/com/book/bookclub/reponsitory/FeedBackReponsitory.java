package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedBackReponsitory extends JpaRepository<Feedback, Integer> {
}