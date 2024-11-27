package christmas.view;

import static christmas.constant.print.BenefitDetailsConstant.FREE_CHAMPAGNE_DESCRIPTION;
import static christmas.constant.print.BenefitDetailsConstant.SPECIAL_DISCOUNT_DESCRIPTION;
import static christmas.constant.print.BenefitDetailsConstant.WEEKDAYS_DISCOUNT_DESCRIPTION;
import static christmas.constant.print.BenefitDetailsConstant.WEEKENDS_DISCOUNT_DESCRIPTION;
import static christmas.constant.print.BenefitDetailsConstant.XMAS_D_DAY_DISCOUNT_DESCRIPTION;
import static christmas.constant.print.OrderPreviewConstant.BENEFIT_DETAILS;
import static christmas.constant.print.OrderPreviewConstant.DECEMBER_EVENT_BADGE;
import static christmas.constant.print.OrderPreviewConstant.ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT;
import static christmas.constant.print.OrderPreviewConstant.GIVEAWAY_MENU;
import static christmas.constant.print.OrderPreviewConstant.ORDER_MENU;
import static christmas.constant.print.OrderPreviewConstant.TOTAL_BENEFIT_AMOUNT;
import static christmas.constant.print.OrderPreviewConstant.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT;
import static christmas.constant.menu.UtecoMenu.CHAMPAGNE;

import christmas.constant.EventBadge;
import christmas.constant.print.BenefitDetailsConstant;
import christmas.model.OrderResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NOTHING = "없음";

    public void printOrderPreview(OrderResponse orderResponse) {
        printEventHeader(orderResponse);
        printOrderMenuList(orderResponse);
        printTotalOrderAmountBeforeDiscount(orderResponse);
        boolean isPresentChampagne = printGiveawayMenu(orderResponse);
        printBenefitDetails(orderResponse, isPresentChampagne);
        printTotalBenefitAmount(orderResponse, isPresentChampagne);
        printEstimatedPaymentAmountAfterDiscount(orderResponse, isPresentChampagne);
        printDecemberEventBadge(orderResponse, isPresentChampagne);
    }

    private void printEventHeader(OrderResponse orderResponse) {
        LocalDate orderDate = orderResponse.getOrderDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M월 d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        String formattedDate = orderDate.format(formatter);
        System.out.println(formattedDate + System.lineSeparator());
    }

    private void printOrderMenuList(OrderResponse orderResponse) {
        System.out.println(ORDER_MENU.getHeader());
        String collectedOrderMenuList = orderResponse.getOrderList().stream()
                .map(order -> String.format(ORDER_MENU.getValue(), order.getMenuName(), order.getOrderQuantity()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(collectedOrderMenuList + System.lineSeparator());
    }

    private void printTotalOrderAmountBeforeDiscount(OrderResponse orderResponse) {
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getHeader());
        System.out.printf(
                TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getValue() + System.lineSeparator(),
                getTotalOrderAmountBeforeDiscount(orderResponse)
        );
        System.out.println();
    }

    private boolean printGiveawayMenu(OrderResponse orderResponse) {
        System.out.println(GIVEAWAY_MENU.getHeader());
        if (orderResponse.isFreeChampagne()) {
            System.out.printf(GIVEAWAY_MENU.getValue() + System.lineSeparator(), CHAMPAGNE.getMenuName(), 1);
            System.out.println();
            return true;
        }
        System.out.println(NOTHING + System.lineSeparator());
        return false;
    }

    private void printBenefitDetails(OrderResponse orderResponse, boolean isPresentChampagne) {
        System.out.println(BENEFIT_DETAILS.getHeader());
        ifPresentGetDescription(XMAS_D_DAY_DISCOUNT_DESCRIPTION, orderResponse.getXmasDdayDiscount());
        ifPresentGetDescription(WEEKDAYS_DISCOUNT_DESCRIPTION, orderResponse.getWeekdaysDiscount());
        ifPresentGetDescription(WEEKENDS_DISCOUNT_DESCRIPTION, orderResponse.getWeekendsDiscount());
        ifPresentGetDescription(SPECIAL_DISCOUNT_DESCRIPTION, orderResponse.getSpecialDiscount());
        if (isPresentChampagne) {
            System.out.printf(
                    FREE_CHAMPAGNE_DESCRIPTION.getDescription() + ": %,d원" + System.lineSeparator(),
                    -CHAMPAGNE.getPrice()
            );
        }
        ifNothing(orderResponse, isPresentChampagne);
        System.out.println();
    }

    private void printTotalBenefitAmount(OrderResponse orderResponse, boolean isPresentChampagne) {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getHeader());
        int totalBenefitAmount = getTotalBenefitAmount(orderResponse, isPresentChampagne);

        System.out.printf(TOTAL_BENEFIT_AMOUNT.getValue() + System.lineSeparator(), totalBenefitAmount);
        System.out.println();
    }

    private void printEstimatedPaymentAmountAfterDiscount(OrderResponse orderResponse, boolean isPresentChampagne) {
        System.out.println(ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT.getHeader());
        System.out.printf(
                ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT.getValue() + System.lineSeparator(),
                getTotalOrderAmountBeforeDiscount(orderResponse) +
                        getTotalBenefitAmount(orderResponse, isPresentChampagne)
        );
        System.out.println();
    }

    private void printDecemberEventBadge(OrderResponse orderResponse, boolean isPresentChampagne) {
        System.out.println(DECEMBER_EVENT_BADGE.getHeader());
        System.out.printf(
                DECEMBER_EVENT_BADGE.getValue() + System.lineSeparator(),
                EventBadge.decideEventBadge(getTotalBenefitAmount(orderResponse, isPresentChampagne))
        );
        System.out.println();
    }

    private void ifPresentGetDescription(BenefitDetailsConstant benefitDetailsConstant, int discountAmount) {
        if (discountAmount != 0) {
            System.out.printf(
                    BENEFIT_DETAILS.getValue() + System.lineSeparator(),
                    benefitDetailsConstant.getDescription(),
                    discountAmount
            );
        }
    }

    private void ifNothing(OrderResponse orderResponse, boolean isPresentChampagne) {
        if (!isPresentChampagne &&
                orderResponse.getXmasDdayDiscount() == 0 &&
                orderResponse.getWeekdaysDiscount() == 0 &&
                orderResponse.getWeekendsDiscount() == 0 &&
                orderResponse.getSpecialDiscount() == 0) {
            System.out.println(NOTHING);
        }
    }

    private int getTotalOrderAmountBeforeDiscount(OrderResponse orderResponse) {
        return orderResponse.getOrderList().stream()
                .mapToInt(order -> order.getOrderQuantity() * order.getMenu().getPrice())
                .sum();
    }

    private int getTotalBenefitAmount(OrderResponse orderResponse, boolean isPresentChampagne) {
        int result = orderResponse.getXmasDdayDiscount() +
                orderResponse.getSpecialDiscount() +
                orderResponse.getWeekdaysDiscount() +
                orderResponse.getWeekendsDiscount();

        if (isPresentChampagne) {
            return result - CHAMPAGNE.getPrice();
        }

        return result;
    }
}
