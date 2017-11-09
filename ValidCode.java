package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidCode extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("checkcode...");
		/*
		 * һ.��ͼ
		 */
		//step1,�����ڴ�ӳ�����(����)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//step2,��û���
		Graphics g = image.getGraphics();
		//step3,����������ɫ
		g.setColor(new Color(255,255,255));
		//step4,���ñ�����ɫ
		g.fillRect(0, 0, 80, 30);
		//step5,����ǰ����ɫ
		Random r = new Random();
		g.setColor(new Color(
				r.nextInt(255),r.nextInt(255)
				,r.nextInt(255)));
		//step6,��ͼ
		//��������(����,���,��С)
		g.setFont(new Font(null,Font.ITALIC,24));
		String number = r.nextInt(10000)
		+ "";
		
		
		//�������֤��浽session�У���֤��������session�У���������ȫ
		HttpSession  session=request.getSession();
		session.setAttribute("imgCode", number);
		
		
		
		
		g.drawString(number, 5, 26);
		//step7,��һЩ������
		for(int i = 0;i < 6; i++){
			g.drawLine(
					r.nextInt(80), r.nextInt(30),
					r.nextInt(80), r.nextInt(30));
		}
		/*
		 * ��.��ͼƬѹ�������͸������
		 */
		response.setContentType("image/jpeg");
		OutputStream ops = 
			response.getOutputStream();
		//write����:�ὫԭʼͼƬ(image)����
		//ָ�����㷨("jpeg")ѹ����Ȼ�������
		javax.imageio.ImageIO.write(image,"jpeg",ops);
		ops.close();
	}

}
