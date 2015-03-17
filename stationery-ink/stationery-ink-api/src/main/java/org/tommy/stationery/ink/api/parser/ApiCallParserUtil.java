package org.tommy.stationery.ink.api.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.tommy.stationery.ink.api.domain.DynamicApiCallInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 2. 9..
 */
public class ApiCallParserUtil {
    public static DynamicApiCallInfo parse(String apiName, HttpServletRequest request) throws RecognitionException {
        apiName = apiName.replace("get", " get ");
        apiName = apiName.replace("By", " By ");
        apiName = apiName.replace("And", " And ");

        ANTLRStringStream in = new ANTLRStringStream(apiName);
        DYNAMIC_API_SQLLexer lexer = new DYNAMIC_API_SQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DYNAMIC_API_SQLParser parser = new DYNAMIC_API_SQLParser(tokens);
        parser.get_api_statement();

        DynamicApiCallInfo dynamicApiCallInfo = parser.getDynamicApiCallInfo();
        Map<String, String[]> parameters = request.getParameterMap();
        HashMap<String, String> params = new HashMap<String, String>();
        for(String key : parameters.keySet()) {
            String[] vals = parameters.get(key);
            for(String val : vals)
                params.put(key, val);
        }
        dynamicApiCallInfo.setParams(params);
        return dynamicApiCallInfo;
    }
}
