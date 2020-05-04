/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Room;
import Model.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NT_Thanh
 */
public class RoomsDAL {
     private DataAccess da;
    public RoomsDAL() {
        da = new DataAccess();
    }
    public ArrayList<Room> GetRoomAll()
    {
        
        ArrayList<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        
        try {
            Statement st = da.getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Room s = new Room();
                s.setId(rs.getInt("id"));
                s.setTen(rs.getString("tenphong"));
                s.setSonguoi(rs.getInt("so_nguoi_hien_co"));
                s.setPrice(rs.getInt("giaphong"));
                s.setChisodien_old(rs.getInt("chisodien_old"));
                s.setChisodien_new(rs.getInt("chisodien_new"));
                s.setChisonuoc_old(rs.getInt("chisonuoc_old"));
                s.setChisonuoc_new(rs.getInt("chisonuoc_new"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    public int CountRoom() {
        String sql = "Select count(*) from rooms";
        int count = 0;
        try
        {
            Statement st = da.getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                return rs.getInt(1);
            }
            return count;
           
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
        return count;
    }

    public boolean AddRoom(String name, int price) {
        int id;
        int idroom = GetMaxIndexRooms();
        if(idroom<0)
        {
            id = 1;
        }
        else{
            id = idroom+1;
        }
        if(FindRoom(name))
        {
            return false;
        }
        
        String sql = "Insert into Rooms (ID,TENPHONG,SO_NGUOI_HIEN_CO,GIAPHONG,CHISODIEN_OLD, CHISODIEN_NEW, CHISONUOC_OLD, CHISONUOC_NEW)"
                + "values('"+id+"','"+name+"','"+0+"' ,'"+price+"','"+0+"','"+0+"','"+0+"','"+0+"')";
        try
        {
            Statement st = da.getConn().createStatement();
            st.executeUpdate(sql);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
        return false;
    }
    public int GetMaxIndexRooms()
    {
        String sql = "Select MAX(id) from Rooms";
        try
        {
            Statement st = da.getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                return rs.getInt(1);
            }
            return -1;
           
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
        return -1;
    }
    public boolean FindRoom(String name)
    {
        String sql = "SELECT count(*) FROM rooms where TENPHONG='"+name+"'";
        try
        {
            Statement st = da.getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }
        return false;
    }
}
