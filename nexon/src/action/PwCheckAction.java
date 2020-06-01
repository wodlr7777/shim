package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.MemberDto;

public class PwCheckAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		MemberDto dto=new MemberDto();
		dto.setEmail(email);;
		dto.setPw(pw);
		Dao dao=(Dao) request.getServletContext().getAttribute("Dao");
		request.getSession().getAttribute("member");
		int n=dao.pwcheck(dto);
		if(n==1) {
			PrintWriter out=response.getWriter();
			out.print(n);
		}
		return null;
	}

}
