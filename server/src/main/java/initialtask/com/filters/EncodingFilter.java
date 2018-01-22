package initialtask.com.filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static final String FILTERABLE_CONTENT_TYPE="application/x-www-form-urlencoded";

    private static final String ENCODING_DEFAULT = "UTF-8";

    private static final String ENCODING_INIT_PARAM_NAME = "encoding";

    private String encoding;

    public void destroy() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String contentType = request.getContentType();
        if (contentType != null && contentType.startsWith(FILTERABLE_CONTENT_TYPE))
            request.setCharacterEncoding(encoding);

        chain.doFilter(request, response);
    }


    public void init(FilterConfig fConfig) throws ServletException {
        encoding = fConfig.getInitParameter(ENCODING_INIT_PARAM_NAME);
        if (encoding == null)
            encoding = ENCODING_DEFAULT;
    }
}