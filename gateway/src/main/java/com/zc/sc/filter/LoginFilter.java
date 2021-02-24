package com.zc.sc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @作者： zc
 * @时间： 2021/2/24 17:58
 * @描述： 登录过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {//前置过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {//过滤顺序
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {//是否进行过滤，必须的
        return true;
    }

    @Override
    public Object run() throws ZuulException {//业务逻辑
        //获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = ctx.getRequest();
        //获取请求参数access-token
        String token = request.getParameter("access-token");
        //判断是否存在
        if(StringUtils.isBlank(token)) {
            //不存在，未登录，则拦截
            ctx.setSendZuulResponse(false);//true 放行，false 拦截
            //返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        return null;
    }
}
