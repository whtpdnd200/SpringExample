package com.devwork.springexample.mybatis;

import com.devwork.springexample.mybatis.domain.Review;
import com.devwork.springexample.mybatis.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 전달받은 id와 일치하는 리뷰 정보를 response에 담기
    @ResponseBody
    @RequestMapping("")
    public Review review(@RequestParam("id") int id) {
        // request.getParameter 와 같은 기능을 하는 어노테이션
        // 전달받은 id와 일치하는 리뷰정보 얻어오기
        return reviewService.getReview(id);
    }

    // 하나의 리뷰를 작성하는 기능
    @ResponseBody
    @RequestMapping("/write")
    public String writeReview() {
        // 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
//        int count = reviewService.createReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");

        // 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리!!
        Review review = new Review();
        review.setStoreId(2);
        review.setMenu("뿌링클");
        review.setUserName("김인규");
        review.setPoint(4.0);
        review.setReview("역시 뿌링클은 진리!!");
        int count = reviewService.createReviewByObject(review);
        return "실행 결과 : " + count;
    }
}
