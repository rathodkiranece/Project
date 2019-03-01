package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCheckFilter implements Filter {
	List<String> urlList = null;

	public void init(FilterConfig fConfig) throws ServletException {
		String urls = fConfig.getInitParameter("avoid-urls");
		StringTokenizer stObj = new StringTokenizer(urls, ",");
		urlList = new ArrayList<String>();

		while (stObj.hasMoreTokens()) {
			String url = stObj.nextToken();
			urlList.add(url);
		}
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String reqUri = httpRequest.getRequestURI();
		boolean flag = urlList.contains(reqUri);

		httpResponse.setHeader("Cache-Control",
				"no-cache,no-strore,must-revalidate");
		httpResponse.setHeader("Pragma", "no-cache");
		httpResponse.setDateHeader("Expires", 0);
		
		if (!flag) {
			HttpSession session = httpRequest.getSession(false);
			String userName = (String) session.getAttribute("userName");
			if (session == null || userName == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath()
						+ "/mvc/showLogin");
			} else {

				chain.doFilter(httpRequest, httpResponse);
			}

		} else {

			chain.doFilter(httpRequest, httpResponse);
		}

	}

	public void destroy() {
	}

}
