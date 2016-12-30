
## 服务器部署须知

mkdir -p /opt/data/gateway/filter
用于加载网关配置



## zuul 重写request

不太实用，够造HttpServletRequest有些困难

http://stackoverflow.com/questions/30400817/how-to-pass-modified-wrapped-httpservletrequest-to-subsequent-zuul-filters

```
RequestContext context = RequestContext.getCurrentContext();
HttpServletRequest request = context.getRequest();
.
.
. 
context.setRequest(new CustomRequestWrapper(request, extra));
```



## zuul proxy
https://coffea.io/how-to-create-a-simple-reverse-proxy-server-with-spring-cloud-and-netflix-zuul/


## 条件路由

可以用于构造灰度环境

zuul.routes.service=/service/** 
zuul.routes.datacenter1=/datacenter1/service/** 
zuul.routes.datacenter2=/datacenter2/service/**

RequestContext.getCurrentContext().getRequest().setAttribute(WebUtils.INCLUDE_REQUEST_URI_ATTRIBUTE, "/datacenter1/" + requesrUri);


https://github.com/spring-cloud/spring-cloud-netflix/issues/1169