package servlet.util;

import javax.servlet.http.HttpServletRequest;

import model.FindDeptByIdLogic;
import model.FindGenderByIdLogic;
import model.FindStateByIdLogic;
import model.bean.Dept;
import model.bean.Employee;
import model.bean.Gender;
import model.bean.State;
import util.Tool;

public class EmployeeFromParam {
	public void set(Employee emp, HttpServletRequest request) {
		int id = Tool.myParseInt(request.getParameter("id"), 0);
		emp.setId(id);
		
		emp.setName(request.getParameter("name"));
		emp.setPass(request.getParameter("pass"));

		Gender gender = new Gender();
		gender.setGid(request.getParameter("gender"));
		FindGenderByIdLogic genderLogic = new FindGenderByIdLogic();
		genderLogic.execute(gender);
		emp.setGender(gender);
		
		emp.setBirthday(request.getParameter("birthday"));
		
		State state = new State();
		state.setSid(request.getParameter("state"));
		FindStateByIdLogic stateLogic = new FindStateByIdLogic();
		stateLogic.execute(state);
		emp.setState(state);
		
		Dept dept = new Dept();
		dept.setDid(request.getParameter("dept"));
		FindDeptByIdLogic deptLogic = new FindDeptByIdLogic();
		deptLogic.execute(dept);
		emp.setDept(dept);
	}
}
