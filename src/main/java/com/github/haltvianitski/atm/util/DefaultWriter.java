package com.github.haltvianitski.atm.util;

import com.github.haltvianitski.atm.entity.Card;
import com.github.haltvianitski.atm.runner.Runner;
import com.github.haltvianitski.atm.util.impl.Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.List;

public class DefaultWriter implements Writer {

    private final URL cashURL;
    private final URL cardBaseURL;

    public DefaultWriter() {
        ClassLoader classLoader = Runner.class.getClassLoader();
        cashURL = classLoader.getResource("atmCash.txt");
        cardBaseURL = classLoader.getResource("cardBase.txt");
    }

    @Override
    public void writCash(double cash) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cashURL.getFile()))) {
            bw.write(String.valueOf(cash));
        } catch (Exception e) {
            System.out.println("write cash exception " + e);
        }
    }

    @Override
    public void writeCardBase(List<Card> cardList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cardBaseURL.getFile()))) {
            String line = "";
            for (Card card : cardList) {
                line = line + card.toString() + "\n";
            }
            bw.write(line);
        } catch (Exception e) {
            System.out.println("write main.java.сom.github.haltvianitski.atm.db exception" + e);
        }
    }
}
