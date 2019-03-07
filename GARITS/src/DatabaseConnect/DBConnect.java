package DatabaseConnect;

import java.sql.Connection;
import java.sql.ResultSet;

public class DBConnect implements DBConnectivity {

	/**
	 * 
	 * @param db
	 */
	public DBConnect DBConnect(String db) {
		// TODO - implement DBConnect.DBConnect
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public Connection connect(String sql) {
		// TODO - implement DBConnect.connect
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param connect
	 */
	public ResultSet closeConnection(Connection connect) {
		// TODO - implement DBConnect.closeConnection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public ResultSet read(String sql) {
		// TODO - implement DBConnect.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 * @param conn
	 */
	public int write(String sql, Connection conn) {
		// TODO - implement DBConnect.write
		throw new UnsupportedOperationException();
	}

	public void AddUser() {
		// TODO - implement DBConnect.AddUser
		throw new UnsupportedOperationException();
	}

	public void RemoveUser() {
		// TODO - implement DBConnect.RemoveUser
		throw new UnsupportedOperationException();
	}

	public void Backup() {
		// TODO - implement DBConnect.Backup
		throw new UnsupportedOperationException();
	}

	public void Restore() {
		// TODO - implement DBConnect.Restore
		throw new UnsupportedOperationException();
	}

}