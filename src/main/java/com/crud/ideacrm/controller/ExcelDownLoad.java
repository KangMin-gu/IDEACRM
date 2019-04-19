package com.crud.ideacrm.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;


import com.crud.ideacrm.excel.CustExcelImple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ExcelDownLoad {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelDownLoad.class);

	@Autowired
	private CustExcelImple custExcel;
	/*
	@Autowired
	private AuDao auDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private SvDao svDao;
	@Autowired
	private SalesDao saDao;
	@Autowired
	private ClientDao cliDao;
	@Autowired
	private CampaignDao campaignDao;
	*/

	//임시 메서드. getMapValueNullCheck, fileSearchKey 엔진단으로 빠질예정
	public String getMapValueNullCheck(Map target, String key) {
		if(target.get(key) != null) {
			return target.get(key).toString();
		}else {
			return "";
		}
	}
	// 파일 서치키 생성
	public String fileSearchKey(HttpServletRequest request) {
		int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = time.format(calendar.getTime());
		String fileSearchKey = date+userNo;
		return fileSearchKey;
	}

	//고객목록 대용량 엑셀 다운로드
	@RequestMapping(value = "/custexcel", method = RequestMethod.GET)
	public void custListExcelDownload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, GeneralSecurityException {
		custExcel.custListExcelDownload(request,response);
	}
	/*
	@RequestMapping(value="/userexcelform",method=RequestMethod.GET)
	public void auUserForm(HttpServletRequest request, HttpServletResponse response) {
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
		
		cell = row.createCell(0);
		cell.setCellValue("사용자목록");
		cell.setCellStyle(columnColor);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		
		
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("사용자명");
		cell.setCellStyle(style);
		cell.setCellStyle(columnColor);
		
		cell = row.createCell(1);
		cell.setCellValue("사용자ID");
		cell.setCellStyle(style);
		cell.setCellStyle(columnColor);
		
		cell = row.createCell(2);
		cell.setCellValue("직책");
		cell.setCellStyle(style);
		cell.setCellStyle(columnColor);
		
		cell = row.createCell(3);
		cell.setCellValue("입사일자");
		cell.setCellStyle(style);
		cell.setCellStyle(columnColor);
		
		cell = row.createCell(4);
		cell.setCellValue("등록일");
		cell.setCellStyle(style);
		cell.setCellStyle(columnColor);
		try {
			//여기서부터 다운로드 
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			String fileDate = crud.fileSearchKey(request);	
			String excelfileName = fileDate+"_엑셀업로드양식(사용자).xlsx";
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
	//고객목록 대용량 엑셀 다운로드
		@RequestMapping(value = "/userexcel", method = RequestMethod.GET)
		public void adUser(HttpServletRequest request, HttpServletResponse response) {
			int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
			Map<String, Object> searchVal = crud.searchParam(request);
			
			List<Map<String, Object>> adUser = auDao.urList(searchVal);
			
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
			cell.setCellValue("사용자목록");
			cell.setCellStyle(columnColor);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
			
			
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("사용자명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(1);
			cell.setCellValue("사용자ID");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(2);
			cell.setCellValue("직책");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(3);
			cell.setCellValue("입사일자");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(4);
			cell.setCellValue("등록일");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			try {
			
				
				//데이터 칼럼에 맞춰 바인딩
				for (int rowNum = 1; rowNum <= adUser.size(); rowNum++) {			
					row = sheet.createRow(rowNum+1);			
					String userName = crud.getMapValueNullCheck(adUser.get(rowNum-1), "USERNAME");
					String userId = crud.getMapValueNullCheck(adUser.get(rowNum-1), "USERID");
					String userDuty = crud.getMapValueNullCheck(adUser.get(rowNum-1), "USERDUTY");
					String enterDate = crud.getMapValueNullCheck(adUser.get(rowNum-1), "ENTERDATE");
					String regDate = crud.getMapValueNullCheck(adUser.get(rowNum-1), "REGDATE");

					cell = row.createCell(0);
					cell.setCellValue(userName);
					cell.setCellStyle(style);
					
					cell = row.createCell(1);
					cell.setCellValue(userId);
					cell.setCellStyle(style);

					cell = row.createCell(2);
					cell.setCellValue(userDuty);
					cell.setCellStyle(style);

					cell = row.createCell(3);
					cell.setCellValue(enterDate);
					cell.setCellStyle(style);
					
					cell = row.createCell(4);
					cell.setCellValue(regDate);
					cell.setCellStyle(style);
				}
				
					
				//여기서부터 다운로드 
				response.setHeader("Set-Cookie", "fileDownload=true; path=/");
				String fileDate = crud.fileSearchKey(request);	
				String excelfileName = fileDate+"_사용자목록.xlsx";
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
		@RequestMapping(value = "/companyexcel", method = RequestMethod.GET)
		public void companyExcel(HttpServletRequest request, HttpServletResponse response) {
			int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
			Map<String, Object> searchVal = crud.searchParam(request);
			List<Map<String, Object>> company = companyDao.companyList(searchVal);
			
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
			cell.setCellValue("회원사 목록");
			cell.setCellStyle(columnColor);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
			
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("회원사명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(1);
			cell.setCellValue("대표자명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(2);
			cell.setCellValue("사업자번호");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(3);
			cell.setCellValue("핸드폰번호");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(4);
			cell.setCellValue("종목");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(5);
			cell.setCellValue("기업규모");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(6);
			cell.setCellValue("가입일");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(7);
			cell.setCellValue("라이센스구매갯수");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(8);
			cell.setCellValue("서비스상태");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			try {
			
				
				//데이터 칼럼에 맞춰 바인딩
				for (int rowNum = 1; rowNum <= company.size(); rowNum++) {			
					row = sheet.createRow(rowNum+1);
					
					String siteName = crud.getMapValueNullCheck(company.get(rowNum-1), "SITENAME");
					String prsdName = crud.getMapValueNullCheck(company.get(rowNum-1), "PRSDNAME");
					String bsNo = crud.getMapValueNullCheck(company.get(rowNum-1), "BSNO");
					String mobile = crud.getMapValueNullCheck(company.get(rowNum-1), "MOBILE");
					String bsType = crud.getMapValueNullCheck(company.get(rowNum-1), "BSTYPE");
					String siteSize = crud.getMapValueNullCheck(company.get(rowNum-1), "SITESIZE");
					String fregDate = crud.getMapValueNullCheck(company.get(rowNum-1), "FREGDATE");
					String buyCnt = crud.getMapValueNullCheck(company.get(rowNum-1), "BUYCNT");
					String isDelete = crud.getMapValueNullCheck(company.get(rowNum-1), "ISDELETE");

					cell = row.createCell(0);
					cell.setCellValue(siteName);
					cell.setCellStyle(style);
					
					cell = row.createCell(1);
					cell.setCellValue(prsdName);
					cell.setCellStyle(style);

					cell = row.createCell(2);
					cell.setCellValue(bsNo);
					cell.setCellStyle(style);

					cell = row.createCell(3);
					cell.setCellValue(mobile);
					cell.setCellStyle(style);
					
					cell = row.createCell(4);
					cell.setCellValue(bsType);
					cell.setCellStyle(style);
					
					cell = row.createCell(5);
					cell.setCellValue(siteSize);
					cell.setCellStyle(style);
					
					cell = row.createCell(6);
					cell.setCellValue(fregDate);
					cell.setCellStyle(style);
					
					cell = row.createCell(7);
					cell.setCellValue(buyCnt);
					cell.setCellStyle(style);
					
					cell = row.createCell(8);
					cell.setCellValue(isDelete);				
					cell.setCellStyle(style);
				}
									
				
					
				//여기서부터 다운로드 
				response.setHeader("Set-Cookie", "fileDownload=true; path=/");
				String fileDate = crud.fileSearchKey(request);	
				String excelfileName = fileDate+"_회원사목록.xlsx";
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
		//고객목록 대용량 엑셀 다운로드
		@RequestMapping(value = "/serviceexcel", method = RequestMethod.GET)
		public void serviceExcel(HttpServletRequest request, HttpServletResponse response) {
			int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
			Map<String, Object> searchVal = crud.searchParam(request);
			List<Map<String, Object>> note = svDao.svList(searchVal);
			
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
			cell.setCellValue("거래처명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(5);
			cell.setCellValue("접수일");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(6);
			cell.setCellValue("접수자");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(7);
			cell.setCellValue("담당자");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(8);
			cell.setCellValue("처리상태");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			try {
			
				
				//데이터 칼럼에 맞춰 바인딩
				for (int rowNum = 1; rowNum <= note.size(); rowNum++) {			
					row = sheet.createRow(rowNum+1);			
					String rcvName = crud.getMapValueNullCheck(note.get(rowNum-1), "SERVICENAME");
					String rcvType = crud.getMapValueNullCheck(note.get(rowNum-1), "SERVICETYPE_");
					String rcvChannel = crud.getMapValueNullCheck(note.get(rowNum-1), "SERVICECODE_");
					String custName = crud.getMapValueNullCheck(note.get(rowNum-1), "CUSTNAME_");
					String cliName = crud.getMapValueNullCheck(note.get(rowNum-1), "CLINO_");
					String rcvDate = crud.getMapValueNullCheck(note.get(rowNum-1), "RECEPTIONDATE_");
					String rcvOwner = crud.getMapValueNullCheck(note.get(rowNum-1), "SERVICEOWNER_");
					String ractOwner = crud.getMapValueNullCheck(note.get(rowNum-1), "OWNER_");
					String prcState = crud.getMapValueNullCheck(note.get(rowNum-1), "SERVICESTEP_");

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
					cell.setCellValue(cliName);
					cell.setCellStyle(style);
					
					cell = row.createCell(5);
					cell.setCellValue(rcvDate);
					cell.setCellStyle(style);
					
					cell = row.createCell(6);
					cell.setCellValue(rcvOwner);
					cell.setCellStyle(style);
					
					cell = row.createCell(7);
					cell.setCellValue(ractOwner);
					cell.setCellStyle(style);
					
					cell = row.createCell(8);
					cell.setCellValue(prcState);				
					cell.setCellStyle(style);
									
				}
				
					
				//여기서부터 다운로드 
				response.setHeader("Set-Cookie", "fileDownload=true; path=/");
				String fileDate = crud.fileSearchKey(request);	
				String excelfileName = fileDate+"_서비스목록.xlsx";
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
		
		
		
		//영업목록 엑셀 다운로드 
		@RequestMapping(value = "/salesexcel", method = RequestMethod.GET)
		public void salesExcel(HttpServletRequest request, HttpServletResponse response) {
			int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
			Map<String, Object> searchVal = crud.searchParam(request);
			List<Map<String, Object>> note = saDao.salesList(searchVal);
			
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
			cell.setCellValue("영업목록");
			cell.setCellStyle(columnColor);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
			
			
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("영업건명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(1);
			cell.setCellValue("거래처명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(2);
			cell.setCellValue("예상수주일");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(3);
			cell.setCellValue("현단계");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
			cell = row.createCell(4);
			cell.setCellValue("영업담당자");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			
		
			
			try {
			
				
				//데이터 칼럼에 맞춰 바인딩
				for (int rowNum = 1; rowNum <= note.size(); rowNum++) {			
					row = sheet.createRow(rowNum+1);			
					String saleName = crud.getMapValueNullCheck(note.get(rowNum-1), "SALENAME");
					String cliName = crud.getMapValueNullCheck(note.get(rowNum-1), "CLINAME");
					String fordDate = crud.getMapValueNullCheck(note.get(rowNum-1), "FORDDATE");
					String saleState = crud.getMapValueNullCheck(note.get(rowNum-1), "SALESTATE");
					String userName = crud.getMapValueNullCheck(note.get(rowNum-1), "USERNAME");
					

					cell = row.createCell(0);
					cell.setCellValue(saleName);
					cell.setCellStyle(style);
					
					cell = row.createCell(1);
					cell.setCellValue(cliName);
					cell.setCellStyle(style);

					cell = row.createCell(2);
					cell.setCellValue(fordDate);
					cell.setCellStyle(style);

					cell = row.createCell(3);
					cell.setCellValue(saleState);
					cell.setCellStyle(style);
					
					cell = row.createCell(4);
					cell.setCellValue(userName);
					cell.setCellStyle(style);
					

																					
				}
				
					
				//여기서부터 다운로드 
				response.setHeader("Set-Cookie", "fileDownload=true; path=/");
				String fileDate = crud.fileSearchKey(request);	
				String excelfileName = fileDate+"_영업목록.xlsx";
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
		
		//거래처목록 엑셀 다운로드
		@RequestMapping(value = "/cliexcel", method = RequestMethod.GET)
		public void clientExcel(HttpServletRequest request, HttpServletResponse response) {
			int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
			Map<String, Object> searchVal = crud.searchParam(request);
			List<Map<String, Object>> note = cliDao.clientList(searchVal);

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
			cell.setCellValue("거래처목록");
			cell.setCellStyle(columnColor);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));


			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("거래처명");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(1);
			cell.setCellValue("거래처호칭");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(2);
			cell.setCellValue("주소");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(3);
			cell.setCellValue("업종");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(4);
			cell.setCellValue("담당자");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(5);
			cell.setCellValue("중요도");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(6);
			cell.setCellValue("밀착도");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);

			cell = row.createCell(7);
			cell.setCellValue("거래처메모");
			cell.setCellStyle(style);
			cell.setCellStyle(columnColor);
			

			try {


				//데이터 칼럼에 맞춰 바인딩
				for (int rowNum = 1; rowNum <= note.size(); rowNum++) {			
					row = sheet.createRow(rowNum+1);			
					String cliName = crud.getMapValueNullCheck(note.get(rowNum-1), "CLINAME");
					String callName = crud.getMapValueNullCheck(note.get(rowNum-1), "CALLNAME");
					String addr = crud.getMapValueNullCheck(note.get(rowNum-1), "ADDR");
					String bsType = crud.getMapValueNullCheck(note.get(rowNum-1), "BSTYPE");
					String userName = crud.getMapValueNullCheck(note.get(rowNum-1), "USERNAME");
					String importance = crud.getMapValueNullCheck(note.get(rowNum-1), "IMPORTANCE");
					String friendly = crud.getMapValueNullCheck(note.get(rowNum-1), "FRIENDLY");
					String memo = crud.getMapValueNullCheck(note.get(rowNum-1), "MEMO");

					cell = row.createCell(0);
					cell.setCellValue(cliName);
					cell.setCellStyle(style);

					cell = row.createCell(1);
					cell.setCellValue(callName);
					cell.setCellStyle(style);

					cell = row.createCell(2);
					cell.setCellValue(addr);
					cell.setCellStyle(style);

					cell = row.createCell(3);
					cell.setCellValue(bsType);
					cell.setCellStyle(style);

					cell = row.createCell(4);
					cell.setCellValue(userName);
					cell.setCellStyle(style);
					
					cell = row.createCell(5);
					cell.setCellValue(importance);
					cell.setCellStyle(style);
					
					cell = row.createCell(6);
					cell.setCellValue(friendly);
					cell.setCellStyle(style);
					
					cell = row.createCell(7);
					cell.setCellValue(memo);
					cell.setCellStyle(style);


				}


				//여기서부터 다운로드 
				response.setHeader("Set-Cookie", "fileDownload=true; path=/");
				String fileDate = crud.fileSearchKey(request);	
				String excelfileName = fileDate+"_거래처목록.xlsx";
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
		
		
		
		//거래처목록 엑셀 다운로드
				@RequestMapping(value = "/ajaxCliexcel", method = RequestMethod.GET)
				@ResponseBody
				public void ajaxClientExcel(HttpServletRequest request, HttpServletResponse response) {
					
					int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
					Map<String, Object> searchVal = crud.searchParam(request);
					List<Map<String, Object>> note = cliDao.clientList(searchVal);

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
					cell.setCellValue("거래처목록");
					cell.setCellStyle(columnColor);
					sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));


					row = sheet.createRow(1);
					cell = row.createCell(0);
					cell.setCellValue("거래처명");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(1);
					cell.setCellValue("거래처호칭");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(2);
					cell.setCellValue("주소");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(3);
					cell.setCellValue("업종");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(4);
					cell.setCellValue("담당자");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(5);
					cell.setCellValue("중요도");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(6);
					cell.setCellValue("밀착도");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);

					cell = row.createCell(7);
					cell.setCellValue("거래처메모");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					

					try {


						//데이터 칼럼에 맞춰 바인딩
						for (int rowNum = 1; rowNum <= note.size(); rowNum++) {			
							row = sheet.createRow(rowNum+1);			
							String cliName = crud.getMapValueNullCheck(note.get(rowNum-1), "CLINAME");
							String callName = crud.getMapValueNullCheck(note.get(rowNum-1), "CALLNAME");
							String addr = crud.getMapValueNullCheck(note.get(rowNum-1), "ADDR");
							String bsType = crud.getMapValueNullCheck(note.get(rowNum-1), "BSTYPE");
							String userName = crud.getMapValueNullCheck(note.get(rowNum-1), "USERNAME");
							String importance = crud.getMapValueNullCheck(note.get(rowNum-1), "IMPORTANCE");
							String friendly = crud.getMapValueNullCheck(note.get(rowNum-1), "FRIENDLY");
							String memo = crud.getMapValueNullCheck(note.get(rowNum-1), "MEMO");

							cell = row.createCell(0);
							cell.setCellValue(cliName);
							cell.setCellStyle(style);

							cell = row.createCell(1);
							cell.setCellValue(callName);
							cell.setCellStyle(style);

							cell = row.createCell(2);
							cell.setCellValue(addr);
							cell.setCellStyle(style);

							cell = row.createCell(3);
							cell.setCellValue(bsType);
							cell.setCellStyle(style);

							cell = row.createCell(4);
							cell.setCellValue(userName);
							cell.setCellStyle(style);
							
							cell = row.createCell(5);
							cell.setCellValue(importance);
							cell.setCellStyle(style);
							
							cell = row.createCell(6);
							cell.setCellValue(friendly);
							cell.setCellStyle(style);
							
							cell = row.createCell(7);
							cell.setCellValue(memo);
							cell.setCellStyle(style);


						}


						//여기서부터 다운로드 
						response.setHeader("Set-Cookie", "fileDownload=true; path=/");
						String fileDate = crud.fileSearchKey(request);	
						String excelfileName = fileDate+"_거래처목록.xlsx";
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
				
				//고객목록 대용량 엑셀 다운로드
				@RequestMapping(value = "/campexcel", method = RequestMethod.GET)
				public void campaignExcel(HttpServletRequest request, HttpServletResponse response) {
								
					int userNo = Integer.parseInt(request.getSession().getAttribute("USERNO").toString());
					Map<String, Object> searchVal = crud.searchParam(request);
//					searchVal.put("infoagree", 0);
					List<Map<String, Object>> camp = campaignDao.campList(searchVal);
					
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
					cell.setCellValue("캠페인목록");
					cell.setCellStyle(columnColor);
					sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
					
					
					row = sheet.createRow(1);
					cell = row.createCell(0);
					cell.setCellValue("캠페인명");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(1);
					cell.setCellValue("캠페인 기간");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(2);
					cell.setCellValue("유형");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(3);
					cell.setCellValue("발송매체");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(4);
					cell.setCellValue("담당자");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(5);
					cell.setCellValue("진행단계");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(6);
					cell.setCellValue("읽은인원/전체인원");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					cell = row.createCell(7);
					cell.setCellValue("발송인원/전체인원");
					cell.setCellStyle(style);
					cell.setCellStyle(columnColor);
					
					try {
					
						
						//데이터 칼럼에 맞춰 바인딩
						for (int rowNum = 1; rowNum <= camp.size(); rowNum++) {			
							row = sheet.createRow(rowNum+1);			
							String campName = crud.getMapValueNullCheck(camp.get(rowNum-1), "CAMPNAME");
							String campDate = crud.getMapValueNullCheck(camp.get(rowNum-1), "CAMPDATE_");
							String campType = crud.getMapValueNullCheck(camp.get(rowNum-1), "CAMPTYPE_");
							String campForm = crud.getMapValueNullCheck(camp.get(rowNum-1), "CAMPFORM_");
							String owner_ = crud.getMapValueNullCheck(camp.get(rowNum-1), "OWNER_");
							String campStep = crud.getMapValueNullCheck(camp.get(rowNum-1), "CAMPSTEP_");
							String clickTotal = crud.getMapValueNullCheck(camp.get(rowNum-1), "CLICKTOTAL");
							String sendTotal = crud.getMapValueNullCheck(camp.get(rowNum-1), "SENDTOTAL");

							cell = row.createCell(0);
							cell.setCellValue(campName);
							cell.setCellStyle(style);
							
							cell = row.createCell(1);
							cell.setCellValue(campDate);
							cell.setCellStyle(style);

							cell = row.createCell(2);
							cell.setCellValue(campType);
							cell.setCellStyle(style);

							cell = row.createCell(3);
							cell.setCellValue(campForm);
							cell.setCellStyle(style);
							
							cell = row.createCell(4);
							cell.setCellValue(owner_);
							cell.setCellStyle(style);
							
							cell = row.createCell(5);
							cell.setCellValue(campStep);
							cell.setCellStyle(style);
							
							cell = row.createCell(6);
							cell.setCellValue(clickTotal);
							cell.setCellStyle(style);
							
							cell = row.createCell(7);
							cell.setCellValue(sendTotal);
							cell.setCellStyle(style);
											
						}
						
							
						//여기서부터 다운로드 
						response.setHeader("Set-Cookie", "fileDownload=true; path=/");
						String fileDate = crud.fileSearchKey(request);	
						String excelfileName = fileDate+"_캠페인목록.xlsx";
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
		*/

		
}