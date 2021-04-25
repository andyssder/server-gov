package com.politics.chn.common.secuity;

import cn.hutool.json.JSONUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.result.ReturnResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @since 2021-04-03
 * @author xu
 */
@Component
public class NoAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // 这个地方不能设置跨域, 会造成前端
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include
        // response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ReturnResult.failure(ResultStatusEnum.FORBIDDEN)));
        response.getWriter().flush();
    }
}
