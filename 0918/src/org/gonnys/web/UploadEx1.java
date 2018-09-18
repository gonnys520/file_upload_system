package org.gonnys.web;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.imgscalr.Scalr;

/**
 * Servlet implementation class UploadEx1
 */

@MultipartConfig(
		
	maxFileSize=1024*1024*50,
	maxRequestSize=1024*1024*100)
		
@WebServlet("/upload1")
public class UploadEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadEx1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		
		System.out.println(request.getParameter("mname"));
		System.out.println(request.getParameter("price"));
		
		parts.stream().forEach(part -> {
			
			
			System.out.println(part.getContentType());
			System.out.println(part.getSubmittedFileName());
			System.out.println("---------------------------");
			
			//������ �ߺ��ǵ� ������ / UUID�� ������ ���ڸ� �������
			String uploadName = UUID.randomUUID() + "_" + part.getSubmittedFileName();
			
			
			// ������ �޾Ƽ� �����ϴ� ��
			
			try {
				InputStream in = part.getInputStream();
				FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\"+ uploadName);
				
				//���� ���� ����(�ڵ� Ŭ����)
				IOUtils.copy(in, fos);
				
				if(Extchercker.check(uploadName)) {
				
				//Make thumbnail image
				BufferedImage bImage = ImageIO.read(new FileInputStream("C:\\zzz\\upload\\" + uploadName));
				//resize to 150 pixels max
				BufferedImage thumbnail =
						Scalr.resize(bImage,
								Scalr.Method.SPEED,
								Scalr.Mode.FIT_TO_WIDTH,
                                150,
                                100,
                                Scalr.OP_ANTIALIAS);
				
				FileOutputStream thfos = new FileOutputStream("C:\\zzz\\upload\\s_" + uploadName);
				ImageIO.write(thumbnail, "jpg", thfos);
				thfos.close();
				
				
				
				
				//�ڵ� close ���������� Ȥ�� �𸣴� �ص�
				in.close();
				fos.close();
				
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	
	
	}

}
