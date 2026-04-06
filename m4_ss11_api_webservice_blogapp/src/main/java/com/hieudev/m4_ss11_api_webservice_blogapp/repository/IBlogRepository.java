package com.hieudev.m4_ss11_api_webservice_blogapp.repository;

import com.hieudev.m4_ss11_api_webservice_blogapp.entity.Blog;
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

    @Query(value = "SELECT * FROM blog " +
            "WHERE title LIKE CONCAT('%', :key, '%') " +
            "OR author LIKE CONCAT('%', :key, '%') " +
            "OR content LIKE CONCAT('%', :key, '%')",
            countQuery = "SELECT COUNT(*) FROM blog " +
                    "WHERE title LIKE CONCAT('%', :key, '%') " +
                    "OR author LIKE CONCAT('%', :key, '%') " +
                    "OR content LIKE CONCAT('%', :key, '%')",
            nativeQuery = true)
    List<Blog> searchAll(String key);

    @Query(value = "SELECT DISTINCT category FROM blog", nativeQuery = true)
    List<String> findAllCategories();

    List<Blog> findAllByCategory(String category);
}
