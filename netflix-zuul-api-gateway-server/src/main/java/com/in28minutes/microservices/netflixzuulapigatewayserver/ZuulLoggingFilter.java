package com.in28minutes.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //should this filter be executed it or not
    //we can write Business logic for it
    //for now we enable it for all request
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //logic or action that we need to perform
    @Override
    public Object run() {
        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}",
                request, request.getRequestURI());
        return null;
    }

    //when should the filter happen
    //before
    //after
    //or only error request
    @Override
    public String filterType() {
        return "pre";
    }

    //setting a priority order
    @Override
    public int filterOrder() {
        return 1;
    }
}
