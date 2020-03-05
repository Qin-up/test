package com.team.myproject.dao;

import com.team.myproject.entity.Card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CardDao {
    public List<Card> getAll();
}
