package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryReponsitory extends JpaRepository<Category, Integer> {
}
