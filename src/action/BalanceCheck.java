package action;

import api.IAction;
import facade.Atm;

public class BalanceCheck implements IAction {
    @Override
    public void execute() {
        System.out.println("BALANCE " + Atm.getInstance().balanceCheck());
    }
}
