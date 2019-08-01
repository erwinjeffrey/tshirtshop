package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {

    @Override
    Page<Product> findAll(Pageable pageable);

    @Query(nativeQuery = true,
            value = "call catalog_search(:inSearchString, :inAllWords, :inShortProductDescriptionLength, :inProductsPerPage, :inStartItem)")
    List<Product> searchProducts(@Param("inSearchString") String searchItem, @Param("inAllWords") String allWorldStatus,
                                 @Param("inShortProductDescriptionLength") int descriptionLenght,
                                 @Param("inProductsPerPage") int limit, @Param("inStartItem") int page) ;

    @Query(nativeQuery = true, value = "call catalog_get_products_in_category(:inCategoryId,:inShortProductDescriptionLength," +
            ":inProductsPerPage, :inStartItem)")
    List<Product> searchProductsByCategory(@Param("inCategoryId") int categoryId, @Param("inShortProductDescriptionLength") int descriptionLength,
                                           @Param("inProductsPerPage") int limit,@Param("inStartItem") int page);

    @Query(nativeQuery = true, value = "call catalog_get_products_on_department(:inDepartmentId,:inShortProductDescriptionLength," +
            ":inProductsPerPage, :inStartItem)")
    List<Product> searchProductsByDepartment(@Param("inDepartmentId") int departmentId, @Param("inShortProductDescriptionLength") int descriptionLength,
                                           @Param("inProductsPerPage") int limit,@Param("inStartItem") int page);
}
