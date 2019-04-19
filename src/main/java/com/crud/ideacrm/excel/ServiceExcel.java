package com.crud.ideacrm.excel;


import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.crud.util.UploadUtil;
import com.crud.ideacrm.dao.ServiceDao;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
public class ServiceExcel {
    
    @Autowired
    private ServiceDao serviceDao;


    private static final Logger logger = LoggerFactory.getLogger(ServiceExcel.class);

    //고객목록 대용량 엑셀 다운로드
    @RequestMapping(value = "/serviceexcel", method = RequestMethod.GET)
    public void serviceExcel(HttpServletRequest request, HttpServletResponse response) {
        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        ParameterUtil parameterUtil = new ParameterUtil();
        UploadUtil uploadUtil = new UploadUtil();
        
        Map<String, Object> searchVal = parameterUtil.searchParam(request);
        List<Map<String, Object>> serviceList = serviceDao.serviceList(searchVal);

        //SXSSF 방식 엑셀 생성 
        SXSSFWorkbook wb = new SXSSFWorkbook();
        SXSSFCell cell;
        SXSSFSheet sheet = wb.createSheet();
        SXSSFRow row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        CellStyle columnColor = wb.createCellStyle();
        CellStyle headerColor = wb.createCellStyle();

        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);	// 셀 좌측에 얇은 실선 적용.
        style.setBorderRight(CellStyle.BORDER_THIN);	// 셀 우측에 얇은 실선 적용.
        style.setBorderTop(CellStyle.BORDER_THIN);	// 셀 윗쪽에 얇은 실선 적용.
        columnColor.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        columnColor.setFillPattern(CellStyle.SOLID_FOREGROUND);
        columnColor.setAlignment(CellStyle.ALIGN_CENTER);

        //시트이름생성
        //Sheet sh = wb.createSheet("First sheet");

        cell = row.createCell(0);
        cell.setCellValue("서비스목록");
        cell.setCellStyle(columnColor);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));


        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("서비스명");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(1);
        cell.setCellValue("접수구분");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(2);
        cell.setCellValue("접수유형");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(3);
        cell.setCellValue("고객명");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(4);
        cell.setCellValue("접수일");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(5);
        cell.setCellValue("접수자");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(6);
        cell.setCellValue("담당자");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(7);
        cell.setCellValue("처리상태");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        try {


            //데이터 칼럼에 맞춰 바인딩
            for (int rowNum = 1; rowNum <= serviceList.size(); rowNum++) {
                row = sheet.createRow(rowNum+1);
                String rcvName = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "SERVICENAME_");
                String rcvType = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "SERVICETYPE_");
                String rcvChannel = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "SERVICECODE_");
                String custName = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "CUSTNAME_");
                String rcvDate = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "RECEPTIONDATE_");
                String rcvOwner = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "SERVICEOWNER_");
                String ractOwner = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "OWNER_");
                String prcState = parameterUtil.getMapValueNullCheck(serviceList.get(rowNum-1), "SERVICESTEP_");

                cell = row.createCell(0);
                cell.setCellValue(rcvName);
                cell.setCellStyle(style);

                cell = row.createCell(1);
                cell.setCellValue(rcvType);
                cell.setCellStyle(style);

                cell = row.createCell(2);
                cell.setCellValue(rcvChannel);
                cell.setCellStyle(style);

                cell = row.createCell(3);
                cell.setCellValue(custName);
                cell.setCellStyle(style);

                cell = row.createCell(4);
                cell.setCellValue(rcvDate);
                cell.setCellStyle(style);

                cell = row.createCell(5);
                cell.setCellValue(rcvOwner);
                cell.setCellStyle(style);

                cell = row.createCell(6);
                cell.setCellValue(ractOwner);
                cell.setCellStyle(style);

                cell = row.createCell(7);
                cell.setCellValue(prcState);
                cell.setCellStyle(style);

            }


            //여기서부터 다운로드 
            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            String fileDate = uploadUtil.fileSearchKey(request);
            String excelfileName = fileDate+"_서비스목록.xlsx";
            response.setHeader("Content-Disposition", String.format("attachment; filename=\""+excelfileName+"\""));
            wb.write(response.getOutputStream());

        } catch (Exception e) {
            response.setHeader("Set-Cookie", "fileDownload=false; path=/");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Content-Type", "text/html; charset=utf-8");

            e.printStackTrace();
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                byte[] data = new String("fail..").getBytes();
                out.write(data, 0, data.length);
            } catch (Exception ignore) {
                ignore.printStackTrace();
            } finally {
                if (out != null)
                    try {
                        out.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
            }

        } finally {
            // 디스크 적었던 임시파일을 제거합니다.
            wb.dispose();
            try {
                wb.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
    }
}
