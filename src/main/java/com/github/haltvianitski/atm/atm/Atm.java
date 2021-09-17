package com.github.haltvianitski.atm.atm;

import com.github.haltvianitski.atm.entity.Card;
import com.github.haltvianitski.atm.services.AtmService;
import com.github.haltvianitski.atm.services.BankService;

import java.util.Scanner;

public class Atm {
    private AtmService atmService;
    private BankService bankService;
    private Scanner scanner;

    public Atm() {
        this.bankService = new BankService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            System.out.println("Hello\n1-login\n0-exit");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    login();
                    break;
                case 0:
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("wrong input");
            start();
        }
    }

    public void login() {
        try {
            int select;
            Card card = bankService.login();
            boolean works = true;
            while (card != null & works) {
                atmService = new AtmService(card);
                System.out.println("\n1-Withdraw\n2-Deposit\n3-Balance check \n0-exit");
                select = scanner.nextInt();
                switch (select) {
                    case 1 -> System.out.println(atmService.withdraw());
                    case 2 -> System.out.println(atmService.deposit());
                    case 3 -> System.out.println(atmService.balanceCheck());
                    case 0 -> {
                        System.out.println("bye");
                        works = false;
                    }
                    default -> throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("wrong input");
            login();
        }
    }
}

