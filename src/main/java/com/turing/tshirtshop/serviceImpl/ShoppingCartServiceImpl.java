package com.turing.tshirtshop.serviceImpl;

import com.turing.tshirtshop.Constants.Constants;
import com.turing.tshirtshop.custom.ShoppingCartProduct;
import com.turing.tshirtshop.entities.ShoppingCart;
import com.turing.tshirtshop.models.ShoppingMessage;
import com.turing.tshirtshop.models.UniqueId;
import com.turing.tshirtshop.repositories.ShoppingCartProductReposity;
import com.turing.tshirtshop.repositories.ShoppingCartRepository;
import com.turing.tshirtshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ShoppingCartProductReposity shoppingCartProductReposity;


    @Override
    public List<ShoppingCart> addProductToShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.addProductToShoppingCart(shoppingCart.getCartId(),shoppingCart.getProduct_id(),shoppingCart.getAttributes());
        return shoppingCartRepository.findByCartId(shoppingCart.getCartId());
    }

    @Override
    public UniqueId generateUniqueId() {
        return  new UniqueId(UUID.randomUUID().toString());
    }

    @Override
    public List<ShoppingCartProduct> findShoppingCartProduct(String cartId) {
        return shoppingCartProductReposity.findShoppingCartProduct(cartId);
    }

    @Override
    public ShoppingCart updateShoppingCart(String itemId, int quantity) {
        shoppingCartRepository.updateShoppingCart(itemId,quantity);
        return shoppingCartRepository.findByItemId(itemId);
    }

    @Override
    public List<ShoppingCart> emptyShoppingCart(String cartId) {
        shoppingCartRepository.emptyShoppingCart(cartId);
        return new ArrayList<>();
    }

    @Override
    public ShoppingMessage removeShoppingCartProd(String itemId) {
        shoppingCartRepository.removeShoppingCartProd(itemId);
        return new ShoppingMessage("Product with Id: " +itemId + " has been removed");
    }
}
