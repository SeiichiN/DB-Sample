package model;

import dao.DeptDAO;
import model.bean.Dept;

public class FindDeptByIdLogic implements CommandInterface {
	public void execute() {}
	public void execute(Dept dept) {
		DeptDAO dao = new DeptDAO();
		Dept _dept = dao.findDeptById(dept.getDid());
		dept.setDname(_dept.getDname());
	}
}
