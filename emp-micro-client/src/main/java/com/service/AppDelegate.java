package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class AppDelegate {
	
   @Bean
   @LoadBalanced
   public RestTemplate restTemplate()
   {
	   return new RestTemplate();
   }
	@Autowired
	RestTemplate template;
	@HystrixCommand(fallbackMethod = "callOnFailure"
			,commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000") 
	})
			
	public String loademp() {
		String data = template.exchange("http://api-gateway/userapp",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<String>() {
		}).getBody();
		
		return data;
	}
	public String loademp1() {
		String data = template.exchange("http://emp-service1/mainapp/loadall",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<String>() {
		}).getBody();
		
		return data;
	}
	
	public String callOnFailure()
	{
		return "Service is Down....! try after sometime";
	}

}