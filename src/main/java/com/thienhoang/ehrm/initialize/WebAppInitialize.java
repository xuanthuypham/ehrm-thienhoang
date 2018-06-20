package com.thienhoang.ehrm.initialize;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.thienhoang.ehrm.springconfig.AppConfig;

public class WebAppInitialize implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		
		context.refresh();

		System.out.println(">>>>>>>> WebAppInitializer: addServlet");
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));  
		dynamic.setLoadOnStartup(1); 	
	}

}
