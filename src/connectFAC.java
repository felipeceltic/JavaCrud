import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class connectFAC {

  public DataSource ds;

  public connectFAC() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/javacrud?useTimezone=true&ServerTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("");
		cpds.setMaxPoolSize(15);
		this.ds = cpds;
	}
	
	public Connection ConnectDbMysql() throws SQLException {
		return ds.getConnection();
	}

  public static Connection conectaBD() {
    return null;
  }
}
