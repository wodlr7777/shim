package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.BoardDto;
import model.MemberDto;

public class WriteAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String writer=request.getParameter("writer");
		String viewToken=request.getParameter("viewToken");
		String token=(String) request.getSession().getAttribute("sessionToken");
		System.out.println(viewToken);
		System.out.println(token);
		if(!viewToken.equals(token)) {
			return "board.do";
		}
		BoardDto dto=new BoardDto();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setWriter(writer);
		dao.write(dto);
		request.getSession().setAttribute("sessionToken", "");
		MemberDto member=(MemberDto) request.getSession().getAttribute("member");
		if(member.getEmail().equals("admin")) {
			return "adminPage.jsp";
		}
		return "board.do";
	}

}
