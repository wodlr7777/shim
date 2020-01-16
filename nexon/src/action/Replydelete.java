package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;

public class Replydelete implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		int no=Integer.parseInt(request.getParameter("no"));
		int no2=Integer.parseInt(request.getParameter("no2"));
		Dto dto=new Dto();
		dto.setNo(no);
		dto.setReplyno(no2);
		dao.replydelete(dto);
		return "replyboard.do";
	}

}
