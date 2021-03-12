package com.cg.customermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.customermgmt.customer.ui.CustomerUI;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(CustomerApplication.class, args);
		CustomerUI customerUI = context.getBean(CustomerUI.class);
		customerUI.start();
	}

}
