package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;


@Component
public class CoDecUtil {
	public String doEncode(String nrml){
		byte[] arr=Base64.encodeBase64(nrml.getBytes());
		return new String(arr);
		}
	public String doDecode(String encStr){
		byte[] arr=Base64.decodeBase64(encStr.getBytes());
		return new String(arr);
		
	}

}
