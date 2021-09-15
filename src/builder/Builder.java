package builder;

import action.*;
import menu.Menu;
import menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private final Menu mainMenu;
    private final Menu rootMenu;

    public Builder() {
        this.mainMenu = new Menu();
        this.rootMenu = new Menu();
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void buildMainMenu() {
        List<MenuItem> mainMenuItems = new ArrayList<>();
        mainMenu.setName("Main menu");
        mainMenuItems.add(new MenuItem("Check Balance", new BalanceCheck(), mainMenu));
        mainMenuItems.add(new MenuItem("Deposit", new Deposit(), mainMenu));
        mainMenuItems.add(new MenuItem("Withdraw", new Withdraw(), mainMenu));
        mainMenuItems.add(new MenuItem("Exit", new Exit(), null));
        mainMenu.setMenuItem(mainMenuItems);

        List<MenuItem> rootMenuItems = new ArrayList<>();
        rootMenu.setName("ATM");
        rootMenuItems.add(new MenuItem("Login", new Login(), mainMenu));
        rootMenuItems.add(new MenuItem("Exit", new Exit(), null));
        rootMenu.setMenuItem(rootMenuItems);


    }

}
