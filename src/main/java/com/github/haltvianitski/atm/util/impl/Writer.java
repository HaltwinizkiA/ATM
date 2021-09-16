package com.github.haltvianitski.atm.util.impl;

import com.github.haltvianitski.atm.entity.Card;

import java.util.List;

public interface Writer {
    public void writCash(double cashl);

    public void writeCardBase(List<Card> cardList);
}
