package com.politics.chn.common.secuity;

import cn.hutool.json.JSONUtil;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.result.ReturnResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @since 2021-04-03
 * @author andyssder
 */
@Component
public class NoAccessHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ReturnResult.failure(ResultStatusEnum.UNAUTHORIZED)));
        response.getWriter().flush();
    }
}