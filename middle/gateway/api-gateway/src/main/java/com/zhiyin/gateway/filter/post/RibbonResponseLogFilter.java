package com.zhiyin.gateway.filter.post;

import com.netflix.client.IResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * 如果没有使用ribbon或者ribbon调用失败,不会有这个值。
 * org.springframework.cloud.netflix.zuul.filters.route.support.AbstractRibbonCommand
 */
@Slf4j
@Component
public class RibbonResponseLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            // contains not work
//            if( !ctx.contains("ribbonResponse")){
//                return null;
//            }

            if(ctx.get("ribbonResponse") == null){
                return null;
            }
            URI ribbonResponseURI = ((IResponse)ctx.get("ribbonResponse") ).getRequestedURI();
            log.info("ribbon call remote server uri:{}",ribbonResponseURI.toString());
        }catch (Exception e){
            log.error("ribbon respoonse error.",e);
        }
        return null;
    }
}