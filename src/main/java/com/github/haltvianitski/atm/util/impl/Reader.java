package com.github.haltvianitski.atm.util.impl;

import com.github.haltvianitski.atm.entity.Card;

import java.util.List;

public interface Reader {
    public double readСash();
    public List<Card> readCardBase();

}
