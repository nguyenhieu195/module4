package com.hieudev.m4_ss9_aop_book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Đánh dấu đây là class AOP (xử lý cắt ngang)
@Component // Để Spring quản lý (tự động tạo bean)
public class LoggingAspect {

    // Biến static để đếm số lượt truy cập (dùng chung toàn hệ thống)
    private static int visitorCount = 0;

    // =========================
    // 1. ĐẾM LƯỢT TRUY CẬP
    // =========================
    @Before("execution(* com.hieudev.m4_ss9_aop_book.controller.*.*(..))")
    // @Before: chạy TRƯỚC khi method trong controller được gọi
    // execution(...): áp dụng cho tất cả method trong package controller
    public void countVisitors(JoinPoint joinPoint) {
        visitorCount++;
        System.out.println("------[VISITOR] Total visits: " + visitorCount);
    }

    // =========================
    // 2. LOG KHI MƯỢN / TRẢ SÁCH
    // =========================
    @AfterReturning(
            "execution(* com.hieudev.m4_ss9_aop_book.service.IBookService.borrowBook(..)) " +
                    "|| execution(* com.hieudev.m4_ss9_aop_book.service.IBookService.returnBook(..))"
    )
    // @AfterReturning: chạy SAU KHI method chạy thành công (không lỗi)
    // Áp dụng cho 2 method:
    // - borrowBook()
    // - returnBook()
    public void logBookChange(JoinPoint joinPoint) {

        // Lấy tên method đang được gọi (borrowBook hoặc returnBook)
        String methodName = joinPoint.getSignature().getName();

        // Xác định hành động dựa vào tên method
        String action = methodName.equals("borrowBook") ? "BORROW" : "RETURN";

        // In ra log hành động + thời gian hiện tại
        System.out.println("------[BOOK CHANGE] Action: "
                + action + ", Time: " + java.time.LocalDateTime.now());
    }

    // =========================
    // 3. LOG KHI CÓ LỖI
    // =========================
    @AfterThrowing(
            pointcut = "execution(* com.hieudev.m4_ss9_aop_book..*(..))",
            throwing = "ex"
    )
    // @AfterThrowing: chạy khi có Exception xảy ra
    // pointcut: áp dụng cho TẤT CẢ method trong project
    // throwing = "ex": nhận exception vào biến ex
    public void logError(JoinPoint joinPoint, Throwable ex) {

        // In ra tên lỗi + message lỗi
        System.out.println("------[ERROR] Exception: "
                + ex.getClass().getSimpleName()
                + ", Message: " + ex.getMessage());
    }
}