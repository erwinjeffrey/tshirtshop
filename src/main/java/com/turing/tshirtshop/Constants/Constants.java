package com.turing.tshirtshop.Constants;

public class Constants {
    public static final String URI="shoppingcart/generateUniqueId";

    // url
    public static final String LOGIN_URL = "/customers/login";
    public static final String DEPARTMENT_URL="/departments/**";
    public static final String CATEGORY_URL="/categories/**";
    public static final String ATTRIBUTE_URL="/attributes/**";
    public static final String PRODUCTS_URL="/products/**";

    public static final String APPLICATION_TYPE = "application/json";

    public static final String[] AUTH_WHITELIST = {

            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };

}
