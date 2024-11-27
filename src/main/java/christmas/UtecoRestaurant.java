package christmas;

import christmas.controller.UtecoController;
import christmas.repository.UtecoRepository;
import christmas.service.UtecoServiceImpl;
import christmas.view.InputView;
import christmas.view.OutputView;

public class UtecoRestaurant {
    private final InputView inputView;
    private final OutputView outputView;
    private final UtecoController controller;

    public UtecoRestaurant() {
        inputView = new InputView();
        outputView = new OutputView();
        controller = new UtecoController(new UtecoServiceImpl(new UtecoRepository()));
    }

    public void run() {
        inputDate();
        inputOrder();
    }

    private void inputDate() {
        while(true) {
            try {
                controller.setDateToVisit(inputView.readDate());
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputOrder() {
        while(true) {
            try {
                outputView.printOrderPreview(controller.getOrderResponse(inputView.readOrder()));
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
