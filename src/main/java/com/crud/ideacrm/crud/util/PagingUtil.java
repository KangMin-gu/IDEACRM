package com.crud.ideacrm.crud.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class PagingUtil {

    public Map<String, Integer> paging(HttpServletRequest request, int totalRows, int PAGE_ROW_COUNT,
                                       int PAGE_DISPLAY_COUNT) {
        //보여줄 페이지의 번호
        int pageNum=1;
        //보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
        String strPageNum=request.getParameter("pageNum");
        if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
            //페이지 번호를 설정한다.
            pageNum=Integer.parseInt(strPageNum);
        }
        //보여줄 페이지 데이터의 시작 ResultSet row 번호
        int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
        //보여줄 페이지 데이터의 끝 ResultSet row 번호
        int endRowNum=pageNum*PAGE_ROW_COUNT;
        //전체 row 의 갯수를 DB 에서 얻어온다.
        int totalRow = totalRows;
        //전체 페이지의 갯수 구하기
        int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
        //시작 페이지 번호
        int startPageNum=1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
        //끝 페이지 번호
        int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
        //끝 페이지 번호가 잘못된 값이라면
        if(totalPageCount < endPageNum){
            endPageNum=totalPageCount; //보정해준다.
        }

        Map<String, Integer> paging = new HashMap<>();

        paging.put("startRowNum", startRowNum);
        paging.put("endRowNum", endRowNum);
        paging.put("startPageNum", startPageNum);
        paging.put("endPageNum", endPageNum);
        paging.put("pageNum", pageNum);
        paging.put("totalPageCount", totalPageCount);

        return paging;
    }

}
