package com.devwork.springexample.mybatis;

import com.devwork.springexample.mybatis.domain.Review;
import com.devwork.springexample.mybatis.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 전달받은 id와 일치하는 리뷰 정보를 response에 담기
    @ResponseBody
    @RequestMapping("/mybatis/review")
    public Review review(@RequestParam("id") int id)
    {
        // request.getParameter 와 같은 기능을 하는 어노테이션
        // 전달받은 id와 일치하는 리뷰정보 얻어오기
        return reviewService.getReview(id);
    }
}
