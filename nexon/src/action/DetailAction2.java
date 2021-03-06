package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.BoardDto;

public class DetailAction2 implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		BoardDto board=dao.detailView(no);
		request.setAttribute("board", board);
		System.out.println("잘되나");
		return "edit.jsp";
	}

}
