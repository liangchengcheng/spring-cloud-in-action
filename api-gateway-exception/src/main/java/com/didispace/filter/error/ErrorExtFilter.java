package com.didispace.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * 从post抛出异常。使用该过滤器返回错误信息
 */
@Component
public class ErrorExtFilter extends SendErrorFilter{
    Logger log = LoggerFactory.getLogger(ErrorExtFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        //获取当前的上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        ZuulFilter filter = (ZuulFilter) context.get("failed.filter");
        if (filter != null && filter.filterType().equals("post")){
            return true;
        }
        return false;
    }
}
