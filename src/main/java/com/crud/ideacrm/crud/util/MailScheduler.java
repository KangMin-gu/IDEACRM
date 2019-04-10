package com.crud.ideacrm.crud.util;

import com.crud.ideacrm.crud.dao.MailDao;
import com.crud.ideacrm.crud.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MailScheduler {

    @Autowired
    private MailDao mailDao;


    //@Scheduled(cron="*/30 * * * * *")
    //@Scheduled(cron="*/10 * * * * *")//삭제 후 윗코드 주석 제거 요망
    public void sendmail() throws Exception {
        boolean isValid = false;

        //날짜비교
        Date dateTime = new Date();
        //SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat formatTime = new SimpleDateFormat("H:mm");
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String today = formatDate.format(dateTime);
        //String currentTime = formatTime.format(dateTime);
        String today = formatTime.format(dateTime);
        //Calendar cal = Calendar.getInstance();
        //int hour = cal.get(Calendar.HOUR_OF_DAY);
        MailDto emailDto = new MailDto();
        emailDto.setRltdate(today);
        List<Map<String, Object>> list = mailDao.allTarget(emailDto);//미발송 메일 100건 리스트 긁어오기

        for(int i=0; i<list.size(); i++){
            String fromEmail = list.get(i).get("FROMEMAIL").toString(); //보낸이
            String toEmail =  list.get(i).get("TOEMAIL").toString(); //받는이
            String subject =  list.get(i).get("SUBJECT").toString(); //제목
            String content =  list.get(i).get("CONTENT").toString(); //내용
            String ccEmail =  (String) list.get(i).get("CCEMAIL"); //참조
            String bccEmail =  (String) list.get(i).get("BCCEMAIL"); //숨은참조
            int emailLogId = Integer.parseInt(list.get(i).get("EMAILLOGID").toString()); //이메일로그pk
            String sendDate = list.get(i).get("RLTDATE").toString();
            //String sendDate =  list.get(i).get("SENDDATETIME").toString(); //보낸날짜
            //int time = Integer.parseInt(list.get(i).get("TIME").toString()); //시간
            //String date = formatTime.format(sendDate);
            //String time = formatTime.format(sendDate);
            //String date = formatDate.format(sendDate);
			/*
			if(today.equals(date) &&  ){
				send(subject,fromEmail,content,toEmail,ccEmail,bccEmail);
				isValid = true;
				emailDto.setEmaillogid(emailLogId);
				UpdateState(isValid, emailDto);
			}
			*/
            int compare = sendDate.compareTo(today);
            if(compare == -1) {
                send(subject,fromEmail,content,toEmail,ccEmail,bccEmail);
                isValid = true;
                emailDto.setEmaillogid(emailLogId);
                UpdateState(isValid, emailDto);
            }
        }
    }

    private void send(String subject, String fromemail, String content, String toemail, String ccemail, String bccemail)
            throws Exception {
        InternetAddress[] toAddr = null;
        InternetAddress[] cCAddr = null;
        InternetAddress[] bCAddr = null;
        List<String> toList = new ArrayList<String>();
        List<String> cCList = new ArrayList<String>();
        List<String> bCList = new ArrayList<String>();

        // smtp 연결설정 192.168.0.32 / 182.231.77.200 / 192.168.219.102
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "125.129.242.156");
        properties.setProperty("mail.smtp.port", "25");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.debug", "true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        };

        Session session = Session.getDefaultInstance(properties, authenticator);
        Message message = new MimeMessage(session);


        ((MimeMessage) message).setSubject(subject, "UTF-8");
        message.setFrom(new InternetAddress(fromemail));
        ((MimeMessage) message).setContent(content, "text/html; charset=UTF-8");



        if (toemail != null) {
            toList.add(toemail);
        }
        if (ccemail != null) {
            cCList.add(ccemail);
        }
        if (bccemail != null) {
            bCList.add(bccemail);
        }
        if (toList.size() > 0) {
            toAddr = InternetAddress.parse(makeMailAdresses(toList));
        }
        if (cCList.size() > 0) {
            cCAddr = InternetAddress.parse(makeMailAdresses(cCList));
        }
        if (bCList.size() > 0) {
            bCAddr = InternetAddress.parse(makeMailAdresses(bCList));
        }
        message.setRecipients(Message.RecipientType.TO, toAddr);
        if (null != cCAddr && 0 < toAddr.length) {
            message.setRecipients(Message.RecipientType.CC, cCAddr);
        }
        if (null != bCAddr && 0 < bCAddr.length) {
            message.setRecipients(Message.RecipientType.BCC, bCAddr);
        }
        Transport.send(message);
    }

    private void UpdateState(Boolean isValid, MailDto emailDto) {

        if (isValid == true) {
            int rltcode = 20;
            emailDto.setRltcode(rltcode);
            mailDao.UpdateMailState(emailDto);
        }
    }

    private String makeMailAdresses(List<String> targetList) {
        String strAddress = "";
        for (int i = 0; i < targetList.size(); i++) {
            strAddress += targetList.get(i);
            if (i < targetList.size() - 1) {
                strAddress += ";";
            }
        }
        return strAddress;
    }


}
