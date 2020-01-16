package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;
import paging.Paging;

public class ListAction2 implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		String paramNo=request.getParameter("pageNo");
		int pageNo=1;
		if(paramNo!=null) {
			pageNo=Integer.parseInt(paramNo);
		}
		System.out.println(pageNo);
		int rowTotal=dao.count();
		Paging page=new Paging(pageNo,rowTotal);
		List<Dto> board=dao.view2(page);
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		return "board2.jsp";
	}

}
