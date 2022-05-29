package servlet.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Employee;
import util.Tool;
import model.FindEmployeeByIdLogic;

@WebServlet("/search_id")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Tool.myParseInt(request.getParameter("id"), 0);
		FindEmployeeByIdLogic logic = new FindEmployeeByIdLogic();
		Employee emp = new Employee();
		logic.execute(id, emp);
		request.setAttribute("emp", emp);
		String url = "/WEB-INF/jsp/search/searchIdDone.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}

}
