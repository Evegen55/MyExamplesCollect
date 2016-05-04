/*
 * Copyright (C) 2016 Lartsev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package slqQueryForMSDatabase;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lartsev
 */
public class SQL_2 {
    
    public void doQuery(String SQL) {
        
        SQLServerConnectionPoolDataSource sds = new SQLServerConnectionPoolDataSource();
        sds.setServerName("");
        sds.setInstanceName("SQLEXPRESS");
        sds.setPortNumber(1433);
        sds.setDatabaseName("paymentsDB_v_1_3_SQLExpress");
        sds.setUser("sa");
        sds.setPassword("qwerty");
        sds.setIntegratedSecurity(false);
        sds.setDescription("проба");
        
        //get first connection from connection pool
        try (Connection con = sds.getConnection();) {
            con.setAutoCommit(false);
            // Create and execute an SQL statement that returns some data.
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            //Iterate through the data in the result set and display it.
            con.commit(); //This commits the transaction and starts a new one.
            while (rs.next()) {
                System.out.println(rs.getString(1).trim() +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getString(4) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQL_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //get second connection from connection pool
        try (Connection con = sds.getConnection();) {
            //Get some meta info about DB
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println(dmd.getDatabaseProductName());
            System.out.println(dmd.getDatabaseProductVersion());
            System.out.println(dmd.getDefaultTransactionIsolation());
            System.out.println(dmd.getDriverVersion());
            System.out.println(dmd.getSQLKeywords()+"\n");
            System.out.println(dmd.getURL()+"\n");
        } catch (SQLException ex) {
            Logger.getLogger(SQL_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        String SQL = "SELECT * FROM users;";
        SQL_2 query = new SQL_2();
        query.doQuery(SQL);
    }
    
}
