/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;

/**
 *
 * @author NT_Thanh
 */
public class DataAccess {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    
    public DataAccess() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNT;username=sa;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
