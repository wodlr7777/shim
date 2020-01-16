package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;

public class LoginAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		Dto dto=new Dto();
		dto.setId(id);
		dto.setPw(pw);
		Dao dao=(Dao) request.getServletContext().getAttribute("Dao");
		Dto member=dao.logincheck(dto);
		request.getSession().setAttribute("member", member);
		if(member.getId().equals("admin")) {
			return "adminPage.jsp";
		}
		return "index.jsp";
	}

}
