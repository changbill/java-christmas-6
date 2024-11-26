package christmas.service;

import christmas.model.OrderResponse;
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
        return OrderResponse.from(
                UtecoParser.parseToOrders(orderValue, utecoRepository.getDateToVisit())
        );
    }
}
