package menu;

import api.IAction;

public class MenuItem {
    IAction action;
    String name;

    public MenuItem(IAction action, String name) {
        this.action = action;
        this.name = name;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
