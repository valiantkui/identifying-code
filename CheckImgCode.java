package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckImgCode
 */
@WebServlet("/CheckImgCode")
public class CheckImgCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckImgCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgCode =request.getParameter("imgCode");
		String code=(String)request.getSession().getAttribute("imgCode");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw=response.getWriter();
		if(code.equalsIgnoreCase(imgCode))
		{
			pw.print("验证码输入正确");
		}else {
			String error="验证码错误";
			request.setAttribute("error", error);
			request.getRequestDispatcher("test_imgCode.jsp").forward(request, response);
		}
			
	}

}
