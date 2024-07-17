<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>医院首页</title>
    <link href="css/cubeportfolio.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <link href="static/css/IE8.css" rel="stylesheet">
    <![endif]-->
</head>

<body>
<!--头部-->
<header>
    <!--页眉-->
    <div class="header">
        <div class="container">
            <p class="p14 col-md-6 col-xs-6 text-left">ustb医院</p>
            <P class="p14 col-md-6 col-xs-6 text-right">
                <span class="glyphicon glyphicon-earphone">

                </span>&nbsp;&nbsp;&nbsp;医疗咨询：0512-6500-1280</P>
        </div>
    </div>

    <!--导航-->
    <nav class="nav_top">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle collapsed mean" data-toggle="collapse" data-target="#mynavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo"><img src="images/logo.png"></a>
            </div>
            <div id="mynavbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav nav_li navbar-right">
                    <li>
                        <a href="/annclist2">首页</a>
                    </li>
                    <li>
                        <a href="about.html">关于我们</a>
                    </li>
                    <li>
                        <a href="product.html">医疗设施</a>
                    </li>
                    <li>
                        <a href="service.html">医疗服务</a>
                    </li>

                    <li>
                        <a href="news.html">联系我们</a>
                    </li>
                    <li>
                        <a href="/login.jsp">登录</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<!--幻灯片-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner silder-top" role="listbox">
        <div class="item active">
            <img src="images/banner1.png">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="images/banner2.png">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="images/banner3.png">
            <div class="carousel-caption">
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!--我们理念-->
<div class="idea">
    <div class="container">
        <div class="col-md-10">
            <p>希望能为您的健康提供帮助。</p>
            <span class="p14">Hope it helps your health.</span>
        </div>
        <a class="col-md-2" href="contact.html">立即咨询</a>
    </div>
</div>

<!--关于我们-->
<div class="about">
    <div class="container">
        <div class="title">
            <img src="images/h_1.png" class="title_img">
            <div class="title_top">
                <h2>关于我们</h2>
                <span>About Us</span>
            </div>
            <img src="images/h_2.png" class="title_img">
        </div>
        <div class="ab">
            <img src="images/ab.png" class="col-md-6 img-circle">
            <div class="col-md-6">
                <p class="p14">
                    作为北京大学第三临床医学院，北医三院始终坚持“立德树人”的根本宗旨，不断完善临床教学培训体系。2021年，成立北医三院教育教学中心，不断深化医学教育教学改革。重视本科生教育，相关课程入选北京高校优质本科课程。教学成果曾荣获2022 年高等教育（本科）国家级教学成果奖一等奖。医院每年承担700余名本科生、700余名研究生、近300名规范化培训的住院医师、1800余名进修医师/护师的教学和培训管理工作。承担以八年制临床医学专业为主的多学科本科医学教育管理工作，负责全院32个博士学位培养点，34个硕士学位培养点。北医三院有北京市住院医师规范化培训专业基地20个，国家住院医师规范化培训重点专业基地3个，国家卫生健康委员会专科医师规范化培训基地3个。每年接受各类继续教育学员总计近2000人。

                </p>
                <a href="about.html">了解更多</a>
            </div>
        </div>
    </div>
</div>
<!--我们服务-->
<div class="service">
    <div class="container">
        <div class="row">
            <div class="title">
                <img src="images/h_1.png" class="title_img">
                <div class="title_top">
                    <h2>医疗服务</h2>
                    <span>Medical Service</span>
                </div>
                <img src="images/h_2.png" class="title_img">
            </div>
            <img src="images/service.png" class="service_img1">
            <div class="service_top">
                <img src="images/service.png" class="service_img">
<%--                <div class="service_top1">--%>
<%--                    <h4>宠物医疗</h4>--%>
<%--                    <p class="p14">宠物的医疗保养也越来越受到大家的关注</p>--%>
<%--                </div>--%>
<%--                <div class="service_top2">--%>
<%--                    <h4>宠物饮食</h4>--%>
<%--                    <p class="p14">宠物的饮食和营养也越来越受到大家的关注</p>--%>
<%--                </div>--%>
<%--                <div class="service_top3">--%>
<%--                    <h4>宠物寄养</h4>--%>
<%--                    <p class="p14">因为宠物的种类多，各自的生活习性不同，对营养的需求也不尽相同</p>--%>
<%--                </div>--%>
<%--                <div class="service_top4">--%>
<%--                    <h4>宠物美容</h4>--%>
<%--                    <p class="p14">所谓的宠物美容就是借助美容用品和修剪技法和染色激发增添美感</p>--%>
<%--                </div>--%>
<%--                <div class="service_top5">--%>
<%--                    <h4>宠物护理</h4>--%>
<%--                    <p class="p14">让宠物的外观得到美化和环保变得更健康和时尚</p>--%>
<%--                </div>--%>
<%--                <div class="service_top6">--%>
<%--                    <h4>宠物训练</h4>--%>
<%--                    <p class="p14">让它觉得这段时间充满了乐趣，从而增强宠物与主人的感情</p>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</div>
<!--成功案例-->
<diV class="case">
    <div class="container">
        <div class="row">
            <div class="title">
                <img src="images/h_1.png" class="title_img">
                <div class="title_top">
                    <h2>医疗设施</h2>
                    <span>Medical Equipment</span>
                </div>
                <img src="images/h_2.png" class="title_img">
            </div>
            <div class="news-liebiao clearfix">
                <div id="js-grid-masonry" class="cbp">
                    <div class="cbp-item wuxianchanpin">
                        <a href="images/bc.jpg" class="cbp-caption cbp-lightbox">
                            <div class="cbp-caption-defaultWrap">
                                <img src="images/bc.jpg" alt="">
                            </div>
                            <div class="cbp-caption-activeWrap">
                                <div class="cbp-l-caption-alignCenter">
                                    <div class="cbp-l-caption-body">
                                        <div class="cbp-l-caption-title">B超检查</div>
                                        <div class="cbp-l-caption-desc">Classic black</div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="cbp-item MINATO">
                        <a href="images/xg.jpg" class="cbp-caption cbp-lightbox">
                            <div class="cbp-caption-defaultWrap">
                                <img src="images/xg.jpg" alt="">
                            </div>
                            <div class="cbp-caption-activeWrap">
                                <div class="cbp-l-caption-alignCenter">
                                    <div class="cbp-l-caption-body">
                                        <div class="cbp-l-caption-title">X光检查</div>
                                        <div class="cbp-l-caption-desc">X-rays</div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="cbp-item MINATO">
                        <a href="images/hc.jpg" class="cbp-caption cbp-lightbox">
                            <div class="cbp-caption-defaultWrap">
                                <img src="images/hc.jpg" alt="">
                            </div>
                            <div class="cbp-caption-activeWrap">
                                <div class="cbp-l-caption-alignCenter">
                                    <div class="cbp-l-caption-body">
                                        <div class="cbp-l-caption-title">核磁共振</div>
                                        <div class="cbp-l-caption-desc">nuclear magnetic resonance</div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="cbp-item MINATO">
                        <a href="images/hy.jpg" class="cbp-caption cbp-lightbox">
                            <div class="cbp-caption-defaultWrap">
                                <img src="images/hy.jpg" alt="">
                            </div>
                            <div class="cbp-caption-activeWrap">
                                <div class="cbp-l-caption-alignCenter">
                                    <div class="cbp-l-caption-body">
                                        <div class="cbp-l-caption-title">化验</div>
                                        <div class="cbp-l-caption-desc">chemical examination</div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
<%--                    <div class="cbp-item MINATO">--%>
<%--                        <a href="images/pc7.jpg" class="cbp-caption cbp-lightbox">--%>
<%--                            <div class="cbp-caption-defaultWrap">--%>
<%--                                <img src="images/pc7.jpg" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="cbp-caption-activeWrap">--%>
<%--                                <div class="cbp-l-caption-alignCenter">--%>
<%--                                    <div class="cbp-l-caption-body">--%>
<%--                                        <div class="cbp-l-caption-title">美容</div>--%>
<%--                                        <div class="cbp-l-caption-desc">爱美是人的天性，给宠物一个美丽的容貌。</div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                    <div class="cbp-item ELNEC">--%>
<%--                        <a href="images/pc5.jpg" class="cbp-caption cbp-lightbox">--%>
<%--                            <div class="cbp-caption-defaultWrap">--%>
<%--                                <img src="images/pc5.jpg" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="cbp-caption-activeWrap">--%>
<%--                                <div class="cbp-l-caption-alignCenter">--%>
<%--                                    <div class="cbp-l-caption-body">--%>
<%--                                        <div class="cbp-l-caption-title">化验检查</div>--%>
<%--                                        <div class="cbp-l-caption-desc">抽血检验，粪便检查，精细到每一个环节。</div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                    <div class="cbp-item eMMC">--%>
<%--                        <a href="images/pc1.jpg" class="cbp-caption cbp-lightbox">--%>
<%--                            <div class="cbp-caption-defaultWrap">--%>
<%--                                <img src="images/pc1.jpg" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="cbp-caption-activeWrap">--%>
<%--                                <div class="cbp-l-caption-alignCenter">--%>
<%--                                    <div class="cbp-l-caption-body">--%>
<%--                                        <div class="cbp-l-caption-title">手术台</div>--%>
<%--                                        <div class="cbp-l-caption-desc">独立封闭的手术室，无菌环境。</div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                    <div class="cbp-item Dediprog">--%>
<%--                        <a href="images/pc3.jpg" class="cbp-caption cbp-lightbox">--%>
<%--                            <div class="cbp-caption-defaultWrap">--%>
<%--                                <img src="images/pc3.jpg" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="cbp-caption-activeWrap">--%>
<%--                                <div class="cbp-l-caption-alignCenter">--%>
<%--                                    <div class="cbp-l-caption-body">--%>
<%--                                        <div class="cbp-l-caption-title">x光拍摄</div>--%>
<%--                                        <div class="cbp-l-caption-desc">全方位的拍摄检查，渗透到每一个部位。</div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </div>--%>
                </div>

            </div>
        </div>
    </div>
    <!--<div class="container">
        <div class="row">
            <div class="title">
                <img src="images/h_1.png" class="title_img">
                <div class="title_top">
                    <h2>医疗设备</h2>
                    <span>Medical Equipment</span>
                </div>
                <img src="images/h_2.png" class="title_img">
            </div>
            <ul class="col-md-12 case_top">
                <li class="col-md-3">

                         <img src="images/p1.jpg">

                    <div>
                        <p class="p14">犬肝硬化B超犬肝硬化B超犬肝硬化B超犬肝硬化B超犬肝硬化B超犬肝硬化B超</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p2.jpg">
                    <div>
                        <p class="p14">各种骨折治疗各种骨折治疗各种骨折折治疗各种骨折治疗各种骨折治疗</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p3.jpg">
                    <div>
                        <p class="p14">绝育并不可怕绝育并不可怕绝育并不可怕绝育并不可怕绝育并不可怕绝育并不可怕</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p4.jpg">
                    <div>
                        <p class="p14">膀胱结石B超图片膀胱结石B超图片片膀胱结石B超图片膀胱结石B超图片</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p5.jpg">
                    <div>
                        <p class="p14">肠道异物手术肠道异物手术肠道异物手术肠道异物手术肠道异物手术肠道异物手术</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p6.jpg">
                    <div>
                        <p class="p14">犬子宫蓄脓犬子宫蓄脓犬子宫蓄脓犬子宫子宫蓄脓犬子宫蓄脓犬子宫蓄脓犬子宫蓄脓</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p7.jpg">
                    <div>
                        <p class="p14">比熊犬胃内异物比熊犬胃内异物比熊犬胃内异物比熊犬胃异物</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
                <li class="col-md-3">
                    <img src="images/p8.jpg">
                    <div>
                        <p class="p14">结石X光片结石X光片结石X光片结石X光片结石X光片结石X光片</p>
                        <a href="product.html">查看更多</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>-->
</diV>
<!--萌宠医疗-->
<div>
    <div class="container-fluid">
        <div class="row">

            <div class="doctor_top">
                <img src="images/d1.png">
                <h3>— 医疗技术实力雄厚 —</h3>
                <p>拥有一批高学历、临床经验丰富的宠物医师，其中硕士35人、博士2人，执业兽医师328人。</p>
                <p>有完善的宠物内科、心血管科、骨科、软组织外科、眼科、</p>
                <p>肿瘤科、牙科、皮肤科、影像科、猫科等科室，并在宠物骨科、眼科、肿瘤科、牙科、皮肤科等领域综合实力领跑全国。</p>
            </div>
        </div>
    </div>
</div>

<diV class="news">
    <div class="container">
        <div class="title">
            <img src="images/h_1.png" class="title_img">
            <div class="title_top">
                <h2>新闻公告</h2>
                <span>Pet Encyclopedia</span>
            </div>
            <img src="images/h_2.png" class="title_img">
        </div>
        <div class="row">
            <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                <div id="news_slide" class="news_slide_box">
                    <div class="bd">
                        <ul>
                            <li>
                                <a class="pic" href="news_show33.html">
                                    <img src="images/news1.png" />
                                    <span class="title">
												乔杰荣获联合国教科文组织-赤道几内亚国际生命科学研究奖
											</span>
                                </a>
                            </li>
                            <li>
                                <a class="pic" href="news_show11.html">
                                    <img src="images/news2.png" />
                                    <span class="title">
												ustb医院乔杰院士团队项目获国家自然科学奖
											</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <span class="prev"></span>
                    <span class="next"></span>
                </div>
            </div>
            <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
                <ul class="news_list">
                    <li>
                        <div class="news_pic col-lg-3 col-md-3 col-sm-4 col-xs-12">
                            <a href="annc/annc1.jsp">
                                <img src="images/xb.png" />
                            </a>
                        </div>
                        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
                            <a href="annc/annc1.jsp" class="news_tit">${list.get(0).title}</a>
                            <p class="news_time">${list.get(0).creationTime}</p>
                            <p class="news_desc"> </p>
                        </div>
                    </li>
                    <li>
                        <div class="news_pic col-lg-3 col-md-3 col-sm-4 col-xs-12">
                            <a href="annc/annc2.jsp">
                                <img src="images/xb.png" />
                            </a>
                        </div>
                        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
                            <a href="annc/annc2.jsp" class="news_tit">${list.get(1).title}</a>
                            <p class="news_time">${list.get(1).creationTime}</p>
                            <p class="news_desc"> </p>
                        </div>
                    </li>
                    <li>
                        <div class="news_pic col-lg-3 col-md-3 col-sm-4 col-xs-12">
                            <a href="annc/annc3.jsp">
                                <img src="images/xb.png" />
                            </a>
                        </div>
                        <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
                            <a href="annc/annc3.jsp" class="news_tit">${list.get(2).title}</a>
                            <p class="news_time">${list.get(2).creationTime}</p>
                            <p class="news_desc"> </p>
                        </div>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</diV>
<!--团队风采-->
<diV class="team">
    <div class="container">
        <div class="title">
            <img src="images/h_1.png" class="title_img">
            <div class="title_top">
                <h2>医疗团队</h2>
                <span>

Medical Team</span>
            </div>
            <img src="images/h_2.png" class="title_img">
        </div>
        <section class="team-box">
            <div id="owl-demo2" class="owl-carousel team-list wow fadeInUp">
                <div class="item">
                    <a href="about.html">
                        <img src="images/mbg.jpg" />
                        <p class="name-t">马保国</p>
                        <div class="team-abs">
                            <h3>眼科</h3>
                            <p>眼科专家</p>
                        </div>
                    </a>
                </div>
                <div class="item">
                    <a href="about.html">
                        <img src="images/lb.png" />
                        <p class="name-t">李白</p>
                        <div class="team-abs">
                            <h3>普外科</h3>
                            <p>普外科专家</p>
                        </div>
                    </a>
                </div>
                <div class="item">
                    <a href="about.html">
                        <img src="images/lbw.jpg" />
                        <p class="name-t">卢本伟</p>
                        <div class="team-abs">
                            <h3>皮肤科</h3>
                            <p>皮肤专家</p>
                        </div>
                    </a>
                </div>
                <div class="item">
                    <a href="about.html">
                        <img src="images/ht.png" />
                        <p class="name-t">华佗</p>
                        <div class="team-abs">
                            <h3>骨科</h3>
                            <p>骨科专家</p>
                        </div>
                    </a>
                </div>

                <div class="item">
                    <a href="about.html">
                        <img src="images/jg.jpg" />
                        <p class="name-t">朗朗</p>
                        <div class="team-abs">
                            <h3>肿瘤科</h3>
                            <p>肿瘤科专家</p>
                        </div>
                    </a>
                </div>
            </div>
        </section>

    </div>
</div>
<!--联系我们-->
<footer class="footer">
    <div class="container">
        <div class="b-nav wow fadeInUp" data-wow-delay=".1s">
            <a href="/annclist2">首 页</a>
            <a href="about.html">关于我们</a>
            <a href="product.html">医疗设施</a>
            <a href="service.html">医疗服务</a>
            <a href="news.html">联系我们</a>
            <a href="/login">登录</a>
        </div>
        <p class="wow fadeInUp jshu" data-wow-delay=".3s">Copyright © 2017-2027 宠物医院 | 魔米宠物医院</p>
        <p class="wow fadeInUp jshu" data-wow-delay=".5s">技术支持：&nbsp;&nbsp;&nbsp;
            <a href="http://www.5kym.com/" target="_blank">网页模板</a>
        </p>
    </div>
</footer>
<!--回到顶部-->
<a class="top"><span class="glyphicon glyphicon-menu-up jiantou"></span></a>
<script src="js/jquery-3.7.1.min.js"></script>
<script src="js/main.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/TouchSlide.1.1.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/jquery.cubeportfolio.min.js"></script>
<script src="js/portfolio-masonry-4col.js"></script>
<script>
    TouchSlide({
        slideCell: "#slideBox",
        titCell: ".hd li",
        mainCell: ".bd ul",
        effect: "leftLoop"
        //				autoPlay:true//自动播放
    });
    TouchSlide({
        slideCell: "#news_slide",
        mainCell: ".bd ul",
        effect: "leftLoop",
        autoPlay: true //自动播放
    });
</script>
</body>


</html>