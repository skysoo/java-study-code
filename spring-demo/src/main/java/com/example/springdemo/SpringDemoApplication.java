package com.example.springdemo;

import com.example.springdemo.proxy.ProxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class SpringDemoApplication {
	private final ProxyService proxyService;

	public SpringDemoApplication(ProxyService proxyService) {
		this.proxyService = proxyService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@PostConstruct
	public void init(){
//		proxyService.testA();
		proxyService.proxyTestA();
	}

}
