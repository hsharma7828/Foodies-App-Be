package in.him.Foodies_App_Be.service;

import com.razorpay.RazorpayException;
import in.him.Foodies_App_Be.io.OrderRequest;
import in.him.Foodies_App_Be.io.OrderResponse;

import java.util.List;
import java.util.Map;

public interface OrderService {

    OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException;

    void verifyPayment (Map<String, String> paymentData, String status);

    List<OrderResponse> getUserOrders();

    void removeOrder(String orderId);

    List<OrderResponse> getOrderOfAllUsers();

    void updateOrderStatus(String orderId, String status);
}
