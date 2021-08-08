package com.book.bookclub.reponsitory;

import com.book.bookclub.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BannerReponsitory extends JpaRepository<Banner, Integer> {
}