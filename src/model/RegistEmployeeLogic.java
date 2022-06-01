package model;

import dao.EmployeeDAO;
import model.bean.Employee;

public class RegistEmployeeLogic implements CommandInterface {
	public void execute() {}
	public boolean execute(Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.insert(employee)) {
			return true;
		}
		return false;
	}
}
