
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class GFG1
{
    public static void main(String arg[])
    {
        Connection connection = null;
        try 
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school1", "root", "Prince");
 
           
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from student1");
               // resultSet=statement.executeQuery("select address from student");
            int sno;
            String sname;
            String address;
            String name="divya";
            
            while (resultSet.next()) {
                if(resultSet.getString("sname").equals(name))
                {
                sno= resultSet.getInt("sno");
                sname = resultSet.getString("sname").trim();
               address=resultSet.getString("address");
                System.out.println("sno: " + sno + " sname : " + sname + " address : "+address);
            }
        
        
            else{
                System.out.println("Not found");
            }
        }
        
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) 
        {
            System.out.println(exception);
        }
    } 
}