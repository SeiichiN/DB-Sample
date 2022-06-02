package model;

import dao.EmployeeDAO;
import model.bean.Employee;

public class UpdateEmployeeLogic implements CommandInterface {
	public void execute() {}
	public boolean execute(Employee employee) {
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.update(employee)) {
			return true;
		}
		return false;
	}
}
