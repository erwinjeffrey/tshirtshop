package com.turing.tshirtshop.repositories;

import com.sun.org.apache.regexp.internal.RE;
import com.turing.tshirtshop.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(nativeQuery = true, value = "call catalog_get_product_reviews(:inProductId)")
    List<Review> searchReviewByProduct(@Param("inProductId") int productId);

    @Query(nativeQuery = true, value = "call catalog_create_product_review(:inCustomerId, :inProductId, :inReview, :inRating")
    Review saveReview(@Param("inCustomerId") int customerId,@Param("inProductId") int productId, @Param("inReview")String review ,@Param("inRating") int rating);
}