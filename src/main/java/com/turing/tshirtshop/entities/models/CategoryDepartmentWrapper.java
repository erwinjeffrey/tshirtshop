package com.turing.tshirtshop.entities.models;

import com.turing.tshirtshop.custom.CategoryDepartCustom;

import java.util.List;

public class CategoryDepartmentWrapper {

    private List<CategoryDepartCustom> rows;

    public List<CategoryDepartCustom> getRows() {
        return rows;
    }

    public void setRows(List<CategoryDepartCustom> rows) {
        this.rows = rows;
    }
}
