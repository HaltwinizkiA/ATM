package menu;

public class Navigator {

    private Menu currentMenu;

    public Navigator(Menu currentMenu) {
        setCurrentMenu(currentMenu);
    }

    public void printMenu() {

        for (int i = 0; i < this.currentMenu.getMenuItem().size(); i++) {
            System.out.println(i + " - " + this.currentMenu.getNameMenuItem(i));
        }
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void navigate(int index) {
        try {
            this.currentMenu.getMenuItem().get(index).doAction();
            setCurrentMenu(this.currentMenu.getMenuItem().get(index).getNextMenu());
        } catch (Exception e) {

            System.out.println("navigator error" + e);
        }
    }

    public void update() {
        System.out.println("You in " + currentMenu.getName());
    }
}
