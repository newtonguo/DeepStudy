/**
 * Created by Administrator on 2015/5/3.
 */
$(function() {
    var Accordion = function(el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;
        var links = this.el.find('.link');
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    }

    Accordion.prototype.dropdown = function(e) {
        var $el = e.data.el;
        $this = $(this),
            $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        };
    }

    var accordion = new Accordion($('#accordion'), false);

    var qcloud={};
    $('[_t_nav]').hover(function(){
        var _nav = $(this).attr('_t_nav');
        clearTimeout( qcloud[ _nav + '_timer' ] );
        qcloud[ _nav + '_timer' ] = setTimeout(function(){
            $('[_t_nav]').each(function(){
                $(this)[ _nav == $(this).attr('_t_nav') ? 'addClass':'removeClass' ]('nav-up-selected');
            });
            $('#'+_nav).stop(true,true).slideDown(200);
            $('.vertical-'+_nav).parent().siblings().each(function(){
                $(this).children("ul").slideUp();
                $(this).removeClass('open');
            })
            if($('.vertical-'+_nav).next().is(":hidden")==false) {
                $('.vertical-' + _nav).next().slideDown();
                $('.vertical-' + _nav).parent().addClass('open');
            }else{
                $('.vertical-'+_nav).next().slideToggle();
                $('.vertical-'+_nav).parent().toggleClass('open');
            }
        }, 150);
    },function(){
        var _nav = $(this).attr('_t_nav');
        clearTimeout( qcloud[ _nav + '_timer' ] );
        qcloud[ _nav + '_timer' ] = setTimeout(function(){
            $('[_t_nav]').removeClass('nav-up-selected');
            $('#'+_nav).stop(true,true).slideUp(200);
            $('.vertical-'+_nav).parent().siblings().each(function(){
                $(this).children("ul").slideUp();
                $(this).removeClass('open');
            })
            if($('.vertical-'+_nav).next().is(":hidden")==false) {
                $('.vertical-' + _nav).next().slideDown();
                $('.vertical-' + _nav).parent().addClass('open');
            }else{
                $('.vertical-'+_nav).next().slideToggle();
                $('.vertical-'+_nav).parent().toggleClass('open');
            }
        }, 150);
    });
});

//点击注册
var show=function(obj){
    $(".mask").show().css({"opacity":"0.9","width":"100%","height":document.documentElement.scrollHeight+document.body.scrollHeight});
    $("body").css({overflow:"hidden"});
    var attributeC=$(obj).attr("class");
    $(".mask-"+attributeC).show();
    /*
     if(window.screen.availHeight > $(document.body).outerHeight(true)){
     //当屏幕可用工作区域的高度 > 浏览器当前窗口文档body的总高度 包括border padding margin时( 缩放时 )
     $(".mask").show().css({"opacity":"0.5","width":"100%","height":window.screen.availHeight});
     }else{
     $(".mask").show().css({"opacity":"0.5","width":"100%","height":$(document.body).outerHeight(true)});
     }
     */
};

function closed(obj) {
    $(obj).parent().fadeOut();
    $(".mask").fadeOut();
    $("body").css({overflow:"scroll"});
};

var edit=function(obj){
	$(".mask").show().css({"opacity":"0.9","width":"100%","height":document.documentElement.scrollHeight+document.body.scrollHeight});
    $("body").css({overflow:"hidden"});
//    var attributeC=$(obj).attr("class");
    $(".mask-edit").show();
}
