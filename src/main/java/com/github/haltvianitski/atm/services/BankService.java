package com.github.haltvianitski.atm.services;

import com.github.haltvianitski.atm.entity.Card;
import com.github.haltvianitski.atm.util.impl.FileReader;
import com.github.haltvianitski.atm.util.impl.FileWriter;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankService {
    private List<Card> cardList;

    public BankService() {
        FileReader reader = new FileReader();
        cardList = reader.readCardBase();
    }

    public Card login() {
        Scanner scanner = new Scanner(System.in);
        int attemptCount = 0;
        Card selectedCard = null;
        String cardNum = "";
        while (selectedCard == null) {
            System.out.println("Enter card num");
            cardNum = scanner.next();
            if (!verify(cardNum)) {
                System.out.println("!wrong card num!");

                continue;
            }
            if (checkLockingCard(cardNum)) {
                System.out.println("Card is locked Bye)");
                return null;
            }

            selectedCard = selectCard(cardNum);
        }
        while (attemptCount < 3) {
            System.out.println("\nEnter password");
            int password;
            try {
                password = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(" Error password example-XXXX \n" +
                        "password consists of characters only ");
                attemptCount++;
                continue;
            }

            if (selectedCard.getPassword() == password) {
                System.out.println("Hello " + selectedCard.getOwnersName());
                return selectedCard;
            }
            attemptCount++;
        }
        if (attemptCount == 3) {
            lockCard(cardNum);
            System.out.println("\n" +
                    "password entry limit exceeded\n" +
                    "your card is blocked");
        }

        System.out.println("\nexceeded the number of attempts\n");
        return null;
    }

    private Card selectCard(String cardNum) {
        for (Card card : cardList) {
            if (card.getNumber().equals(cardNum)) {
                return card;
            }
        }
        return null;
    }

    public boolean verify(String cardNum) {
        String[] cardNumbers = cardNum.split("-");
        for (String numb : cardNumbers) {
            if (numb.length() != 4 & Pattern.compile("\\D").matcher(numb).find()) {
                return false;
            }
        }
        return true;
    }

    public void updateCard(Card upCard) {
        for (Card card : cardList) {
            if (card.getNumber() == upCard.getNumber()) {
                card = upCard;
                FileWriter dw = new FileWriter();
                dw.writeCardBase(cardList);
            }
        }
    }

    public boolean checkLockingCard(String cardNum) {
        for (Card card : cardList) {
            if (card.getNumber().equals(cardNum)) {
                return true;
            }
        }
        return false;

    }

    public void lockCard(String cardNum) {
        for (Card card : cardList) {
            if (card.getNumber().equals(cardNum)) {
                card.setStatus(false);
                updateCard(card);
            }
        }
    }
}
