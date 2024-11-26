package christmas.service;

import christmas.model.OrderResponse;

public interface UtecoService {
    void setDateToVisit(String dateValue);

    OrderResponse getOrderResponse(String orderValue);
}
