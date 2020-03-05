package com.team.myproject.service;
import com.team.myproject.entity.User;

import java.util.List;

public interface UserService {
        public int addInfo(User user);

        public int deleteInfo(int userId);

        public int updateInfo(User user);

        //获取单条
        public User getInfo(int userId);

        //查询当前页的数据    添加查询条件(推荐用类类型)
        public List<User> getAllInfo(int page, int pageSize, int cardsId, String name);

        //查询总页数
        public int getInfoPages(int pageSize, int cardsId, String name);

}
