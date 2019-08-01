package com.turing.tshirtshop.models;

import com.turing.tshirtshop.entities.Review;

import java.util.List;

public class ProductReviewDto {
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
