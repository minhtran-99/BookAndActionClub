package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsReponsitory extends JpaRepository<News, Integer> {
}
