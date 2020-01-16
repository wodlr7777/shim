package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;

public class Replyboard implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		List<Dto> board=dao.detailreply(no);
		request.setAttribute("board", board);
		return "replyboard.jsp";
	}

}
