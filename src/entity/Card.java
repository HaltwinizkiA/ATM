package entity;

public class Card {
    private Double balance;
    private String ownersName;
    private String number;
    private String validity;
    private String iban;
    private int password;
    private boolean status;

    public Card(String number, String ownersName, String validity, String iban, Double balance, int password, boolean status) {
        this.balance = balance;
        this.ownersName = ownersName;
        this.number = number;
        this.validity = validity;
        this.iban = iban;
        this.password = password;
        this.status = status;
    }

    public Card() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
