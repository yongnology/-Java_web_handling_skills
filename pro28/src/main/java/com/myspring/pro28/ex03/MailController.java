package com.myspring.pro28.ex03;

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
public class MailController {
    @Autowired
    private MailService mailService;
	
	@RequestMapping(value = "/sendMail.do", method = RequestMethod.GET)
    public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		mailService.sendMail("vdydalsv@gamil.com", "테스트메일1", "안녕하세요 테스트메일입니다.2");
		mailService.sendPreConfiguredMail("테스트메일입니다. 구글 smtp로 보낼 때 prot는 587 이며\n 2중 비밀번호 생성 후 앱 비밀번호로 16자리 비밀번호로 로그인 해야 나옵니다.");
									// ★★★ 메일 내용
		out.print("메일을 보냈습니다!!");
	}
}
