package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FindAllPerPageEmployeeLogic;
import model.GetSizeEmployeeLogic;
import model.bean.Employee;
import model.bean.PageInfo;

@WebServlet("/list")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// データの全件数を取得
		GetSizeEmployeeLogic logic = new GetSizeEmployeeLogic();
		PageInfo pageInfo = getPageInfoFromSession(request);
		logic.execute(pageInfo);
		setCurPage(pageInfo, request);
		
		// 全件数がわかれば、JSPにわたすページ情報を作成できる。
		session.setAttribute("pageInfo", pageInfo);		
		
		FindAllPerPageEmployeeLogic empLogic = new FindAllPerPageEmployeeLogic();
		List<Employee> empList = empLogic.getEmpList(pageInfo.getSkip(), pageInfo.getPerPage());
		request.setAttribute("empList", empList);

		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * ユーザーからの入力を受け取り、カレントページをセットする。
	 * @param pageInfo
	 * @param request
	 */
	private void setCurPage(PageInfo pageInfo, HttpServletRequest request) {
		int curPage = myParseInt(request.getParameter("page"), 1);
		if (curPage < 1) { curPage = 1; }
		if (curPage > pageInfo.getLast()) { curPage = pageInfo.getLast(); }
		// スキップするデータ数もセットされる
		pageInfo.setCurrent(curPage);
	}
	
	/**
	 * 引数 _value の文字(数値) を int にする。
	 * もしも エラーが起こったら、def にする。
	 * @param _value 数値にしたい文字列
	 * @param def デフォルト値
	 * @return
	 */
	private int myParseInt(String _value, int def) {
		int value = 0;
		try {
			value = Integer.parseInt(_value);
		} catch (NumberFormatException e) {
			value = def;
		}
		return value;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo pageInfo = getPageInfoFromSession(request);
		int per_page = myParseInt(request.getParameter("per_page"), pageInfo.getPerPage());
		pageInfo.setPerPage(per_page);
		response.sendRedirect(request.getContextPath() + "/list");
	}
	
	private PageInfo getPageInfoFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		PageInfo pageInfo = (PageInfo) session.getAttribute("pageInfo");
		if (pageInfo == null) {
			pageInfo = new PageInfo();
		}
		return pageInfo;
	}
}
