package com.benym.rpas.common.core.logger;

import cn.hutool.json.JSONUtil;
import com.benym.rpas.common.core.trace.TraceRequestWrapper;
import com.benym.rpas.common.core.trace.TraceResponseWrapper;
import com.benym.rpas.common.dto.request.RequestLog;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @date 2022/7/12 7:05 下午
 */
public class LoggerHttp {

    public static RequestLog init(TraceRequestWrapper traceRequestWrapper) {
        RequestLog requestLog = new RequestLog();
        requestLog.setRequestUrl(traceRequestWrapper.getRequestURI());
        requestLog.setRemoteAddr(traceRequestWrapper.getRemoteAddr());
        requestLog.setRequestHeaders(traceRequestWrapper.getHeaders());
        String method = traceRequestWrapper.getMethod();
        requestLog.setMethod(method);
        if (method.equals(RequestMethod.GET.name())) {
            requestLog.setRequestParams(JSONUtil.toJsonStr(traceRequestWrapper.getParameterMap()));
        } else {
            requestLog.setRequestParams(getPostData(traceRequestWrapper));
        }
        return requestLog;
    }

    public static void update(RequestLog requestLog, TraceResponseWrapper traceResponseWrapper) throws IOException {
        requestLog.setStatus(traceResponseWrapper.getStatus());
        requestLog.setResponse(new String(traceResponseWrapper.getContentAsByteArray()));
        traceResponseWrapper.copyBodyToResponse();
        requestLog.setResponseHeaders(traceResponseWrapper.getHeaders());
    }

    public static String getPostData(TraceRequestWrapper traceRequestWrapper) {
        StringBuilder data = new StringBuilder();
        String line;
        BufferedReader reader;
        try {
            reader = traceRequestWrapper.getReader();
            while (null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return JSONUtil.toJsonStr(data.toString());
    }
}
