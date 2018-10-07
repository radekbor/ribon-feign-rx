package org.radekbor.books;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // Setup MDC data:
            String mdcData = String.format("[remoteAdd:%s] ",
                    request.getRemoteAddr());
            MDC.put("mdcData", mdcData); //Variable 'mdcData' is referenced in Spring Boot's logging.pattern.level property
            chain.doFilter(request, response);
        } finally {
            // Tear down MDC data:
            // ( Important! Cleans up the ThreadLocal data again )
            MDC.clear();
        }
    }

    @Override
    public void destroy() {

    }
}