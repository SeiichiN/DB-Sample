package servlet.update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UpdateEmployeeLogic;
import model.bean.Employee;
import servlet.util.EmployeeFromParam;
import util.Const;


@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		EmployeeFromParam fromParam = new EmployeeFromParam();
		fromParam.set(employee, request);
		
		String msg = "";
		UpdateEmployeeLogic logic = new UpdateEmployeeLogic();
		if (logic.execute(employee)) {
			msg = "更新しました。";
		} else {
			msg = "更新に失敗しました。";
		}

		String url = "/WEB-INF/jsp/registUpdate/registUpdateDone.jsp";
		request.setAttribute("h1word", Const.H1WORD_UPDATE);
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
