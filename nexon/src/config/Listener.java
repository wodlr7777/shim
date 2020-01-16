package config;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DB.Dao;

@WebListener
public class Listener implements ServletContextListener {

    public Listener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext sc=sce.getServletContext();

    	String resource="mybatis-config.xml";
    	InputStream inputstream;
    	SqlSessionFactory factory=null;
    	try {
			inputstream=Resources.getResourceAsStream(resource);
			factory=new SqlSessionFactoryBuilder().build(inputstream);
	    	Dao dao=new Dao(factory);
	    	sc.setAttribute("Dao", dao);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
