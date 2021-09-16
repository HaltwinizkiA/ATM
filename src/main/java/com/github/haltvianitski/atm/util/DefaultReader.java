package com.github.haltvianitski.atm.util;

import com.github.haltvianitski.atm.entity.Card;
import com.github.haltvianitski.atm.runner.Runner;
import com.github.haltvianitski.atm.util.impl.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DefaultReader implements Reader {
    private final URL cashPath;
    private final URL cardBasePath;

    public DefaultReader() {
        ClassLoader classLoader = Runner.class.getClassLoader();
        cashPath = classLoader.getResource("atmCash.txt");
        cardBasePath = classLoader.getResource("cardBase.txt");
    }

    @Override
    public double readСash() {
        double cash = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(cashPath.getFile()))) {
            cash = Double.parseDouble(br.readLine());
        } catch (Exception e) {
            System.out.println("get cash exception " + e);
        }
        return cash;
    }

    @Override
    public List<Card> readCardBase() {
        List<Card> cardList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(cardBasePath.getFile()))) {
            String line = br.readLine();
            while (line != null) {
                String[] readline = line.split(" ");
                cardList.add(new Card(readline[0], readline[1], readline[2], readline[3], Double.parseDouble(readline[4]), Integer.parseInt(readline[5]), Boolean.parseBoolean(readline[6])));
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("reading card list error " + e);
        }
        return cardList;
    }
}
