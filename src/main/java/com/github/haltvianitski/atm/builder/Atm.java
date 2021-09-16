package com.github.haltvianitski.atm.builder;

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

        System.out.println("\nHello\n1-login\n0-exit");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                run();
                break;
            case 0:
                break;
            default:
                start();
        }}catch (Exception e){
            System.out.println("wrong input");
            start();
        }
    }

    public void run() {
        try {
            int select;
            Card card = bankService.login();
            boolean works = true;
            while (card != null & works) {
                atmService = new AtmService(card);
                System.out.println("\n1-Withdraw\n2-Deposit\n3-Balance check \n0-exit");
                select = 0;
                select = scanner.nextInt();
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
                    default:
                        throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("wrong input");
            run();
        }
    }
}

