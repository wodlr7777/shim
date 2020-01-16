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

public class UserInfoAction implements Action {

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
		int rowTotal=dao.count();
		Paging page=new Paging(pageNo,rowTotal);
		List<Dto> member=dao.userview(page);
		request.setAttribute("member", member);
		request.setAttribute("page", page);
		return "user.jsp";
	}

}
