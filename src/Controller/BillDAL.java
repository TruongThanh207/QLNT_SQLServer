/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author NT_Thanh
 */
public class BillDAL {
    private DataAccess da;
    public BillDAL() {
        da = new DataAccess();
    }

    public int FindBill(int phong) {
       String sql ="Select count(*) from Bills where ID = '"+phong+"'";
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
