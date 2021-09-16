package menu;

import action.Exit;
import action.Login;
import api.IAction;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.io.Serializable;
import java.util.List;


public class Menu implements Serializable {
    String name;
    List<MenuItem> menuItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}

