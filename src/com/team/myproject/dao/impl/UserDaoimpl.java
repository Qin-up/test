package com.team.myproject.dao.impl;

import com.team.myproject.dao.UserDao;
import com.team.myproject.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoimpl extends BaseDao implements UserDao {
    @Override
    public int addInfo(User user) {
        String sql="insert into user(userNum,userName,userAddr,creatDate,cardId) values(?,?,?,NOW(),?)";
        return this.executeUpdate(sql,new Object[]{user.getUserNum(),user.getUserName(),user.getUserAddr(),user.getCardId()});

    }

    @Override
    public int deleteInfo(int userId) {
        String sql="delete from user where userId=?";
        return this.executeUpdate(sql,new Object[]{userId});
    }

    @Override
    public int updateInfo(User user) {
        String sql="update user set userNum=?,userName=?,userAddr=?,creatDate=NOW(),cardId=? where userId=?";
        return this.executeUpdate(sql,new Object[]{user.getUserNum(),user.getUserName(),user.getUserAddr(),user.getCardId(),user.getUserId()});
    }

    @Override
    public User getInfo(int userId) {
        User user=null;
        try{
            String sql="select * from user where userId=?";
            ResultSet rs = this.executeQuery(sql, new Object[]{userId});
            while (rs.next()){
                user=new User();
                user.setUserId(rs.getInt(1));
                user.setUserNum(rs.getString(2));
                user.setUserName(rs.getString(3));
                user.setUserAddr(rs.getString(4));
                user.setCreateDate(rs.getString(5));
                user.setCardId(rs.getInt(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return user;
    }

    @Override
    public List<User> getAllInfo(int page, int pageSize, int cardsId, String name) {
        List<User> list=null;
        try{
            String sql="select user.*,cardName from `user` INNER JOIN card on `user`.cardId=card.cardId where 1=1 ";
            List param=new ArrayList();
            if (cardsId>0){
                sql=sql+" and `user`.cardId = ? ";
                param.add(cardsId);
            }

            if (name!=null && !name.equals("")){
                sql=sql+" and userName like ? ";
                param.add("%"+name+"%");
            }
            sql=sql+"  limit ?,? ";
            int str=(page-1)*pageSize;
            param.add(str);
            param.add(pageSize);
            Object[] params = param.toArray();
            ResultSet rs = this.executeQuery(sql, params);
            list=new ArrayList<>();
            while(rs.next()){
                User user=new User();
                user.setUserId(rs.getInt(1));
                user.setUserNum(rs.getString(2));
                user.setUserName(rs.getString(3));
                user.setUserAddr(rs.getString(4));
                user.setCreateDate(rs.getString(5));
                user.setCardId(rs.getInt(6));
                user.setCardName(rs.getString(7));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int getInfoPages(int pageSize, int cardsId, String name) {
        int totlePage=0;
        try{
            String sql="select count(1) from `user` where 1=1 ";
            List param=new ArrayList();
            if (cardsId>0){
                sql=sql+" and cardId=? ";
                param.add(cardsId);
            }

            if (name!=null){
                sql=sql+" and userName like ? ";
                param.add("%"+name+"%");
            }
            Object[] params = param.toArray();
            ResultSet rs = this.executeQuery(sql, params);
            if(rs.next()){
                int count = rs.getInt(1);
                totlePage=(int)Math.ceil(count*1.0/pageSize);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return totlePage;
    }
}
