package com.github.haltvianitski.atm.services;


import com.github.haltvianitski.atm.entity.Card;
import com.github.haltvianitski.atm.util.DefaultReader;
import com.github.haltvianitski.atm.util.DefaultWriter;

import java.util.Scanner;

public class AtmService {

    private Card card;
    private double cash;
    private DefaultReader dr;
    private DefaultWriter dw;
    private Scanner scanner;


    public AtmService(Card card) {
        dr = new DefaultReader();
        this.cash = dr.readСash();
        this.card = card;
        this.scanner = new Scanner(System.in);
        this.dr = new DefaultReader();
        this.dw = new DefaultWriter();
    }

    public String balanceCheck() {
        return card.getBalance().toString();
    }

    public String deposit() {
        double deposit = 0;
        while (true) {
            System.out.println("enter deposit max 1000000");
            try {
                deposit = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("wrong deposit");
                continue;
            }
            break;
        }
        card.setBalance(card.getBalance() + deposit);
        BankService bankService = new BankService();
        bankService.updateCard(card);
        return "successful\n" + balanceCheck();
    }

    public String withdraw() {
        while (true) {
            System.out.println("enter amount");
            double draw;
            try {
                draw = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("wrong input");
                continue;
            }
            if (draw > card.getBalance() || draw > cash) {
                System.out.println("wrong amount\ninsufficient funds\n");
            }
            card.setBalance(card.getBalance() - draw);
            cash = -draw;
            dw.writCash(cash);
            BankService bank = new BankService();
            bank.updateCard(card);
            return "\nsuccessful";
        }
    }


}



