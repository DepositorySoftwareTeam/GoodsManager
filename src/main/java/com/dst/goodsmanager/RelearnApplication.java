package com.dst.goodsmanager;

import com.dst.goodsmanager.handlers.HelloPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
public class RelearnApplication {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		System.out.println(new Throwable().getStackTrace()[0].toString());
		SpringApplication.run(RelearnApplication.class, args);
	}
}
