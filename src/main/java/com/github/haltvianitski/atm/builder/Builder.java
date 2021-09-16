package com.github.haltvianitski.atm.builder;

import com.github.haltvianitski.atm.entity.Card;
import com.github.haltvianitski.atm.services.AtmService;
import com.github.haltvianitski.atm.services.BankService;

import java.util.Scanner;

public class Builder {
    AtmService atmService;
    BankService bankService;

    public Builder() {
        this.bankService = new BankService();
    }

    public void build() {
        int select = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHello\n1-login\n0-exit");
            try {
                select = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("wrong input");
                continue;
            }
        }
        Card card = bankService.login();
        boolean works = true;
        while (card != null & works) {
            atmService = new AtmService(card);
            System.out.println("\n1-Withdraw\n2-Deposit\n3-Balance check \n0-exit");
            select = 0;
            try {
                select = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("wrong input");
                continue;
            }
            if (select > 3) {
                System.out.println("wrong input");
                continue;
            }
            switch (select) {
                case 1:
                    System.out.println(atmService.withdraw());
                    break;
                case 2:
                    System.out.println(atmService.deposit());
                    break;
                case 3:
                    System.out.println(atmService.balanceCheck());
                    break;
                case 0:
                    System.out.println("bye");
                    works = false;
                    break;
            }
        }
    }
}
