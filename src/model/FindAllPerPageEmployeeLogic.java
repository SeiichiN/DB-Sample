package model;

import java.util.List;

import dao.EmployeeDAO;
import model.bean.Employee;

public class FindAllPerPageEmployeeLogic implements CommandInterface {
	// List<Employee> empList = new ArrayList<>();
	
	public void execute() {}
	
	public void execute(int skip, int perPage, List<Employee> empList) {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> _empList = dao.findAll(skip, perPage);
		for (Employee emp : _empList) {
			empList.add(emp);
		}
	}
	
	/*
	public List<Employee> getEmpList(int skip, int perPage) {
		execute(skip, perPage);
		return empList;
	}
	*/
}
