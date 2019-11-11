package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.turing.tshirtshop.customValidation.ValidCustomer;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "review")

@NamedStoredProcedureQuery(name="out_review_id",
                           procedureName = "catalog_create_product_review",
                           parameters = {
                              @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCustomerId",type = Integer.class),
                                   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inProductId",type = Integer.class),
                                   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inReview",type = String.class),
                                   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inRating",type = Integer.class),
                                   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "out_reviewId",type = Integer.class)

                           })
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Size( min = 1, message = "Please write a review")
    private String review;

    @Range(min = 1, max = 5, message = "rating must be between 1 and 5")
    private int rating;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "customer_id")

    @ValidCustomer
    private int customerId;

    @Column(name = "product_id")
    private int productId;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @JsonProperty("review_id")
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
