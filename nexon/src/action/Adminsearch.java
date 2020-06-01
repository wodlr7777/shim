package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.BoardDto;

public class Adminsearch implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search=request.getParameter("search");
		System.out.println(search);
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		List<BoardDto> board=dao.search(search);
		request.setAttribute("board",board);
		return "board2.jsp";
	}

}
