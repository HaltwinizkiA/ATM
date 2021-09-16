package com.github.haltvianitski.atm.util;

import com.github.haltvianitski.atm.entity.Card;

import java.util.List;

public interface Reader {
    double readСash();

    List<Card> readCardBase();

}
