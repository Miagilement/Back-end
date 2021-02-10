package com.projectagile.webprojectagile.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class FilterHote implements Filter {
  @Override
   public void destroy() {
// callback de destruction de ce filtre

   }

   @Override
   public void doFilter
   (ServletRequest request, 
   ServletResponse response, 
   FilterChain filterchain) 
      throws IOException, ServletException {
      System.out.println("Hote distant:"+request.getRemoteHost());
      System.out.println("Adresse distant:"+request.getRemoteAddr());
      filterchain.doFilter(request, response);// propagation de la requête le long de la chaîne
   }
}
