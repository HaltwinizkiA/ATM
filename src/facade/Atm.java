package facade;


import entity.Card;
import menu.Menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Atm {
    private static Atm atmFacade;
    private final List<Card> cardList;
    private Card selectedCard;
    private double cash;

    public Atm() {
        cardList = getCardList();
        this.cash = readCash();

    }

    public static Atm getInstance() {
        if (atmFacade == null) {
            atmFacade = new Atm();
        }
        return atmFacade;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Double writeCash() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\37533\\Projects\\ATM\\src\\db\\atmCash.txt"))) {
            bw.write(String.valueOf(cash));
        } catch (Exception e) {
            System.out.println("write cash exception " + e);
        }
        return null;
    }

    public Double readCash() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\37533\\Projects\\ATM\\src\\db\\atmCash.txt"))) {
            double money = Double.parseDouble(br.readLine());
            return money;
        } catch (Exception e) {
            System.out.println("get cash exception " + e);
        }
        return null;
    }

    public String writeCardList() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\37533\\Projects\\ATM\\src\\db\\database.txt"))) {
            String line = "";
            for (Card card : cardList) {
                line = line + card.getNumber() + " " + card.getOwnersName() + " " + card.getValidity() + " " + card.getIban() + " " + card.getBalance() + " " + card.getPassword() + card.isStatus() + "\n";
            }
            bw.write(line);
            return line;
        } catch (Exception e) {
            System.out.println("write db exception" + e);
        }
        return null;
    }

    public List<Card> getCardList() {
        List<Card> cardList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\37533\\Projects\\ATM\\src\\db\\database.txt"))) {
            String line = br.readLine();
            while (line != null) {
                String[] readline = line.split(" ");
                cardList.add(new Card(readline[0], readline[1], readline[2], readline[3],
                        Double.parseDouble(readline[4]), Integer.parseInt(readline[5]), Boolean.parseBoolean(readline[6])));
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("reading card list error " + e);
        }
        return cardList;
    }

    public String balanceCheck() {
        return selectedCard.getBalance().toString();
    }

    public String deposit(double deposit) {
        selectedCard.setBalance(selectedCard.getBalance() + deposit);
        return "successful\n" + balanceCheck();
    }

    public String withdraw(double draw) {
        if (draw > selectedCard.getBalance()) {
            return "\n" +
                    "insufficient funds ";
        }
        selectedCard.setBalance(selectedCard.getBalance() - draw);
        return "\nsuccessful";
    }

    public Card login(String cardNum, int password) {

        for (Card card : cardList) {
            if (card.getNumber().equals(cardNum) & card.getPassword() == password) {
                selectedCard = card;

            }
        }
        return selectedCard;
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

    public void lockCard(String cardNum) {
        for (Card card : cardList) {
            if (card.getNumber().equals(cardNum)) {
                card.setStatus(false);
            }
        }

    }

    public boolean checkLockingCard(String cardNum) {
        for (Card card : cardList) {
            if (card.getNumber().equals(cardNum)) {
                return card.isStatus();
            }
        }
        return false;
    }
}



