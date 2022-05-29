package model;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;
import model.bean.Employee;

public class FindAllEmployeeLogic implements CommandInterface {
	List<Employee> empList = new ArrayList<>();
	
	public void execute() {
		EmployeeDAO dao = new EmployeeDAO();
		empList = dao.findAll();
	}
	
	public List<Employee> getEmpList() {
		execute();
		return empList;
	}
}
