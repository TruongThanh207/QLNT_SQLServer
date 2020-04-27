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
}
