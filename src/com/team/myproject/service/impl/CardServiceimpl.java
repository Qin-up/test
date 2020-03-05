package com.team.myproject.service.impl;

import com.team.myproject.dao.CardDao;
import com.team.myproject.dao.impl.CardDaoimpl;
import com.team.myproject.entity.Card;
import com.team.myproject.service.CardService;

import java.util.List;

public class CardServiceimpl implements CardService {
    CardDao cardDao=new CardDaoimpl();
    @Override
    public List<Card> getAll() {
        return cardDao.getAll();
    }
}
