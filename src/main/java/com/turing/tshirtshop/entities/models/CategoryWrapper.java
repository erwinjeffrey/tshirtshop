package com.turing.tshirtshop.entities.models;

import com.turing.tshirtshop.entities.Category;

import java.util.List;

public class CategoryWrapper {

    private List<Category> rows;

    public List<Category> getRows() {
        return rows;
    }

    public void setRows(List<Category> rows) {
        this.rows = rows;
    }
}
