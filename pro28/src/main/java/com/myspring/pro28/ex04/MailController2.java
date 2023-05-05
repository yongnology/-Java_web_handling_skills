package com.myspring.pro28.ex04;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController2 {
    @Autowired
    private MailService2 mailService;
	
	@RequestMapping(value = "/sendMail2.do", method = RequestMethod.GET)
    public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();	// StringBuffer 변수 sb를 선수 선언
		sb.append("<html><body>");
		sb.append("<meta http-equiv='Context-Type' content='text/html'; charset=euc-kr'>");
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>");
		sb.append("<img  src='http://image.kyobobook.co.kr/images/book/xlarge/425/x9788956746425.jpg' /> </a><br>");
		sb.append("</a>");
		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>상품보기</a>");
 		sb.append("</body></html>");
 		String str = sb.toString();
		
		mailService.sendMail("cassius20@naver.com", "신상품을 소개합니다 !!!", str);
		//mailService.sendPreConfiguredMail("테스트메일입니다. 구글 smtp로 보낼 때 prot는 587 이며\n 2중 비밀번호 생성 후 앱 비밀번호로 16자리 비밀번호로 로그인 해야 나옵니다.");
									// ★★★ 메일 내용
		out.print("메일을 보냈습니다!!");
	}
}
