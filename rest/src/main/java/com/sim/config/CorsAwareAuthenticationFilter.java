package com.sim.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsAwareAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private static final String ORIGIN = "Origin";

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
    if (request.getHeader(ORIGIN) != null) {
      String origin = request.getHeader(ORIGIN);
      response.addHeader("Access-Control-Allow-Origin", origin);
      response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
      response.addHeader("Access-Control-Allow-Credentials", "true");
      response.addHeader("Access-Control-Allow-Headers",
          request.getHeader("Access-Control-Request-Headers"));
    }
    if (request.getMethod().equals("OPTIONS")) {
      try {
        response.getWriter().print("OK");
        response.getWriter().flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return super.attemptAuthentication(request, response);
  }
}
