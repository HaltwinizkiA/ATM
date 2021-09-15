package action;

import api.IAction;
import facade.Atm;

import java.util.Scanner;

public class Deposit implements IAction {
    @Override
    public void execute() {
        while (true) {
            System.out.println("enter money \nmaximum 1,000,000");
            Scanner scanner = new Scanner(System.in);
            double money = scanner.nextDouble();
            if (money > 1000000) {
                System.out.println("\n" +
                        "too large deposit maximum 1,000,000");
                continue;
            }
            System.out.println(Atm.getInstance().deposit(money));
            new BalanceCheck().execute();
            break;
        }
    }
}
