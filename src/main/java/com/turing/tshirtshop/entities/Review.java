package com.turing.tshirtshop.entities;

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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    private String review;
    private int rating;
    private String created_on;
    private int customer_id;
    private int product_id;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
