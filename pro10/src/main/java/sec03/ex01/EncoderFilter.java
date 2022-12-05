package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */

@WebFilter("/a")
public class EncoderFilter extends HttpFilter implements Filter {
       
    public EncoderFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Contet 정보 : "+context + "\n URI 정보: " + pathinfo + "\n 물리적 경로 : " + realPath;
		System.out.println(mesg);
		
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		System.out.println("작업시간 : "+ (end-begin) + "ms");
	}
}


