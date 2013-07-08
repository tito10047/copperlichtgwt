package com.mostka.cl3d.server.werecars;

import static com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;


@SuppressWarnings("serial")
public class Test  extends HttpServlet {
    private static final Logger log = Logger.getLogger( Test.class.getName() );

	private static HashMap<String, TaskOptions> tasks = new HashMap<>();
	private static Queue queue = QueueFactory.getQueue("werecars");
	private static HashMap<String, ServerScheduler> servers = new HashMap<>();
	private static int i = 0;
		
	public static void addServer(ServerScheduler server){
		if (servers.containsKey(server.getName())){
			return;
		}
		TaskOptions task = TaskOptions.Builder.withUrl("/Werecars/test");
		task.param("serverName", server.getName());
		task.method(Method.GET);
		
		servers.put(server.getName(), server);
		tasks.put(server.getName(), task);
		
		//queue.add(task);
	}
	public static void removeServer(String serverName){
		servers.remove(serverName);
		tasks.remove(serverName);
	}
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        res.setContentType("text/plain");
    	String serverName = req.getParameter("serverName");
    	if (servers.containsKey(serverName)==false){
            res.getWriter().println("Unautorized access");
    		return;
    	}
    	if (i++<100){
    		//queue.add(tasks.get(serverName));
    	}
    	servers.get(serverName).run();
		System.out.println("executed test."+serverName);     

    }
	
}
