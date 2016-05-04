
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

//Соединение с СУБД с использованием пула физическиз соединений
//Плюс пример получения данных о БД

package slqQueryForMSDatabase;
import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;
import java.sql.*;
import javax.naming.NamingException;
/**
 *
 * @author Lartsev
 */
public class MySQL4 {
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static private String SQL;

    /**
     *
     * @param SQL
     * @throws NamingException
     */
    public static void  MyQuery (String SQL) throws NamingException {
        //String connectionUrl = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=My_DataBase;integratedSecurity=true;";
        //Ога) организуем пул физических соединений - средствами драйвера от Мелкомягких
        SQLServerConnectionPoolDataSource sds = new SQLServerConnectionPoolDataSource();
        
        sds.setServerName("");
        sds.setInstanceName("SQLEXPRESS");
        sds.setPortNumber(1433);
        sds.setDatabaseName("paymentsDB_v_1_3_SQLExpress");
        sds.setUser("sa");
        sds.setPassword("qwerty");
        sds.setIntegratedSecurity(false);
        sds.setDescription("проба");
        
        /*  InitialContext ct = new InitialContext();
        ct.bind("jdbc/My_DataBase", sds);
        SQLServerDataSource ds = new SQLServerDataSource();
        //ds.setURL(connectionUrl);
        ct.bind("jdbc/My_DataBase", ds);
        */
        
        try {
            Connection con = sds.getConnection();
            con.setAutoCommit(false);
            // Create and execute an SQL statement that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            //Iterate through the data in the result set and display it.
            con.commit(); //This commits the transaction and starts a new one.
            
            //Узнаем немножечко информации о нашей базе данных
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println(dmd.getDatabaseProductName());
            System.out.println(dmd.getDatabaseProductVersion());
            System.out.println(dmd.getDefaultTransactionIsolation());
            System.out.println(dmd.getDriverVersion());
            System.out.println(dmd.getSQLKeywords()+"\n");
            System.out.println(dmd.getURL()+"\n");
            
            while (rs.next()) {
                System.out.println(rs.getString(1).trim() +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getString(4) );
            }
            stmt.close(); //This turns off the transaction.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        finally {
            if (rs != null) try { rs.close(); } catch(SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch(SQLException e) {}
            if (con != null) try { con.close(); } catch(SQLException e) {}
        }
    }
   
    /**
     *
     * @param args
     * @throws NamingException
     */
    public static void main(String[] args) throws NamingException {
        SQL = "SELECT * FROM users;";
        MyQuery (SQL);
        SQL = "SELECT * FROM creditCards;";
        MyQuery (SQL);
        }
    }
