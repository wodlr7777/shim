package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebServlet(urlPatterns = {"*.do","*.ch"},
initParams = {@WebInitParam(name = "config",value = "/WEB-INF/classes/class-config.properties")})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,Action> actionMap=new HashMap<String, Action>();
	
	@Override
	public void init() throws ServletException {
		String configFile=getInitParameter("config");
		String configFilepath=getServletContext().getRealPath(configFile);
		Properties prop=new Properties();
		try {
			FileReader fr=new FileReader(configFilepath);
			prop.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> it=prop.keySet().iterator();
		while(it.hasNext()) {
		String key=(String) it.next();
		String className=prop.getProperty(key);
		try {
			Class<?> clazz=Class.forName(className);
			Action action=(Action) clazz.newInstance();
			actionMap.put(key, action);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String uris[]=uri.split("/");
		String key=uris[uris.length-1];
		Action action = actionMap.get(key);
		String path=null;
		request.setCharacterEncoding("utf-8");
		System.out.println(key);
		
		path=action.process(request, response);
		if(path!=null) {
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
