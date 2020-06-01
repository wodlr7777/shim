package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.MemberDto;
import security.CryptoUtil;

public class LoginAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		MemberDto dto=new MemberDto();
		dto.setEmail(email);
		String decryptpw=null;
		Dao dao=(Dao) request.getServletContext().getAttribute("Dao");
		MemberDto member=dao.logincheck(dto);
		String dbpw=member.getPw();
		try {
			decryptpw=CryptoUtil.decryptAES256(dbpw, "key");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(member.getEmail().equals("admin")&&decryptpw.equals(pw)) {
			request.getSession().setAttribute("member", member);
			return "adminPage.jsp";
		}
		else if(member.getEmail().equals(email)&&decryptpw.equals(pw)) {
			request.getSession().setAttribute("member", member);
			return "index.jsp";
		}
		return "login.jsp";
	}

}
