package com.hieudev.ss7_springdatajpa_blog.repository;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    // tìm kiếm chính xác
//    List<Blog> findAllByTitle(String title);

    // tìm kiếm gần đúng
    @Query(value = "select * from blog where title like concat('%',:title,'%')", nativeQuery = true)
    List<Blog> findAllByTitle(@Param("title") String key);

    @Query(value = "select * from blog where author like concat('%',:author,'%')", nativeQuery = true)
    List<Blog> findAllByAuthor(@Param("author") String key);

    @Query(value = "select * from blog where content like concat('%',:content,'%')", nativeQuery = true)
    List<Blog> findAllByContent(@Param("content") String key);
}
