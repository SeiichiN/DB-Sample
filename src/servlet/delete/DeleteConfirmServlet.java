package servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FindEmployeeByIdLogic;
import model.bean.Employee;
import util.Tool;


@WebServlet("/delete")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Tool.myParseInt(request.getParameter("id"), 0);
		String url = "";
		Employee emp = null;
		if (id > 0) {
			FindEmployeeByIdLogic logic = new FindEmployeeByIdLogic();
			emp = new Employee();
			logic.execute(id, emp);
			request.setAttribute("emp", emp);
			url = "/WEB-INF/jsp/delete/deleteConfirm.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			url = request.getContextPath() + "/list";
			response.sendRedirect(url);
		}
	}

}
