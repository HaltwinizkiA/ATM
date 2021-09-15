package action;

import api.IAction;
import facade.Atm;

import java.util.Scanner;

public class Login implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int attemptCount = 0;

        while (true) {
            System.out.println("enter card num in the format «ХХХХ-ХХХХ-ХХХХ-ХХХХ»");
            String cardNum = scanner.next();
            if (!Atm.getInstance().verification(cardNum)) {
                System.out.println("wrong card num");
                continue;
            }
            if (!Atm.getInstance().checkLockingCard(cardNum)) {
                System.out.println("card locked");
                break;
            }
            System.out.println("enter password XXXX");
            int password = scanner.nextInt();
            if (String.valueOf(password).length() != 4) {
                System.out.println("wrong password");
                continue;
            }
            if (Atm.getInstance().login(cardNum, password) != null) {
                System.out.println("login  successful");
                break;
            }
            if (attemptCount >= 2) {
                System.out.println(Atm.getInstance().lockCard(cardNum));
                break;
            }
            System.out.println("\n" +
                    "password or name is not correct");
            attemptCount++;
        }
    }
}
