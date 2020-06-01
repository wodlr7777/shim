package action;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;
import model.MemberDto;
import security.CryptoUtil;

public class RegisterAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Dao dao = (Dao) sc.getAttribute("Dao");
		String pw = request.getParameter("pw").trim();
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String address = request.getParameter("address").trim();
		String sex = request.getParameter("sex").trim();
		String phone = request.getParameter("phone").trim();
		String cryptopw=null;
		try {
			cryptopw=CryptoUtil.encryptAES256(pw, "key");
		} catch (Exception e) {
			e.printStackTrace();
		}
		MemberDto dto=new MemberDto();
		dto.setPw(cryptopw);
		dto.setName(name);
		dto.setEmail(email);
		dto.setAddress(address);
		dto.setSex(sex);
		dto.setPhone(phone);
		String dbid = "";
		if (!email.equals("")) {
			dbid = dao.regfound(email);
			if (!email.equals(dbid)) {
				dao.register(dto);
				return "index.jsp";
			}
		}
		return "register2.jsp";

	}

}
