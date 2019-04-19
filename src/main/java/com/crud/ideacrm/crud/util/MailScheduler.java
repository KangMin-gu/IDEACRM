package com.crud.ideacrm.crud.util;

import com.crud.ideacrm.crud.dao.MailDao;
import com.crud.ideacrm.crud.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MailScheduler {

    @Autowired
    private MailDao mailDao;


    //@Scheduled(cron="*/30 * * * * *")
    @Scheduled(cron="*/10 * * * * *")//삭제 후 윗코드 주석 제거 요망
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
        Map<String,Object> mailVal = new HashMap<>();
        mailVal.put("today",today);
        List<Map<String, Object>> list = mailDao.allTarget(mailVal);//미발송 메일 100건 리스트 긁어오기

        for(int i=0; i<list.size(); i++){
            String fromEmail = list.get(i).get("FROMEMAIL").toString(); //보낸이
            String toEmail =  list.get(i).get("TOEMAIL").toString(); //받는이
            String subject =  list.get(i).get("SUBJECT").toString(); //제목
            String content =  list.get(i).get("CONTENT").toString(); //내용
            String ccEmail =  (String) list.get(i).get("CCEMAIL"); //참조
            String bccEmail =  (String) list.get(i).get("BCCEMAIL"); //숨은참조
            int emailLogId = Integer.parseInt(list.get(i).get("EMAILLOGID").toString()); //이메일로그
            String fileSearchKey = (String)list.get(i).get("FILESEARCHKEY");
            String sendDate = list.get(i).get("RLTDATE").toString();
            emailDto.setEmaillogid(emailLogId);


            int compare = sendDate.compareTo(today);
            if(compare == -1) {
                send(subject,fromEmail,content,toEmail,ccEmail,bccEmail, fileSearchKey);
                isValid = true;
                emailDto.setEmaillogid(emailLogId);
                UpdateState(isValid, emailDto);
            }
        }
    }

    private void send(String subject, String fromemail, String content, String toemail, String ccemail, String bccemail, String fileSearchKey)
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

        if(fileSearchKey != null){
            Multipart mp = new MimeMultipart();
            MimeBodyPart contentMimeBody = new MimeBodyPart();
            ((MimeMessage) message).setSubject(subject, "UTF-8");
            contentMimeBody.setContent(content,"text/html; charset=UTF-8");
            contentMimeBody.setHeader("Content-Transfer-Encoding", "base64");
            mp.addBodyPart(contentMimeBody);
            //첨부파일
            MimeBodyPart attachFileMimeBody = new MimeBodyPart();

            List<Map<String, Object>> files = mailDao.files(fileSearchKey);

            for(int i = 0; i<files.size(); i++){

                String orgFileName =  files.get(i).get("ORGFILENAME").toString();
                String path =  files.get(i).get("PATH").toString();

                File attachFile = new File(path);
                //첨부파일 이름 설정
                attachFileMimeBody.setFileName(MimeUtility.encodeText(orgFileName,"UTF-8","B"));

                //첨부파일 데이터 설정
                FileDataSource fileDataSource = new FileDataSource(attachFile);
                DataHandler dataHandler = new DataHandler(fileDataSource);

                attachFileMimeBody.setDataHandler(dataHandler);
                attachFileMimeBody.setDescription("UTF-8");

                //최종적으로 설정한 값을 message에 추가
                mp.addBodyPart(attachFileMimeBody);
                message.setContent(mp);
            }

        }else{
            ((MimeMessage) message).setSubject(subject, "UTF-8");
            message.setFrom(new InternetAddress(fromemail));
            ((MimeMessage) message).setContent(content, "text/html; charset=UTF-8");
        }

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
