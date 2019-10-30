package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

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
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;
    private String review;
    private int rating;
    @Column(name = "created_on")
    private String createdOn;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "product_id")
    private int productId;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @JsonSerialize
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

    @JsonSerialize
    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @JsonSerialize
    @JsonProperty("customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @JsonSerialize
    @JsonProperty("product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
