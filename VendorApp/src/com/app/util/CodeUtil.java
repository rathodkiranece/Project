package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	private String genStr(int Size){
	
		return UUID.randomUUID()
				.toString()
				.replace("-","")
				.substring(0,Size);
	}
	public String genPwd(){
		return genStr(6);
	}
	public String genToken(){
		return genStr(8);
	}
}
