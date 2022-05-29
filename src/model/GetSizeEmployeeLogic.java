package model;

import dao.EmployeeDAO;
import model.bean.PageInfo;

public class GetSizeEmployeeLogic implements CommandInterface {
	public void execute() {}
	
	public void execute(PageInfo info) {
		EmployeeDAO dao = new EmployeeDAO();
		info.setDataMax(dao.getSize());
	}
}
