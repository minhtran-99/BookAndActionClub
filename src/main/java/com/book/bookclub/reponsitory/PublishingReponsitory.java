package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublishingReponsitory extends JpaRepository<Publishing, Integer> {
}
