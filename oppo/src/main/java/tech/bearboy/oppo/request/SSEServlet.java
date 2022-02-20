package tech.bearboy.oppo.request;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SSEServlet
 * �������Զ���ͻ��˸��µ��࣬��SSE��server sent event
 */
@WebServlet("/SSEServlet")
public class SSEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSEServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ʾsse�����������Զ�����
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		Logger logger = Logger.getLogger(this.getClass());
		ServletContext sc = getServletConfig().getServletContext();
		//ʱ���ж�ȫ�ֱ���previousId��currentId�Ƿ���ȣ��������ʾ���µ�ͼƬ�������ݿ⣬������ͻ��˸���
		if(sc.getAttribute("previousId")!=sc.getAttribute("currentId")) {
			PrintWriter writer = response.getWriter();
			WebApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(getServletConfig().getServletContext());
			String jsonStr = ctx.getBean("photoDAO", PhotoDAO.class).currentImgJson(Integer.parseInt(sc.getAttribute("currentId")+""));
			writer.write("data: "+ jsonStr+ "\n\n");
			logger.info("SSE����:"+jsonStr);
			System.out.println(sc.getAttribute("currentId"));
			sc.setAttribute("previousId",sc.getAttribute("currentId"));
			writer.flush();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
//		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
