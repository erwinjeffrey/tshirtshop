package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.CategoryDepartCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryDepartCusRepository extends JpaRepository<CategoryDepartCustom,Integer> {

    @Query(nativeQuery = true, value = "call catalog_get_department_categories(:inDepartmentId)")
    List<CategoryDepartCustom> findCategoriesByDepartment(@Param("inDepartmentId") int departmentId);
}
