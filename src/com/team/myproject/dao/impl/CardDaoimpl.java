package com.team.myproject.dao.impl;

import com.team.myproject.dao.CardDao;
import com.team.myproject.entity.Card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDaoimpl extends BaseDao implements CardDao{

    @Override
    public List<Card> getAll() {
        List<Card> list=null;
        try {
            String sql="select * from card ";
            ResultSet rs = this.executeQuery(sql, null);
            list=new ArrayList<>();
            while(rs.next()){
                Card card=new Card();
                card.setCardId(rs.getInt(1));
                card.setCardName(rs.getString(2));
                list.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }
}
