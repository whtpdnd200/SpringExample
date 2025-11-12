package com.devwork.springexample.mybatis.service;

import com.devwork.springexample.mybatis.domain.Review;
import com.devwork.springexample.mybatis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // 전달받은 id와 일치하는 리뷰 정보 얻어오기
    public Review getReview(int id) {
        // new_review 테이블에서 전달받은 id와 일치하는 행 조회
        Review review = reviewRepository.selectReview(id);
        return review;
    }

    public int createReview(
            int storeId
            , String menu
            , String userName
            , double point
            , String review) {
        int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
        return count;
    }

    public int createReviewByObject(Review review) {
        int count = reviewRepository.insertReviewByObject(review);
        return count;
    }
}
