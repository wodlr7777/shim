package filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("*.do")
public class Filter implements javax.servlet.Filter {

	public void destroy() {
		System.out.println("서버종료");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터내용");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}	
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("서버 실행");
	}

}
