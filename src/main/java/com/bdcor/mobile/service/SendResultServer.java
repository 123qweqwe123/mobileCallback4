package com.bdcor.mobile.service;

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


/**
 * 短信发送结果回调
 * @author Administrator
 *
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/mobileSendResult")
public class SendResultServer {
	private static Logger codeLog = LoggerFactory.getLogger("callback.info");
	static Logger log = LoggerFactory.getLogger(SendResultServer.class);
	
	@Autowired
	MobileBean mobileBean;
	

	
	
	@RequestMapping("/sendResult")  
	//@ResponseBody
	public void sendResult(HttpServletRequest req,HttpServletResponse resp){
		//ServletOutputStream out = resp.getOutputStream();
		/*
		System.out.println("SendStateInfo:--------------------------------------");
		Enumeration<String> headName = req.getHeaderNames();
		while(headName.hasMoreElements()) {
			String myName = headName.nextElement();
			log.info(headName+"="+req.getHeader(myName));
		}
		*/
		log.info("=============================");
		Enumeration<String> name = req.getParameterNames();
		while(name.hasMoreElements()) {
			String myName = name.nextElement();
			log.info(myName+"="+req.getParameter(myName));
		}
		
		

		
		
		/*
		if(linkId!=null)
			linkId=linkId.trim().substring(12);
		*/
		
		
		String FUnikey = req.getParameter("FUnikey");
		String FOrgAddr = req.getParameter("FOrgAddr");
		String FDestAddr = req.getParameter("FDestAddr");
		String FSubmitTime = req.getParameter("FSubmitTime");
		String FFeeTerminal = req.getParameter("FFeeTerminal");
		String FServiceUPID = req.getParameter("FServiceUPID");
		String reportCode = req.getParameter("FReportCode");
		String FAckStatus = req.getParameter("FAckStatus");
		String linkId = req.getParameter("FLinkID");
		
		codeLog.info(linkId+" "+reportCode);
		
		this.mobileBean.getMobileClient().sendStateRegister(
				FUnikey,
				FOrgAddr,
				FDestAddr,
				FSubmitTime,
				FFeeTerminal,
				FServiceUPID,
				reportCode,
				FAckStatus,
				linkId);
		
				
	}
}
