package in.him.Foodies_App_Be.service;

import in.him.Foodies_App_Be.io.CartRequest;
import in.him.Foodies_App_Be.io.CartResponse;

public interface CartService {
    CartResponse addToCart(CartRequest request);
    CartResponse getCart();
    void clearCart();
}
