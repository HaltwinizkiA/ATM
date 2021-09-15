package action;

import api.IAction;
import facade.Atm;

public class Exit implements IAction {
    @Override
    public void execute() {
        Atm.getInstance().writeCardList();
        Atm.getInstance().writeCash();
        System.out.println("BYE");
    }
}
