package com.turing.tshirtshop.entities;

import javax.persistence.*;

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
    private int category_id;
    private String name;
    private String description;
    private int department_id;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
