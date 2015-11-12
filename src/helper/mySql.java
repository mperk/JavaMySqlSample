package helper;
import java.sql.*;

public class mySql {
	public static void main(String[] args){
		Connection baglanti=null;
        Statement statement=null;
        String query="select * from projects";
         
        try
        {
            //Driverý ekliyoruz.
            Class.forName("com.mysql.jdbc.Driver"); 
                 
            baglanti=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/redmine_ykm","root","");
                 
            statement=baglanti.createStatement();
             
            ResultSet result=statement.executeQuery(query);
            ResultSetMetaData meta=result.getMetaData();
                 
            for(int i=1;i<=meta.getColumnCount();i++)
                System.out.printf( "%-8s\t", meta.getColumnName( i ) );
            System.out.println();
 
                 
            while(result.next())
            {
                for ( int i = 1; i <= 4; i++ )
                     System.out.printf( "%-8s\t", result.getObject( i ) );
                System.out.println();
     
            }
        }
 
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch(ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
        finally
        {
            try
            {
                baglanti.close();
                statement.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
	}
}
