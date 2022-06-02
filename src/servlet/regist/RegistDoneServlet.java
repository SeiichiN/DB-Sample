package servlet.regist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegistEmployeeLogic;
import model.bean.Employee;
import servlet.util.EmployeeFromParam;
import util.Const;


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

		String url = "/WEB-INF/jsp/registUpdate/ruDone.jsp";
		request.setAttribute("h1word", Const.H1WORD_REGIST);
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
