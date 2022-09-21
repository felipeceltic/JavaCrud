import java.sql.Connection;
import java.sql.DriverManager;

public class connectDAO {

  public static Connection conectaBD() {
    
    Connection conn = null;

    try {
      String url = "jdbc:mysql://localhost:3306/javacrud?user=root&password=";
      conn = DriverManager.getConnection(url);
      Class.forName("com.mysql.jdbc.Driver");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }
}