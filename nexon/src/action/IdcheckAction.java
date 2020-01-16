package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;

public class IdcheckAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		Dao dao=(Dao) request.getServletContext().getAttribute("Dao");
		int n=dao.idcheck(id);
		if(n==1) {
			PrintWriter pw=response.getWriter();
			pw.print(n);
		}
		return null;
	}

}
