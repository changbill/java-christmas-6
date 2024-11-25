package christmas.model;

import static christmas.model.UtecoMenu.BARBECUE_RIBS;
import static christmas.model.UtecoMenu.BUTTON_MUSHROOM_SOUP;
import static christmas.model.UtecoMenu.CAESAR_SALAD;
import static christmas.model.UtecoMenu.CHAMPAGNE;
import static christmas.model.UtecoMenu.CHOCOLATE_CAKE;
import static christmas.model.UtecoMenu.ICE_CREAM;
import static christmas.model.UtecoMenu.RED_WINE;
import static christmas.model.UtecoMenu.SEAFOOD_PASTA;
import static christmas.model.UtecoMenu.TAPAS;
import static christmas.model.UtecoMenu.T_BONE_STEAK;
import static christmas.model.UtecoMenu.XMAS_PASTA;
import static christmas.model.UtecoMenu.ZERO_COKE;

import java.util.List;

public enum UtecoMenuType {
    APPETIZER(List.of(BUTTON_MUSHROOM_SOUP, TAPAS, CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK, BARBECUE_RIBS, SEAFOOD_PASTA, XMAS_PASTA)),
    DESERT(List.of(CHOCOLATE_CAKE, ICE_CREAM)),
    BEVERAGE(List.of(ZERO_COKE, RED_WINE, CHAMPAGNE)),
    ;

    private final List<UtecoMenu> menus;

    UtecoMenuType(List<UtecoMenu> menus) {
        this.menus = menus;
    }

    public boolean isAppetizer(UtecoMenu menu) {
        return APPETIZER.menus.contains(menu);
    }

    public boolean isMain(UtecoMenu menu) {
        return MAIN.menus.contains(menu);
    }

    public boolean isDesert(UtecoMenu menu) {
        return DESERT.menus.contains(menu);
    }

    public boolean isBeverage(UtecoMenu menu) {
        return BEVERAGE.menus.contains(menu);
    }
}
