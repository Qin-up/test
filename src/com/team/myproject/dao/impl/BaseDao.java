package com.team.myproject.dao.impl;

import java.sql.*;

/**
 * @author 王建兵
 * @Classname BaseDao
 * @Description TODO
 * @Date 2019/11/24 10:15
 * @Created by Administrator
 */
//工具类(人?)
public class BaseDao {
    //定义连接数据库的参数
    private final String driverClass="com.mysql.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/infodb";
    private final String username="root";
    private final String password="";


    //定义连接对象
    private Connection con=null;
    //定义执行对象
    private PreparedStatement ps=null;
    //定义结果对象
    private ResultSet rs=null;

    /**
     * 获取连接对象
     * @return
     */
    public Connection getConn(){
        try {
            Class.forName(this.driverClass);
            this.con=DriverManager.getConnection(this.url,this.username,this.password);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 执行添加，修改，删除 executeUpdate
     * @param sql  允许参数化sql
     * @param params 表示参数化sql中的参数值
     * @return 影响行数
     */
    public  int executeUpdate(String sql,Object [] params){
        try {
            this.getConn();
             //预执行对象
            ps=con.prepareStatement(sql);
            if(params!=null){
               for(int i=0;i<params.length;i++){
                  ps.setObject(i+1,params[i]);
               }
            }
            //执行添加，修改，删除
            int temp=ps.executeUpdate();
            //关闭资源
            this.closeAll();
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 执行查询
     * @param selectSql  允许参数化sql的查询语句
     * @param params 参数
     * @return 结果集
     */
    public ResultSet executeQuery(String selectSql,Object [] params){
        try {
            this.getConn();
             //预执行对象
            ps=con.prepareStatement(selectSql);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //执行添加，修改，删除
            rs=ps.executeQuery();
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭所有资源
     */
    public void closeAll(){
        try {
            if(rs!=null){
                this.rs.close();this.rs=null;  //关闭结果
            }
            if(ps!=null){
                this.ps.close();this.ps=null;  //关闭执行对象
            }
             if(con!=null){
                 this.con.close();this.con=null;  //关闭连接
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
