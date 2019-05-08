package com.crud.ideacrm.excel;

import com.crud.ideacrm.crud.util.ParameterUtil;
import com.crud.ideacrm.crud.util.UploadUtil;
import com.crud.ideacrm.dao.ProductDao;
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
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
public class OrderExcel {

    @Autowired
    private ParameterUtil prmUtil;
    @Autowired
    UploadUtil uploadUtil;
    @Autowired
    private ProductDao productDao;

    private static final Logger logger = LoggerFactory.getLogger(OrderExcel.class);

    @RequestMapping(value = "/orderexcel", method = RequestMethod.GET)
    public void serviceExcel(HttpServletRequest request, HttpServletResponse response){
        String regdate = request.getParameter("orderdate");
        String merge = request.getParameter("mergeorder");
        int siteId = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());

        Map<String, Object> orderVal = new HashMap<>();
        orderVal.put("siteid", siteId);

        if (regdate.contains("~")) {

                int idx = regdate.replace(" ", "").indexOf("~");

                orderVal.put("regdatefr", regdate.substring(0, idx));
                orderVal.put("regdateto", regdate.substring(idx + 3));
        }


        List<Map<String, Object>> order = productDao.orderOrderExcel(orderVal);

        //SXSSF 방식 엑셀 생성
        SXSSFWorkbook wb = new SXSSFWorkbook();
        SXSSFCell cell;
        SXSSFSheet sheet = wb.createSheet();
        SXSSFRow row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        CellStyle columnColor = wb.createCellStyle();
        CellStyle headerColor = wb.createCellStyle();



        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);    // 셀 좌측에 얇은 실선 적용.
        style.setBorderRight(CellStyle.BORDER_THIN);    // 셀 우측에 얇은 실선 적용.
        style.setBorderTop(CellStyle.BORDER_THIN);    // 셀 윗쪽에 얇은 실선 적용.
        columnColor.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        columnColor.setFillPattern(CellStyle.SOLID_FOREGROUND);
        columnColor.setAlignment(CellStyle.ALIGN_CENTER);

        String regdatefr = orderVal.get("regdatefr").toString();
        String regdateto = orderVal.get("regdateto").toString();


        cell = row.createCell(0);
        cell.setCellValue( regdatefr+"-"+regdateto+"주문내역");
        cell.setCellStyle(columnColor);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));


        row = sheet.createRow(1);

        cell = row.createCell(0);
        cell.setCellValue("주문번호");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(1);
        cell.setCellValue("구매자");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(2);
        cell.setCellValue("받는이");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(3);
        cell.setCellValue("휴대폰");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(4);
        cell.setCellValue("자택전화");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(5);
        cell.setCellValue("받는이");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(6);
        cell.setCellValue("배송메모");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(7);
        cell.setCellValue("IDEA코드");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(8);
        cell.setCellValue("회사코드");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(9);
        cell.setCellValue("제품명");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(10);
        cell.setCellValue("수량");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);

        cell = row.createCell(11);
        cell.setCellValue("가격");
        cell.setCellStyle(style);
        cell.setCellStyle(columnColor);


            try {
                int a = 1;
                for (int i = 0; i < order.size(); i++) {
                    row = sheet.createRow(a + 1);
                    String orderNum = prmUtil.getMapValueNullCheck(order.get(a-1), "BUYNO");
                    String buyUser = prmUtil.getMapValueNullCheck(order.get(a-1), "CUSTNAME");
                    String deliveryName = prmUtil.getMapValueNullCheck(order.get(a-1), "DELIVERYNAME");
                    String mobile = prmUtil.getMapValueNullCheck(order.get(a-1), "MOBILE");
                    String tel = prmUtil.getMapValueNullCheck(order.get(a-1), "HOMTEL");
                    String addr = prmUtil.getMapValueNullCheck(order.get(a-1), "ADDR");
                    String memo = prmUtil.getMapValueNullCheck(order.get(a-1), "DELIVERYDESC");
                    String prdvalue = prmUtil.getMapValueNullCheck(order.get(a-1), "PRDVALUE");
                    String erpno = prmUtil.getMapValueNullCheck(order.get(a-1), "ERPNO");
                    String prdname = prmUtil.getMapValueNullCheck(order.get(a-1), "PRDNAME");
                    String prdea = prmUtil.getMapValueNullCheck(order.get(a-1), "PRDEA");
                    String prdprice = prmUtil.getMapValueNullCheck(order.get(a-1), "PRDPRICE");



                    cell = row.createCell(0);
                    cell.setCellValue(orderNum);
                    cell.setCellStyle(style);

                    cell = row.createCell(1);
                    cell.setCellValue(buyUser);
                    cell.setCellStyle(style);

                    cell = row.createCell(2);
                    cell.setCellValue(deliveryName);
                    cell.setCellStyle(style);

                    cell = row.createCell(3);
                    cell.setCellValue(mobile);
                    cell.setCellStyle(style);

                    cell = row.createCell(4);
                    cell.setCellValue(tel);
                    cell.setCellStyle(style);

                    cell = row.createCell(5);
                    cell.setCellValue(addr);
                    cell.setCellStyle(style);

                    cell = row.createCell(6);
                    cell.setCellValue(memo);
                    cell.setCellStyle(style);

                    cell = row.createCell(7);
                    cell.setCellValue(prdvalue);
                    cell.setCellStyle(style);

                    cell = row.createCell(8);
                    cell.setCellValue(erpno);
                    cell.setCellStyle(style);

                    cell = row.createCell(9);
                    cell.setCellValue(prdname);
                    cell.setCellStyle(style);

                    cell = row.createCell(10);
                    cell.setCellValue(prdea);
                    cell.setCellStyle(style);

                    cell = row.createCell(11);
                    cell.setCellValue(prdprice);
                    cell.setCellStyle(style);

                    a++;

                }

                //여기서부터 다운로드
                response.setHeader("Set-Cookie", "fileDownload=true; path=/");
                String fileDate = uploadUtil.fileSearchKey(request);

                String excelfileName = fileDate+"_"+regdatefr+"-"+regdateto+"_"+"주문내역";
                response.setHeader("Content-Disposition", "attachment;filename="+new String(excelfileName.getBytes("euc-kr"),"8859_1")+".xlsx");
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


