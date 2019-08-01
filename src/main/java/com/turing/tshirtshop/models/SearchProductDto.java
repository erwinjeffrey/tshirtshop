package com.turing.tshirtshop.models;

import com.turing.tshirtshop.entities.Product;

import java.util.List;

public class SearchProductDto {

    private List<Product> rows;

    public List<Product> getRows() {
        return rows;
    }

    public void setRows(List<Product> rows) {
        this.rows = rows;
    }
}
