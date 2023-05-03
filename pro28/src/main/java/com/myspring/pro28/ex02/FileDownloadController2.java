package com.myspring.pro28.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController2 {
		private static String CURR_IMAGE_REPO_PATH = "C:\\spring\\image_repo";
	
	@RequestMapping("/download2")
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		
		// 확장자를 제외한 원본 이미지 파일의 이름을 가져온다.
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0, lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH + "\\" + "thumbnail" + "\\" + fileName + ".png");
		
		// 원본 이미지 파일을 가로세로 50픽셀인 png 파일의 썸네일 이미지 파일로 생성
		if(image.exists()) {
			thumbnail.getParentFile().mkdir();
			Thumbnails.of(image).size(50, 50).outputFormat("png").toFile(thumbnail);
		}
		
		
		// 생성된 썸네일 파일을 브라우저로 전송.
		FileInputStream in = new FileInputStream(thumbnail);
		
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1) break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
		// 경우의 수 2
		// 이미지 파일 안만들고 썸네일 임이미지만 출력
		/*
		if(image.exists()) {
			Thumbnails.of(image).size(50, 50).outputFormat("png").toOupputStream(out);
		} else {
			return;
		}
		
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		 */
	}
	
}
