package travel.management.system;

import java.sql.*;

public class Connectivity {
    Connection c;
    Statement s;
    Connectivity()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///TravelManagementSystem","root","Charan");
            s=c.createStatement();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
