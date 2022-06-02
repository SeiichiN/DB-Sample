package servlet.delete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmployeeByIdLogic;
import model.UpdateEmployeeLogic;
import model.bean.Employee;
import servlet.util.EmployeeFromParam;
import util.Const;
import util.Tool;


@WebServlet("/deleteDone")
public class DeleteDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Tool.myParseInt(request.getParameter("id"), 0);
		if (id > 0) {
			String msg = "";
			DeleteEmployeeByIdLogic logic = new DeleteEmployeeByIdLogic();
			if (logic.execute(id)) {
				msg = "削除しました。";
			} else {
				msg = "削除に失敗しました。";
			}
			String url = "/WEB-INF/jsp/registUpdate/ruDone.jsp";
			request.setAttribute("h1word", Const.H1WORD_DELETE);
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}

	}

}
