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
import model.bean.Employee;
import model.bean.Gender;
import model.bean.State;

public class EmployeeDAO {
	private final String DB_URL = "jdbc:h2:tcp://localhost/~/h2data/dbsample";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private final String SQL_FIND_ALL =
			"SELECT id, pass, name, gender_id, g.gname AS gname," 
			+ " timestampdiff(YEAR, e.birthday, curdate()) AS age," 
	       + " state_id, s.sname AS sname," 
	       + " dept_id, d.dname AS dname"
			+ " FROM employee e"
			+ "  INNER JOIN gender g"
			+ "  ON e.gender_id = g.gid"
			+ "    INNER JOIN state s"
			+ "    on e.state_id = s.sid"
			+ "      LEFT OUTER JOIN department d"
			+ "      ON e.dept_id = d.did";

	private final String SQL_FIND_ALL_LIMIT =
			"SELECT id, pass, name, gender_id, gname," 
			+ " age," 
	       + " state_id, sname," 
	       + " dept_id, dname"
			+ " FROM findAll_v"
	       + " LIMIT ?, ?";
			
	
	public int getSize() {
		int count = 0;
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT COUNT(*) FROM employee";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
                count = rs.getInt(1);  // 1番目のカラムを取得
            } else {
                return 0;
            }
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return count;
	}	
	
	public List<Employee> findAll() {
		List<Employee> employeeList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String gid = rs.getString("gender_id");
				String gname = rs.getString("gname");
				Gender gender = new Gender(gid, gname);
				int age = rs.getInt("age");
				String sid = rs.getString("state_id");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee employee = new Employee(id, pass, name, gender, age, state, dept);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new SQLRuntimeException(e.getMessage());
		}
		
		return employeeList;
 	}

	public List<Employee> findAll(int skip, int perPage) {
		List<Employee> employeeList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL_LIMIT);
			pStmt.setInt(1, skip);
			pStmt.setInt(2, perPage);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String gid = rs.getString("gender_id");
				String gname = rs.getString("gname");
				Gender gender = new Gender(gid, gname);
				int age = rs.getInt("age");
				String sid = rs.getString("state_id");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee employee = new Employee(id, pass, name, gender, age, state, dept);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return employeeList;
 	}

}
