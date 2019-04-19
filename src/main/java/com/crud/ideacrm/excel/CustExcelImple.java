package com.crud.ideacrm.excel;

import com.crud.ideacrm.crud.util.CodecUtil;
import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.crud.util.UploadUtil;
import com.crud.ideacrm.dao.CustDao;
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
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

@Service
public class CustExcelImple implements CustExcel {

    @Autowired
    CustDao custDao;
    @Autowired
    ParameterUtil parameterUtil;
    @Autowired
    UploadUtil uploadUtil;
    @Autowired
    CodecUtil codecUtil;

    private static final Logger logger = LoggerFactory.getLogger(ServiceExcel.class);
    //고객목록 대용량 엑셀 다운로드

    @Override
    public void custListExcelDownload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, GeneralSecurityException {

        int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
        Map<String, Object> searchVal = parameterUtil.searchParam(request);
//		searchVal.put("infoagree", 0);
        List<Map<String, Object>> note = custDao.custList(searchVal);
        note = codecUtil.decodeList(note);
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
        cell.setCellValue("고객목록");
        cell.setCellStyle(columnColor);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));


        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("고객명");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(1);
        cell.setCellValue("부서");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(2);
        cell.setCellValue("직책");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(3);
        cell.setCellValue("휴대폰");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(4);
        cell.setCellValue("이메일");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(5);
        cell.setCellValue("담당자");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(6);
        cell.setCellValue("고객구분");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(7);
        cell.setCellValue("고객등급");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(8);
        cell.setCellValue("정보활용여부");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(9);
        cell.setCellValue("등록일");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        try {


            int size = note.size();
            //데이터 칼럼에 맞춰 바인딩
            for (int rowNum = 1; rowNum <= size; rowNum++) {
                row = sheet.createRow(rowNum+1);
                String custName = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "CUSTNAME");
                String deptName = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "DEPTNAME");
                String duty = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "DUTY");
                String mobile = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "MOBILE");
                String email = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "EMAIL");
                String owner_ = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "OWNER_");
                String custGubun = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "CUSTGUBUN");
                String custGrade = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "CUSTGRADE");
                String infoAgree = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "INFOAGREE");
                String regdate = parameterUtil.getMapValueNullCheck(note.get(rowNum-1), "REGDATE");

                cell = row.createCell(0);
                cell.setCellValue(custName);
                cell.setCellStyle(style);

                cell = row.createCell(1);
                cell.setCellValue(deptName);
                cell.setCellStyle(style);

                cell = row.createCell(2);
                cell.setCellValue(duty);
                cell.setCellStyle(style);

                cell = row.createCell(3);
                cell.setCellValue(mobile);
                cell.setCellStyle(style);

                cell = row.createCell(4);
                cell.setCellValue(email);
                cell.setCellStyle(style);

                cell = row.createCell(5);
                cell.setCellValue(owner_);
                cell.setCellStyle(style);

                cell = row.createCell(6);
                cell.setCellValue(custGubun);
                cell.setCellStyle(style);

                cell = row.createCell(7);
                cell.setCellValue(custGrade);
                cell.setCellStyle(style);

                cell = row.createCell(8);
                if(infoAgree.equals("0")) {
                    cell.setCellValue("동의");
                }else {
                    cell.setCellValue("거부");
                }
                cell.setCellStyle(style);

                cell = row.createCell(9);
                cell.setCellValue(regdate);
                cell.setCellStyle(style);

            }


            //여기서부터 다운로드
            response.setHeader("Set-Cookie", "fileDownload=true; path=/");
            String fileDate = uploadUtil.fileSearchKey(request);
            String excelfileName = fileDate+"_고객목록.xlsx";
            response.setHeader("Content-Disposition", String.format("attachment; filename=\""+excelfileName+"\""));
            wb.write(response.getOutputStream());

        } catch (Exception e) {
            response.setHeader("Set-Cookie", "fileDownload=false; path=/");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Content-Type", "text/html; charset=utf-8");

            logger.debug("error---------------떨어");
            e.printStackTrace();
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                logger.debug("error---------------");
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
