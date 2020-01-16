package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;

public class ReplyAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		int no=Integer.parseInt(request.getParameter("no"));
		String content=request.getParameter("content");
		String writer=request.getParameter("writer");
		String viewToken=request.getParameter("viewToken");
		String token=(String) request.getSession().getAttribute("sessionToken");
		System.out.println(writer);
		System.out.println(viewToken);
		System.out.println(token);
		if(!viewToken.equals(token)) {
			return "replyboard.do?no="+no;
		}
		Dto dto=new Dto();
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setNo(no);
		dao.reply(dto);
		request.getSession().setAttribute("sessionToken", "");
		Dto member=(Dto) request.getSession().getAttribute("member");
		if(member.getId().equals("admin")) {
			return "adminPage.jsp";
		}
		return "replyboard.do?no="+no;
	}

}
