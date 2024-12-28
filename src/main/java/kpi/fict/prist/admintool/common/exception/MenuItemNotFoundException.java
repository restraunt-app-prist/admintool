package kpi.fict.prist.admintool.common.exception;

public class MenuItemNotFoundException extends RuntimeException {
    public MenuItemNotFoundException(String menuItemId) {
        super("Menu item not found by id: " + menuItemId);
    }
}
