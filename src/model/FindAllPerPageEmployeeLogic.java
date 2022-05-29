package model;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;
import model.bean.Employee;

public class FindAllPerPageEmployeeLogic implements CommandInterface {
	List<Employee> empList = new ArrayList<>();
	
	public void execute() {}
	
	public void execute(int skip, int perPage) {
		EmployeeDAO dao = new EmployeeDAO();
		empList = dao.findAll(skip, perPage);
	}
	
	public List<Employee> getEmpList(int skip, int perPage) {
		execute(skip, perPage);
		return empList;
	}
}
