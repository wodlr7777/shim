package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.Dto;

public class RegisterAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Dao dao = (Dao) sc.getAttribute("Dao");
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("pw").trim();
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		Dto dto=new Dto();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setEmail(email);
		String dbid = "";
		if (!id.equals("")) {
			dbid = dao.regfound(id);
			if (!id.equals(dbid)) {
				dao.register(dto);
				return "index.jsp";
			}
		}
		return "register2.jsp";

	}

}
