package christmas.controller;

import christmas.model.OrderResponse;
import christmas.service.UtecoService;

public class UtecoController {
    private final UtecoService utecoService;

    public UtecoController(UtecoService utecoService) {
        this.utecoService = utecoService;
    }

    public void setDateToVisit(String dateValue) {
        utecoService.setDateToVisit(dateValue);
    }

    public OrderResponse getOrderResponse(String orderValue) {
        return utecoService.getOrderResponse(orderValue);
    }
}
