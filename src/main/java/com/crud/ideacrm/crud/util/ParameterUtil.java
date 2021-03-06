package com.crud.ideacrm.crud.util;

import com.crud.ideacrm.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
@Component
public class ParameterUtil {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CodecUtil codecUtil;

    public Map<String, Object> searchParam(HttpServletRequest request) {

        Map<String, Object> search = new HashMap();

        if (request.getSession().getAttribute("SITEID") != null) {
            int SITEID = Integer.parseInt(request.getSession().getAttribute("SITEID").toString());
            search.put("siteid", SITEID);
        }
        Enumeration params = request.getParameterNames();

        while (params.hasMoreElements()) {
            String name = (String) params.nextElement();
            String value = request.getParameter(name);
            if (name.contains("date")) {
                //date라는 name 이 있는 경우 date형이 2019-01-01 ~ 2019-02-01 으로 넘어오기때문에 fr, to로 나누어서 처리해 주어야 할것 같음.
                // 또한 고객중 일부가 input 창에서 데이터를 임의로 지우는 경우가 있을 것으로 보아서 ~포함해서 지우는 경우에는 fr로 인식한다.
                if (value.contains("~")) {
                    // ~표가 있는경우
                    int idx = value.replace(" ", "").indexOf("~");

                    search.put(name + "fr", value.substring(0, idx));
                    search.put(name + "to", value.substring(idx + 3));
                } else {
                    // ~표가 없는경우
                    if(value.equals("")){
                        value = null;
                    }else{
                        search.put(name + "fr", value);
                    }
                }
            } else {
                if (value == "") {
                    value = null;
                }
                search.put(name, value);
            }
        }
        return search;
    }

    public String columnUnion(String... column) throws UnsupportedEncodingException, GeneralSecurityException {

        CodecUtil codecUtil = new CodecUtil();
        int columnLength = column.length;
        String columnUnion ="";
        for (int i = 0; i < columnLength; i++){
            if(i == columnLength-1){
                columnUnion = columnUnion + column[i];
            }else{
                columnUnion = columnUnion + column[i] + '-';
            }
        }
        columnUnion = codecUtil.encoding(columnUnion);
        return columnUnion;
    }

    public String getMapValueNullCheck(Map target, String key) {
        if(target.get(key) != null) {
            return target.get(key).toString();
        }else {
            return "";
        }
    }

    public static boolean isEmpty(Object obj) {

        if(obj == null) return true;
        if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; }
        if (obj instanceof Map) { return ((Map<?, ?>) obj).isEmpty(); }
        if (obj instanceof Map) { return ((Map<?, ?>)obj).isEmpty(); }
        if (obj instanceof List) { return ((List<?>)obj).isEmpty(); }
        if (obj instanceof Object[]) { return (((Object[])obj).length == 0); }
        return false;

    }


}
