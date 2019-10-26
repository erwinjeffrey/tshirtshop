package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.Constants.Constants;
import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.models.UniqueId;
import com.turing.tshirtshop.repositories.ShoppingCartRepository;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment env;

    @Override
    public ShoppingCart addProductToShoppingCart(Map<String, String> headers, ShoppingCart shoppingCart) {

        String token = headers.get("USER-KEY");
        String url = env.getProperty("base.url") + Constants.URI;
        UniqueId uniqueId = restTemplate.getForObject(
                url, UniqueId.class);

        //shoppingCartRepository.addProductToShoppingCart(uniqueId.getCart_id(),shoppingCart.getProduct_id(),shoppingCart.getAttributes());
        return null;
    }

    @Override
    public UniqueId generateUniqueId() {
        return  new UniqueId(UUID.randomUUID().toString());
    }
}
