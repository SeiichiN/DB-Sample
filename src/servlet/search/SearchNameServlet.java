package servlet.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FindEmployeeByNameLogic;
import model.bean.Employee;

@WebServlet("/search_name")
public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = getParam(request);
		FindEmployeeByNameLogic logic = new FindEmployeeByNameLogic();
		List<Employee> empList = logic.execute(name);
		request.setAttribute("empList", empList);
		String url = "/WEB-INF/jsp/search/searchNameDone.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}
	
	private String getParam(HttpServletRequest request) {
		String name = request.getParameter("name");
		if (name == null || name.length() < 1) {
			name = "猿飛佐助";
		}
		return name;
	}

}
