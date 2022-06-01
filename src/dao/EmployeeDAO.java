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
import util.Tool;

public class EmployeeDAO {
	
	private final String SQL_FIND_ALL =
			"SELECT * FROM findAll_v";
	
//			"SELECT id, pass, name, gender_id, g.gname AS gname," 
//        + " TO_CHAR(e.birthday, 'yyyy/MM/dd') AS birthday," 	
//	       + " state_id, s.sname AS sname," 
//	       + " dept_id, d.dname AS dname"
//			+ " FROM employee e"
//			+ "  INNER JOIN gender g"
//			+ "  ON e.gender_id = g.gid"
//			+ "    INNER JOIN state s"
//			+ "    on e.state_id = s.sid"
//			+ "      LEFT OUTER JOIN department d"
//			+ "      ON e.dept_id = d.did";

	private final String SQL_FIND_ALL_LIMIT =
			"SELECT id, pass, name, gender_id, gname," 
			+ " birthday," 
	       + " state_id, sname," 
	       + " dept_id, dname"
			+ " FROM findAll_v"
	       + " LIMIT ?, ?";
			
	private final String SQL_FIND_BY_ID =
			"SELECT id, pass, name, gender_id, gname, birthday," 
	       + " state_id, sname," 
	       + " dept_id, dname"
			+ " FROM findAll_v"
	       + " WHERE id = ?";

	private final String SQL_FIND_BY_NAME =
			"SELECT id, pass, name, gender_id, gname, birthday," 
	       + " state_id, sname," 
	       + " dept_id, dname"
			+ " FROM findAll_v"
	       + " WHERE name like ?";
	
	private final String SQL_INSERT =
			"INSERT INTO employee (name, pass, gender_id, state_id, birthday, dept_id) "
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	
	public int getSize() {
		int count = 0;
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {

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
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String gid = rs.getString("gender_id");
				String gname = rs.getString("gname");
				Gender gender = new Gender(gid, gname);
				String birthday = rs.getString("birthday");
				String sid = rs.getString("state_id");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee employee = new Employee(id, pass, name, gender, birthday, state, dept);
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
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
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
				String birthday = rs.getString("birthday");
				String sid = rs.getString("state_id");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee employee = new Employee(id, pass, name, gender, birthday, state, dept);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return employeeList;
 	}

	public Employee findEmployeeById(int _id) {
		Employee employee = null;
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setInt(1, _id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String gid = rs.getString("gender_id");
				String gname = rs.getString("gname");
				Gender gender = new Gender(gid, gname);
				String birthday = rs.getString("birthday");
				String sid = rs.getString("state_id");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				employee = new Employee(id, pass, name, gender, birthday, state, dept);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return employee;
	}

	public List<Employee> findEmployeeByName(String _name) {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_NAME);
			pStmt.setString(1, "%" + _name + "%");
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String gid = rs.getString("gender_id");
				String gname = rs.getString("gname");
				Gender gender = new Gender(gid, gname);
				String birthday = rs.getString("birthday");
				String sid = rs.getString("state_id");
				String sname = rs.getString("sname");
				State state = new State(sid, sname);
				String did = rs.getString("dept_id");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee employee = new Employee(id, pass, name, gender, birthday, state, dept);
				empList.add(employee);
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e.getMessage());
		}
		return empList;
	}
	
	public boolean insert(Employee employee) {
		try (Connection conn = DriverManager.getConnection(DBConst.DB_URL, DBConst.DB_USER, DBConst.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_INSERT);
			pStmt.setString(1, employee.getName());
			pStmt.setString(2, employee.getPass());
			pStmt.setString(3, employee.getGender().getGid());
			pStmt.setString(4, employee.getState().getSid());
			String birthday = employee.getBirthday();
			pStmt.setString(5, Tool.convDate(birthday));
			pStmt.setString(6, employee.getDept().getDid());
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			// throw new SQLRuntimeException(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
