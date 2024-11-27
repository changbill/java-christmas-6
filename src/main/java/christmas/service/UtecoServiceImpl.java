package christmas.service;

import christmas.model.OrderResponse;
import christmas.model.OrderResponseBuilder;
import christmas.model.Orders;
import christmas.model.discount.CalculateDiscount;
import christmas.repository.UtecoRepository;

public class UtecoServiceImpl implements UtecoService {
    private final UtecoRepository utecoRepository;

    public UtecoServiceImpl(UtecoRepository utecoRepository) {
        this.utecoRepository = utecoRepository;
    }

    public void setDateToVisit(String dateValue) {
        utecoRepository.setDateToVisit(UtecoParser.parseToDate(dateValue));
    }

    public OrderResponse getOrderResponse(String orderValue) {
        Orders orders = UtecoParser.parseToOrders(orderValue, utecoRepository.getDateToVisit());
        CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

        return new OrderResponseBuilder()
                .orderList(orders.getOrderList())
                .orderDate(orders.getOrderDate())
                .xmasDdayDiscount(calculateDiscount.getXmasDdayDiscount())
                .weekdaysDiscount(calculateDiscount.getWeekdaysDiscount())
                .weekendsDiscount(calculateDiscount.getWeekendsDiscount())
                .specialDiscount(calculateDiscount.getSpecialDiscount())
                .freeChampagne(calculateDiscount.isFreeChampagne())
                .build();
    }
}
