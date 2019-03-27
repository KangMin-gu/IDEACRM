package com.crud.ideacrm.crud.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Encryptor {
	
	// DB 양방향 암호화 MG 
	public static void main(String[] args) {
			StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
			        
			        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
			        pbeEnc.setPassword("jasyptPass"); // PBE 값(XML PASSWORD설정)
			        
			        String url = pbeEnc.encrypt("jdbc:mysql://211.233.87.130:3306/crud_saas?allowMultiQueries=true");
			        String username = pbeEnc.encrypt("root");
			        String password = pbeEnc.encrypt("crudsystem1008!");
			        
			        String url2 = pbeEnc.decrypt("OopBK00yr/PnPonV7s9HoQCtn8R8UIMtla9dLKV9yv6FEanL5gNOmn2SEZBi0VmNU9YUA7aqQI1ftDy7dcH5I2UGwr1GdyIrLFIY+2yXXR4=");
			        System.out.println("URL= "+url);
			        System.out.println("USERNAME= "+username);
			        System.out.println("PASSWORD= "+password);
    }
	
}
