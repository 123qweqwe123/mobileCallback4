package com.bdcor.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration    
@ComponentScan    
@EnableAutoConfiguration  
public class CallbackMain implements EmbeddedServletContainerCustomizer {

	static Logger log = LoggerFactory.getLogger(CallbackMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("test");
		
		 SpringApplication.run(CallbackMain.class, args);
		
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer arg0) {
		arg0.setPort(8983);
	}

}
