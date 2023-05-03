package com.myspring.pro28.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static final String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	@RequestMapping(value="/form")
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload", method= RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap();	// 매개변수 정보와 파일 정보를 저장할 Map을 생성
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements() ) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			map.put(name,  value);
		}
		List fileList = fileProcess(multipartRequest);
		map.put("fileList", fileList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);	//map을 결과창으로 포워딩한다.
		mav.setViewName("result");
		
		return mav;
	}
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();	// 첨부된 파일 이름을 가져온다.
		while(fileNames.hasNext() ) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();	// 실제 파일 이름을 가져온다.
			fileList.add(originalFileName);
			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			if(mFile.getSize() != 0) {	// 첨부된 파일이 있는지 확인
				
				// 경로에 파일이 없으면 그 경로에 해당하는 디렉터리를 만든 후 파일을 생성
				if(! file.exists() ) {
					if(file.getParentFile().mkdirs() ) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName));
			}
		}
		return fileList;	// 첨부된 파일 이름이 저장된 fileList를 반환한다.
	}
}
