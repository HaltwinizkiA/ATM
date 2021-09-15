package menu;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private String name;
    private List<MenuItem> menuItem;

    public Menu(String name, List<MenuItem> menuItem) {
        this.name = name;
        this.menuItem = menuItem;
    }

    public Menu() {
    }

    public String getNameMenuItem(int i) {
        return menuItem.get(i).getTitle();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }
}
