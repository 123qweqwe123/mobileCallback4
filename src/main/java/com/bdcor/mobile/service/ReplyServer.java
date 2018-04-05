package com.bdcor.mobile.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdcor.mobile.bean.MobileBean;
import com.bdcore.webservice.client.MsgClient;

/**
 * 短息回复
 * @author Administrator
 *
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/mobilecallback")
public class ReplyServer {
	private static Logger codeLog = LoggerFactory.getLogger("reply.info");

	@Autowired
	MobileBean mobileBean;
	
	@RequestMapping("/mobileCallbackServlet")  
	//@ResponseBody
	public void reply(HttpServletRequest req,HttpServletResponse resp){
		
		//req.setCharacterEncoding("gb2312");
				//resp.setContentType("Content-Type: text/plain;charset=utf-8");
		
		//ServletOutputStream out = resp.getOutputStream();
		
				//out.println("hello embed servlet!");
				
				
				Enumeration<String> headName = req.getHeaderNames();
				while(headName.hasMoreElements()) {
					String myName = headName.nextElement();
					System.out.println(headName+"="+req.getHeader(myName));
				}
				
				
				
				Enumeration<String> name = req.getParameterNames();
				while(name.hasMoreElements()) {
					String myName = name.nextElement();
					System.out.println(myName+"="+req.getParameter(myName));
				}
				
				String Phone = req.getParameter("phone");
				String msgContent = req.getParameter("msgContent");
				String spNumber = req.getParameter("spNumber");
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				mobileBean.getMobileClient().replyMsgRegister("001", Phone, msgContent, df.format(new Date()));
				
				//System.out.println("Phone:"+Phone+";msgContent:"+msgContent+";spNumber:"+spNumber);
				
				codeLog.info("1"+"		"+Phone+":"+msgContent+":"+spNumber);
				
	}
}
