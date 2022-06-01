package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.SQLRuntimeException;
import model.bean.State;

public class StateDAO {
	private final String SQL_FIND_ALL = "SELECT sid, sname FROM state";
	private final String SQL_FIND_BY_ID = "SELECT sid, sname FROM state WHERE sid = ?";

	public List<State> findAll() {
		List<State> stateList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String sid = rs.getString("sid");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				stateList.add(state);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return stateList;
 	}

	public State findStateById(String _sid) {
		State state = null;
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, _sid);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String sid = rs.getString("sid");
				String sname = rs.getString("sname");
				state = new State(sid, sname);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return state;
 	}
}
