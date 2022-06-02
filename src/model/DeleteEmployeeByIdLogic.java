package model;

import dao.EmployeeDAO;
import model.bean.Employee;

public class DeleteEmployeeByIdLogic implements CommandInterface {
	public void execute() {}
	
	public boolean execute(int id) {
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.delete(id)) {
			return true;
		}
		return false;
	}
}
