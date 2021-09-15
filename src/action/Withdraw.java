package action;

import api.IAction;
import facade.Atm;

import java.util.Scanner;

public class Withdraw implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter withdrawal amount");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        System.out.println(Atm.getInstance().withdraw(amount));
        new BalanceCheck().execute();
    }
}
