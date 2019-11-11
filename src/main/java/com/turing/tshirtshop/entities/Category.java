package com.turing.tshirtshop.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.turing.tshirtshop.customValidation.ValidCategory;
import com.turing.tshirtshop.customValidation.ValidDepartment;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "category")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name="productCategory",
                procedureName = "catalog_get_categories_for_product",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "inProductId",type = Integer.class)
        }, resultClasses = {Category.class}),

        @NamedStoredProcedureQuery(name="departmentCategories",
                procedureName = "catalog_get_department_categories",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN,name = "inDepartmentId",type = Integer.class)
                })
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    private String name;
    private String description;
    @Column(name = "department_id")
    @Pattern(regexp = "\\d+", message = "The ID is not a number")
    @ValidDepartment
    private int departmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    @JsonProperty("category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("department_id")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
