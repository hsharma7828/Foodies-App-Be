package in.him.Foodies_App_Be.service;

import com.razorpay.RazorpayException;
import in.him.Foodies_App_Be.io.OrderRequest;
import in.him.Foodies_App_Be.io.OrderResponse;

public interface OrderService {

    OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException;
}
