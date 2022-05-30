package model;

import java.util.List;

import dao.EmployeeDAO;
import exception.NotEmptyRuntimeException;
import model.bean.Employee;

public class FindEmployeeByNameLogic implements CommandInterface {
	public void execute() {}
	
	public void execute(String name, List<Employee> empList) {
		if (empList.size() > 0) {
			throw new NotEmptyRuntimeException("empList");
		}
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> _empList = dao.findEmployeeByName(name);
		for (Employee emp : _empList) {
			empList.add(emp);
		}
	}
}
