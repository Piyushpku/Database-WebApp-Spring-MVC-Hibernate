package testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Connect() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String user="springstudent";
				String pswd="springstudent";
				String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false";
				String driver="com.mysql.cj.jdbc.Driver";
				try {
					PrintWriter out=response.getWriter();
					out.println("Connecting to:"+ jdbcUrl);
					Class.forName(driver);
					Connection myconn= DriverManager.getConnection(jdbcUrl,user,pswd);
					out.println("Success!!!!");
					myconn.close();
					
				}catch(Exception e) {
					System.out.println(e);
				}
	}

}
