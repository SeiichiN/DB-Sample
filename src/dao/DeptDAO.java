package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.SQLRuntimeException;
import model.bean.Dept;

public class DeptDAO {
	private final String SQL_FIND_ALL = "SELECT did, dname FROM department";
	private final String SQL_FIND_BY_ID = "SELECT did, dname FROM department WHERE did = ?";

	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return deptList;
 	}

	public Dept findDeptById(String _did) {
		Dept dept = null;
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, _did);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				dept = new Dept(did, dname);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return dept;
 	}
}
