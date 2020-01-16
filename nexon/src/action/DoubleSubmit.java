package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoubleSubmit implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		long num =System.currentTimeMillis();//1970.1.1~
		String token = Long.toString(num);
		request.setAttribute("viewToken",token);
		HttpSession session=request.getSession();
		session.setAttribute("sessionToken", token);
		request.setAttribute("no", no);
		return "reply.jsp";
	}

}
