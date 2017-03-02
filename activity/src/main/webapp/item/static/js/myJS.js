function share(url){
    var u = navigator.userAgent;
    var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
    var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
    if(isAndroid==true){
        javascript:banana.shareURL(url);
    }else if(isiOS==true){
        if(url.startsWith("http://")){
            url=url.replace("http://","");
        } if(url.startsWith("https://")){
            url=url.replace("https://","");
        }
        //alert(url);
        location.href = 'ios://'+url;
    }

}

function openApp(actId) {
    var the_href="http://700sport.com/302server/api/doRedirect.shtml";//获得下载链接
    window.location="bananapunch://invitation?entrance=challenge&challengeId="+actId;//打开某手机上的某个app应用
    setTimeout(function(){
        window.location=the_href;//如果超时就跳转到app下载页
    },500);


    //document.body.addEventListener('touchmove', touchmoveEvent, true);
    //if (/MicroMessenger|QQ\/|WeiBo/i.test(navigator.userAgent)) {
    //    document.getElementsByClassName("box1")[0].style.top = document.body.scrollTop + "px";
    //    document.getElementsByClassName("box")[0].style.display = "block";
    //    return;
    //}
    //var commonContent = "已经为你打开香蕉打卡, 若无反应请下载最新APP";
    //
    //document.getElementById("confirmContext").innerHTML = commonContent;
    //
    //document.getElementsByClassName("box")[1].style.display = "block";
    //window.location.href="bananapunch://invitation?entrance=challenge&challengeId="+actId;//打开某手机上的某个app应用

}