<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>

    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>

    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
    <link rel="stylesheet" href="/js/vendor/jgrowl/css/jquery.jgrowl.min.css">
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/css/component.css" />
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <style>
        input::-webkit-input-placeholder{
            color:rgba(0, 0, 0, 0.726);
        }
        input::-moz-placeholder{   /* Mozilla Firefox 19+ */
            color:rgba(0, 0, 0, 0.726);
        }
        input:-moz-placeholder{    /* Mozilla Firefox 4 to 18 */
            color:rgba(0, 0, 0, 0.726);
        }
        input:-ms-input-placeholder{  /* Internet Explorer 10-11 */
            color:rgba(0, 0, 0, 0.726);
        }
    </style>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>SUNNYTECH</h3>
                <form action="/login.page" name="f" method="post">
                    <div class="checkbox" style="color: red;">${errorMsg}</div>
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input id="username" name="username" class="text" style="color: #000000 !important" type="text" placeholder="工号/邮箱/手机号" value="${username}">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input id="password" name="password" class="text" style="color: #000000 !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                    </div>
                    <div id="LOGIN" class="mb2">
                        <input type="submit" class="act-but submit" value="登录" style="color: #FFFFFF;width: 330px;"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="/js/TweenLite.min.js"></script>
<script src="/js/EasePack.min.js"></script>
<script src="/js/jquery.js"></script>
<script src="/js/rAF.js"></script>
<script src="/js/demo-1.js"></script>
<script src="/js/vendor/jgrowl/jquery.jgrowl.min.js"></script>

<div style="text-align:center;">
</div>
<script type="text/javascript">
    $(function(){
        $("#username").focusout(function(){
            if($.trim($(this).val()) == ""){
                $(".checkbox").text("用户名不能为空");
            }else{
                $(".checkbox").text("");
            }
        })
        $("#password").focusin(function(){
                $(".checkbox").text("");
        })
    })
</script>
</body>
</html>
