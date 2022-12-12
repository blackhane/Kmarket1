package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.DAO.MemberDAO;
import kr.co.Kmarket.VO.MemberVO;

public class AutoLogin implements Filter {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("LoginFilter");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession sess = req.getSession();
		//자동로그인 여부
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("sessId")) {
					String sessId = cookie.getValue();
					MemberVO vo = MemberDAO.getInstance().selectCookie(sessId);
					if(vo.getUid() != null) {
						sess.setAttribute("sessUser", vo);
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

}
