package com.github.haltvianitski.atm.util;

import com.github.haltvianitski.atm.entity.Card;

import java.util.List;

public interface Writer {
    void writCash(double cash);

    void writeCardBase(List<Card> cardList);
}
