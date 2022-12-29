package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns= {"/admin/*", "/product/order.do", "/product/complete.do"})
public class LoginBlock implements Filter {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.debug("로그인체크");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession sess = req.getSession();
		
		if(sess.getAttribute("sessUser") == null) {
			((HttpServletResponse)response).sendRedirect("/Kmarket/?resultCode=102");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
