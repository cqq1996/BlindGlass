package tech.bearboy.oppo.request;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tech.bearboy.oppo.dao.PhotoDAO;

/**
 * Servlet implementation class SaveImgServlet
 * �������µ�һ��ͼƬ�辭����servlet
 */
@WebServlet("/SaveImgServlet")
public class SaveImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String target = request.getParameter("target");
		String text = request.getParameter("text");
		String msg = request.getParameter("msg");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		Logger logger = Logger.getLogger(this.getClass());
		logger.info(name+"/"+text+"/"+target+"/"+msg+"/"+time+"/"+date+"/"+location);
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletConfig().getServletContext());
		
		int id = ctx.getBean("photoDAO", PhotoDAO.class).insertOneImg(name,text,target,msg,time,date,location);
		//����web������ȫ�ֱ��������ڼ�����ݿ��Ƿ����µ����ݲ��룬�������ı������ֵ
		ServletContext sc = getServletConfig().getServletContext();
		sc.setAttribute("currentId", id);
		logger.info("����ͼƬ�ɹ�������:"+id);
		response.setContentType("text/html;charset=utf-8");
	}

}
