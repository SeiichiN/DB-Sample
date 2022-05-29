package test;

import java.util.ArrayList;
import java.util.List;

import model.FindAllEmployeeLogic;
import model.bean.Employee;

public class FindAllTest {

	public static void main(String[] args) {
		FindAllEmployeeLogic logic = new FindAllEmployeeLogic();
		List<Employee> empList = new ArrayList<>();
		empList = logic.getEmpList();
		for (Employee emp : empList) {
			System.out.println(emp);
		}

	}

}
