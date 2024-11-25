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
        controller.setDateToVisit(inputView.readDate());
    }
}
