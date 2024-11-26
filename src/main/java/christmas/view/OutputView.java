package christmas.view;

import static christmas.constant.OrderStatusConstant.BENEFIT_DETAILS;
import static christmas.constant.OrderStatusConstant.DECEMBER_EVENT_BADGE;
import static christmas.constant.OrderStatusConstant.ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT;
import static christmas.constant.OrderStatusConstant.GIVEAWAY_MENU;
import static christmas.constant.OrderStatusConstant.ORDER_MENU;
import static christmas.constant.OrderStatusConstant.TOTAL_BENEFIT_AMOUNT;
import static christmas.constant.OrderStatusConstant.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT;

import christmas.model.OrderResponse;

public class OutputView {

    public void printEventHeader() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printOrderPreview(OrderResponse orderResponse) {
        System.out.println(ORDER_MENU.getHeader());
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getHeader());
        System.out.println(GIVEAWAY_MENU.getHeader());
        System.out.println(BENEFIT_DETAILS.getHeader());
        System.out.println(TOTAL_BENEFIT_AMOUNT.getHeader());
        System.out.println(ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT.getHeader());
        System.out.println(DECEMBER_EVENT_BADGE.getHeader());
    }
}
