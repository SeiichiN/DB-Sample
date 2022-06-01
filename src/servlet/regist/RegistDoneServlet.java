package servlet.regist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FindGenderByIdLogic;
import model.RegistEmployeeLogic;
import model.bean.Employee;
import model.bean.Gender;
import servlet.util.EmployeeFromParam;
import servlet.util.Validator;


@WebServlet("/registDone")
public class RegistDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		EmployeeFromParam fromParam = new EmployeeFromParam();
		fromParam.set(employee, request);
		
		String msg = "";
		RegistEmployeeLogic logic = new RegistEmployeeLogic();
		if (logic.execute(employee)) {
			msg = "登録しました。";
		} else {
			msg = "登録に失敗しました。";
		}

		String url = "/WEB-INF/jsp/regist/registDone.jsp";
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
