package com.hieudev.ss7_springdatajpa_blog.repository;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
