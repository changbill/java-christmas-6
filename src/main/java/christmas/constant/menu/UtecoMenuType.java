package christmas.constant.menu;

import static christmas.constant.menu.UtecoMenu.BARBECUE_RIBS;
import static christmas.constant.menu.UtecoMenu.BUTTON_MUSHROOM_SOUP;
import static christmas.constant.menu.UtecoMenu.CAESAR_SALAD;
import static christmas.constant.menu.UtecoMenu.CHAMPAGNE;
import static christmas.constant.menu.UtecoMenu.CHOCOLATE_CAKE;
import static christmas.constant.menu.UtecoMenu.ICE_CREAM;
import static christmas.constant.menu.UtecoMenu.RED_WINE;
import static christmas.constant.menu.UtecoMenu.SEAFOOD_PASTA;
import static christmas.constant.menu.UtecoMenu.TAPAS;
import static christmas.constant.menu.UtecoMenu.T_BONE_STEAK;
import static christmas.constant.menu.UtecoMenu.XMAS_PASTA;
import static christmas.constant.menu.UtecoMenu.ZERO_COKE;

import christmas.exception.InvalidOrderException;
import java.util.Arrays;
import java.util.List;

public enum UtecoMenuType {
    APPETIZER(List.of(BUTTON_MUSHROOM_SOUP, TAPAS, CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK, BARBECUE_RIBS, SEAFOOD_PASTA, XMAS_PASTA)),
    DESSERT(List.of(CHOCOLATE_CAKE, ICE_CREAM)),
    BEVERAGE(List.of(ZERO_COKE, RED_WINE, CHAMPAGNE)),
    ;

    private final List<UtecoMenu> menus;

    UtecoMenuType(List<UtecoMenu> menus) {
        this.menus = menus;
    }

    public static UtecoMenuType getMenuType(UtecoMenu menu) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.menus.contains(menu))
                .findFirst()
                .orElseThrow(InvalidOrderException::new);
    }

}
