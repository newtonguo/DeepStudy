<div class="horizon-nav">
    <div class="intranet">中航信移动科技内网</div>
    <div class="head-v3">
        <div class="navigation-up">
            <div class="navigation-inner">
                <div class="navigation-v3">
                    <ul>
                        <li class="" _t_nav="home">
                            <h2>
                                <a href="<%=request.getContextPath() %>/pages/index.jsp"><img src="<%=request.getContextPath() %>/resource/images/index.png">首页</a>
                            </h2>
                        </li>
                        <li class="" _t_nav="bookstore">
                            <h2>
                                <a href="<%=request.getContextPath() %>/pages/Book/BookBorrow.jsp"><img src="<%=request.getContextPath() %>/resource/images/book.png">图书馆</a>
                            </h2>
                        </li>
                        <li class="" _t_nav="upload">
                            <h2>
                                <a href="<%=request.getContextPath() %>/pages/Online/OnlineRecord.jsp"><img src="<%=request.getContextPath() %>/resource/images/upload.png">上线管理</a>
                            </h2>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="navigation-down">
            <div id="bookstore" class="nav-down-menu menu-3 menu-1" style="display: none;" _t_nav="bookstore">
                <div class="navigation-down-inner">
                    <dl style="margin-left: 230px;">
                        <dd>
                            <a class="link" hotrep="family.header.bookstore.1" href="<%=request.getContextPath() %>/pages/Book/BookBorrow.jsp">图书借阅</a>
                        </dd>
                    </dl>
                    <dl>
                        <dd>
                            <a class="link" hotrep="family.header.bookstore.2" href="<%=request.getContextPath() %>/pages/Book/BookCategory.jsp">图书类别</a>
                        </dd>
                    </dl>
                    <dl>
                        <dd>
                            <a class="link" hotrep="family.header.bookstore.3" href="<%=request.getContextPath() %>/pages/Book/BookStatic.jsp">数据统计</a>
                        </dd>
                    </dl>
                    <dl>
                        <dd>
                            <a class="link" hotrep="family.header.bookstore.4" href="<%=request.getContextPath() %>/pages/Book/BookRecmd.jsp">新书推荐</a>
                        </dd>
                    </dl>
                </div>
            </div>
            <div id="upload" class="nav-down-menu menu-3 menu-1" style="display: none;" _t_nav="upload">
                <div class="navigation-down-inner">
                    <dl style="margin-left: 310px;">
                        <dd>
                            <a class="link" hotrep="family.header.upload.1" href="<%=request.getContextPath() %>/pages/Online/OnlineRecord.jsp">上线列表</a>
                        </dd>
                    </dl>
                    <dl>
                        <dd>
                            <a class="link" hotrep="family.header.upload.2" href="<%=request.getContextPath() %>/pages/Online/OnlineApply.jsp">上线申请</a>
                        </dd>
                    </dl>
                    <dl>
                        <dd>
                            <a class="link" hotrep="family.header.upload.3" href="<%=request.getContextPath() %>/pages/Online/OnlineCheck.jsp">上线审批</a>
                        </dd>
                    </dl>
                    <dl>
                        <dd>
                            <a class="link" hotrep="family.header.upload.4" href="<%=request.getContextPath() %>/pages/Online/OnlineDetail.jsp">选取上线人</a>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="vertical-nav">
    <ul id="accordion" class="accordion">
        <li>
            <div class="link vertical-index"><i class="icon icon-index"></i><a href="<%=request.getContextPath() %>/pages/index.jsp">首页</a></div>
        </li>
        <li>
            <div class="link vertical-bookstore"><i class="icon icon-bookstore"></i>图书馆<i class="icon icon-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="<%=request.getContextPath() %>/pages/Book/BookBorrow.jsp">图书借阅</a></li>
                <li><a href="<%=request.getContextPath() %>/pages/Book/BookCategory.jsp">图书类别</a></li>
                <li><a href="<%=request.getContextPath() %>/pages/Book/BookStatic.jsp">数据统计</a></li>
                <li><a href="<%=request.getContextPath() %>/pages/Book/BookRecmd.jsp">新书推荐</a></li>    
            </ul>
        </li>
        <li>
            <div class="link vertical-upload"><i class="icon icon-upload"></i>上线流程<i class="icon icon-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="<%=request.getContextPath() %>/pages/Online/OnlineRecord.jsp">上线列表</a></li>
                <li><a href="<%=request.getContextPath() %>/pages/Online/OnlineApply.jsp">上线申请</a></li>
                <li><a href="<%=request.getContextPath() %>/pages/Online/OnlineCheck.jsp">上线审批</a></li>
                <li><a href="<%=request.getContextPath() %>/pages/Online/OnlineChoose.jsp">选择上线人</a></li>
            </ul>
        </li>
    </ul>
</div>