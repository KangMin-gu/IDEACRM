package com.crud.ideacrm.crud.util;

import com.crud.ideacrm.crud.dto.ContactInfoDto;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ContactInfo {

    public ContactInfoDto agentInfo(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");
        String header = request.getHeader("User-Agent");
        String agent = request.getHeader("User-Agent").toLowerCase();
        String browser = null;
        String os = null;
        String device = null;

        ContactInfoDto ciDto = new ContactInfoDto();

        // 접속자 IP
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        ciDto.setIp(ip);


        if ( header != null && header.indexOf("Chrome/") != -1) {
            browser = "Chrome";
        }else if( header != null && header.indexOf("Safari/") != -1 ){
            browser = "Safari";
        }else if( header != null && header.indexOf("Navigator/") != -1 ){
            browser = "Netscape";
        }else if( header != null && header.indexOf("Firefox/0.9.6") != -1 ){
            browser = "Netscape 8";
        }else if( header != null && header.indexOf("Opera/") != -1 ){
            browser = "Opera";
        }else if( header != null && header.indexOf("Flock/") != -1 ){
            browser = "Flock";
        }else if( header != null && header.indexOf("Firefox/") != -1 ){
            browser = "Firefox";
        }else if( header != null && header.indexOf("MSIE 6") != -1 ){
            browser = "MSIE 6";
        }else if( header != null && header.indexOf("MSIE 7") != -1 ){
            browser = "MSIE 7";
        }else if( header != null && header.indexOf("MSIE 8") != -1 ){
            browser = "MSIE 8";
        }else if( header != null && header.indexOf("MSIE 9") != -1 ){
            browser = "MSIE 9";
        }else if( header != null && header.indexOf("MSIE 10") != -1 ){
            browser = "MSIE 10";
        }else if( header != null && header.indexOf("Trident") != -1 ){
            browser = "MSIE 11";
        }

        ciDto.setBrowser(browser);

        if(agent.indexOf("android") != -1) device = "Android";
        else if(agent.indexOf("iphone") != -1) device = "iPhone";
        else if(agent.indexOf("ipod") != -1) device = "iPod";
        else if(agent.indexOf("windows ce") != -1) device = "Windows CE";
        else if(agent.indexOf("blackberry") != -1) device = "BlackBerry";
        else if(agent.indexOf("symbian") != -1) device = "Symbian";
        else if(agent.indexOf("windows phone") != -1) device = "Windows Phone";
        else if(agent.indexOf("webos") != -1) device = "WebOS";
        else if(agent.indexOf("opera mini") != -1) device = "Opera mini";
        else if(agent.indexOf("opera mobi") != -1) device = "Opera Mobi";
        else if(agent.indexOf("polaris") != -1) device = "POLARIS";
        else if(agent.indexOf("iemobile") != -1) device = "IEMobile";
        else device = "기타";

        ciDto.setDevice(device);

        if(agent.indexOf("nt 6.0") != -1) os = "Windows Vista/Server 2008";
        else if(agent.indexOf("nt 5.2") != -1) os = "Windows Server 2003";
        else if(agent.indexOf("nt 5.1") != -1) os = "Windows XP";
        else if(agent.indexOf("nt 5.0") != -1) os = "Windows 2000";
        else if(agent.indexOf("nt 6.1") != -1) os = "Windows 7";
        else if(agent.indexOf("nt 6.2") != -1) os = "Windows 8";
        else if(agent.indexOf("nt 6.3") != -1) os = "Windows 8.1";
        else if(agent.indexOf("nt 10.0") != -1) os = "Windows 10";
        else if(agent.indexOf("nt") != -1) os = "Windows NT";
        else if(agent.indexOf("9x 4.90") != -1) os = "Windows Me";
        else if(agent.indexOf("98") != -1) os = "Windows 98";
        else if(agent.indexOf("95") != -1) os = "Windows 95";
        else if(agent.indexOf("win16") != -1) os = "Windows 3.x";
        else if(agent.indexOf("windows") != -1) os = "Windows";
        else if(agent.indexOf("linux") != -1) os = "Linux";
        else if(agent.indexOf("macintosh") != -1) os = "Macintosh";
        else if(agent.indexOf("android") != -1) os = "Android";
        else if(agent.indexOf("iphone") != -1) os ="Iphone";
        else os = "";

        ciDto.setDevice(os);

        return ciDto;
    }

}
