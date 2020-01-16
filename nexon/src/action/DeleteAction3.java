package action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Dao;

public class DeleteAction3 implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
		Dao dao=(Dao) sc.getAttribute("Dao");
		String remove=(request.getParameter("remove"));
		String[] nums=remove.split(",");
		for(String num:nums) {
			int no=Integer.parseInt(num);
			System.out.println(no);
			dao.deleteuser(no);
		}
		return "userinfo.do";
	}

}
