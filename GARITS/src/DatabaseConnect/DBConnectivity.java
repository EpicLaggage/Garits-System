package DatabaseConnect;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DBConnectivity {

	/**
	 * 
	 * @param sql
	 */
	Connection connect(String sql);

	/**
	 * 
	 * @param connect
	 */
	ResultSet closeConnection(Connection connect);

	/**
	 * 
	 * @param sql
	 */
	ResultSet read(String sql);

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	int write(String sql, Connection conn);

}