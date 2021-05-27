package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxFileSize = 10_485_760;//10*1024*1024(10mb)
		//String uploadpath = request.getRealPath("/res/img/temp"); //패스설정하는거 
		String uploadpath = request.getServletContext().getRealPath("/res/img");
		//""라면 경로가 webinf까지
		
		MultipartRequest multi = new MultipartRequest(request, uploadpath + "/temp", maxFileSize, "UTF-8",new DefaultFileRenamePolicy());
		
		System.out.println("uploadpath : " +uploadpath);
		
		int loginUserPk = MyUtils.getLoginUserPk(request);
		
		String targetFolder = uploadpath + "/user/"+loginUserPk;
		
		File folder = new File(targetFolder);
		if(!folder.exists()){ //폴더도 파일도 없다면 
			folder.mkdirs();
			//무조건 mkdirs()폴더 여러개를 만든다. 
		}
		
		
		
		
		
		String fileNm = multi.getFilesystemName("profileImg"); //파일 이름까지 알았으니 이거 가지고 원하는고으로이동한다.
		System.out.println("fileNm : " +fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf("."); //오른쪽으로부터 
		String ext = fileNm.substring(lastDotIdx);//확장자를 구함
		
		String newFilNm = UUID.randomUUID().toString() + ext; 
		
		
		File imgFile = new File(uploadpath + "/temp/" + fileNm);
		imgFile.renameTo(new File(targetFolder+"/"+newFilNm));
		
		
	}

}
