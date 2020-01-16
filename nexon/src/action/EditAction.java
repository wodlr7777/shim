package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;

public class EditAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		Dto dto=new Dto();
		int no=Integer.parseInt(request.getParameter("no"));
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setNo(no);
		dao.edit(dto);
		return "detail.do?no="+no;
	}

}
