package com.turing.tshirtshop.repositories;

import com.turing.tshirtshop.custom.AttributeCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttributeCustomRepository extends JpaRepository<AttributeCustom, Integer> {

    @Query(nativeQuery = true, value = "call catalog_get_product_attributes(:inProductId)")
  List<AttributeCustom> findAllProductAttribute(@Param("inProductId") int productId);

}
