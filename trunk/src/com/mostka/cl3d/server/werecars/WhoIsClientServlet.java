package com.mostka.cl3d.server.werecars;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Logger;

import javax.servlet.http.*;

/**
 * This simple example uses the Socket API to access a WHOIS server and query
 * for domains that contain the string "google.com".
 **/
@SuppressWarnings("serial")
public class WhoIsClientServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(WhoIsClientServlet.class.getName());

	private static final int DEFAULT_PORT = 43;
	private static final String DEFAULT_SERVER = "whois.internic.net";

	void writeHeader(HttpServletResponse resp, String name) throws IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		String header = "<html><head><title>App Engine Whois example result for " + name + "</title>" + "</head><body>\n";
		resp.getWriter().print(header);
	}

	void writeFooter(HttpServletResponse resp) throws IOException {
		resp.getWriter().println("</head></html>");
	}

	static String getParam(HttpServletRequest req, String attributeName, String defaultValue) {
		String value = req.getParameter(attributeName);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = getParam(req, "name", "google.com");
		String server = getParam(req, "server", DEFAULT_SERVER);
		int port = Integer.parseInt(getParam(req, "port", Integer.toString(DEFAULT_PORT)));

		writeHeader(resp, name);
		resp.getWriter().println("<pre><br>");
		resp.getWriter().println(doWhoIs(server, port, name));
		resp.getWriter().println("</pre>");
		writeFooter(resp);
	}

	/**
	 * Open a socket to the whois server, write out the query, and receive the
	 * results.
	 **/
	String doWhoIs(String server, int port, String name) {
		Socket socket = null;
		try {
			socket = new Socket(server, port);
			Writer out = new OutputStreamWriter(socket.getOutputStream(), "8859_1");

			socket.setSoTimeout(10000);
			Reader recv = new InputStreamReader(socket.getInputStream(), "8859_1");
			out.write("=" + name + "\r\n");
			out.flush();

			StringBuilder builder = new StringBuilder();
			for (int c = 0; (c = recv.read()) != -1;) {
				builder.append(String.valueOf((char) c));
			}

			return builder.toString();
		} catch (IOException e) {
			String message = "whois server failed: " + server + " exception:" + e.toString();
			log.warning(message);
			return message;
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// don't care.
			}
		}
	}
}