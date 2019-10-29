package com.turing.tshirtshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")

@NamedStoredProcedureQueries({


        @NamedStoredProcedureQuery(
                name = "addProductToCart",
                procedureName = "shopping_cart_add_product",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCartId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inProductId", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inAttributes", type = String.class)

                }),
        @NamedStoredProcedureQuery(
                name = "updateShoppingCart",
                procedureName = "shopping_cart_update",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inItemId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inQuantity", type = Integer.class)
                }),
        @NamedStoredProcedureQuery(
                name = "emptyShoppingCart",
                procedureName = "shopping_cart_empty",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inCartId", type = String.class)
                }),
        @NamedStoredProcedureQuery(
                name = "removeShoppingCartProd",
                procedureName = "shopping_cart_remove_product",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inItemId", type = String.class)
                })
})

public class ShoppingCart {
    @Id
    @Column(name = "item_id")
    private String itemId;
    @Column(name = "cart_id")
    private String cartId;

    private String attributes;
    private int product_id;
    private int quantity;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
