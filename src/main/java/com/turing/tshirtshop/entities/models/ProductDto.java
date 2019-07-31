package com.turing.tshirtshop.entities.models;

import com.turing.tshirtshop.entities.Product;

import java.util.List;

public class ProductDto {

    private PaginationMetaDto  paginationMeta;

    private List<Product> rows;

    public PaginationMetaDto getPaginationMeta() {
        return paginationMeta;
    }

    public void setPaginationMeta(PaginationMetaDto paginationMeta) {
        this.paginationMeta = paginationMeta;
    }

    public List<Product> getRows() {
        return rows;
    }

    public void setRows(List<Product> rows) {
        this.rows = rows;
    }
}
