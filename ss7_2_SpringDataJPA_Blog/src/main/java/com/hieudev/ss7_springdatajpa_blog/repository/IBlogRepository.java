package com.hieudev.ss7_springdatajpa_blog.repository;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    // tìm kiếm chính xác
//    List<Blog> findAllByTitle(String title);

    // tìm kiếm gần đúng
//    @Query(value = "SELECT * FROM blog " +
//            "WHERE title LIKE CONCAT('%', :key, '%') " +
//            "OR author LIKE CONCAT('%', :key, '%') " +
//            "OR content LIKE CONCAT('%', :key, '%')",
//            nativeQuery = true)
//    Page<Blog> searchAll(@Param("key") String key, Pageable pageable);
    @Query(value = "SELECT * FROM blog " +
            "WHERE title LIKE CONCAT('%', :key, '%') " +
            "OR author LIKE CONCAT('%', :key, '%') " +
            "OR content LIKE CONCAT('%', :key, '%')",
            countQuery = "SELECT COUNT(*) FROM blog " +
                    "WHERE title LIKE CONCAT('%', :key, '%') " +
                    "OR author LIKE CONCAT('%', :key, '%') " +
                    "OR content LIKE CONCAT('%', :key, '%')",
            nativeQuery = true)
    Page<Blog> searchAll(@Param("key") String key, Pageable pageable);

}
