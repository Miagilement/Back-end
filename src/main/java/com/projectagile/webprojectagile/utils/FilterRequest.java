package com.projectagile.webprojectagile.utils;

import org.springframework.stereotype.Component;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Component
public class FilterRequest implements Filter {
 @Override
   public void destroy() {}

   @Override
   public void doFilter /*Envoie de la requete*/
      (ServletRequest request,
      ServletResponse response,
       FilterChain filterchain) 
      throws IOException, ServletException {}

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {/*Appeler pour l'initialisation du filtre*/}
}
