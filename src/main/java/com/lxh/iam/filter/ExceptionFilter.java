package com.lxh.iam.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class ExceptionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==> exception filter init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("===> do filter exception ...");
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {

            /// 异常捕获，发送到error controller
            request.setAttribute("filter.error", e);
            //将异常分发到/error/throw控制器
            request.getRequestDispatcher("/error/throw").forward(request, response);

        }
    }

    @Override
    public void destroy() {

    }
}
