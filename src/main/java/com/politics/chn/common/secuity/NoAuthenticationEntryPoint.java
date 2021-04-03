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
 * @author xu
 * @create 2021-04-03 10:31
 */
@Component
public class NoAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ReturnResult.failure(ResultStatusEnum.UNAUTHORIZED)));
        response.getWriter().flush();
    }
}
