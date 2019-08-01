package com.turing.tshirtshop.models;

public class PaginationMetaDto {

    private int currentPage;
    private int currentPageSize;
    private int totalPages;
    private int totalRecords;

    public PaginationMetaDto(int currentPage, int currentPageSize, int totalPages, int totalRecords) {
        this.currentPage = currentPage;
        this.currentPageSize = currentPageSize;
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPageSize() {
        return currentPageSize;
    }

    public void setCurrentPageSize(int currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
}
