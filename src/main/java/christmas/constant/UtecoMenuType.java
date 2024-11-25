package christmas.constant;

import static christmas.constant.UtecoMenu.BARBECUE_RIBS;
import static christmas.constant.UtecoMenu.BUTTON_MUSHROOM_SOUP;
import static christmas.constant.UtecoMenu.CAESAR_SALAD;
import static christmas.constant.UtecoMenu.CHAMPAGNE;
import static christmas.constant.UtecoMenu.CHOCOLATE_CAKE;
import static christmas.constant.UtecoMenu.ICE_CREAM;
import static christmas.constant.UtecoMenu.RED_WINE;
import static christmas.constant.UtecoMenu.SEAFOOD_PASTA;
import static christmas.constant.UtecoMenu.TAPAS;
import static christmas.constant.UtecoMenu.T_BONE_STEAK;
import static christmas.constant.UtecoMenu.XMAS_PASTA;
import static christmas.constant.UtecoMenu.ZERO_COKE;

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
