package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.SQLRuntimeException;
import model.bean.Gender;

public class GenderDAO {
	private final String SQL_FIND_ALL = "SELECT gid, gname FROM gender";
	private final String SQL_FIND_BY_ID = "SELECT gid, gname FROM gender WHERE gid = ?";

	public List<Gender> findAll() {
		List<Gender> genderList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String gid = rs.getString("gid");
				String gname = rs.getString("gname");
				Gender gender = new Gender(gid, gname);
				genderList.add(gender);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return genderList;
 	}

	public Gender findGenderById(String _gid) {
		Gender gender = null;
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, _gid);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String gid = rs.getString("gid");
				String gname = rs.getString("gname");
				gender = new Gender(gid, gname);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return gender;
 	}
}
