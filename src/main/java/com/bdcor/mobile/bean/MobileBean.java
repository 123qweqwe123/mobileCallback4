package com.bdcor.mobile.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdcore.webservice.client.MsgClient;
import com.bdcore.webservice.client.config.ClientConfig;

/**
 * 短息回复
 * @author Administrator
 *
 */
@Component
public class MobileBean {
	private static Logger codeLog = LoggerFactory.getLogger("reply.info");
	MsgClient client = null;
	
	@PostConstruct
	public void init(){
				ClientConfig config = new ClientConfig();
				config.put(ClientConfig.MSG_SERVER_IP, "10.24.10.191");
				config.put(ClientConfig.MSG_SERVER_PORT, "3212");
				config.put(ClientConfig.PROJ_ID, "01");
				
				config.put(ClientConfig.REPLY_SERVER_IP, "localhost");
				config.put(ClientConfig.REPLY_SERVER_PORT, "12332");


				config.put(ClientConfig.SEND_STATUS_SERVER_IP, "localhost");
				config.put(ClientConfig.SEND_STATUS_SERVER_PORT, "12333");
				
				
				
				client = new MsgClient(config);
	}
	
	public MsgClient getMobileClient(){
		return this.client;
	}
}
