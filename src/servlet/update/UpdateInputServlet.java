package servlet.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FindEmployeeByIdLogic;
import model.bean.Employee;
import util.Tool;

@WebServlet("/edit")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Tool.myParseInt(request.getParameter("id"), 0);
		String url = "";
		Employee emp = null;
		if (id == 0) {
			url = "/WEB-INF/jsp/empList.jsp";
		} else {
			FindEmployeeByIdLogic logic = new FindEmployeeByIdLogic();
			emp = new Employee();
			logic.execute(id, emp);
			request.setAttribute("emp", emp);
			url = "/WEB-INF/jsp/update/updateInput.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
