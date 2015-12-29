<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="Samsara Pistachio, a complete book management system">
    <meta name="author" content="sczyh30">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Samsara Pistachio 图书管理系统 - 总中心</title>
    <link rel="stylesheet" href="http://127.0.0.1:8080/Pistachio/ares/css/login-style.css"/>
</head>
<body>
<section class="container">
    <div class="login">
        <h1>图书管理系统 后台登录</h1>
        <form method="post" action="">
            <p><input type="text" name="username" value="" placeholder="管理员用户名"></p>
            <p><input type="password" name="password" value="" placeholder="密码"></p>
            <div class="center-mg10">
                <input class="buttonB" type="submit" name="commit" value="登录">
                <input class="buttonB" type="reset" name="reset" value="重置">
            </div>
        </form>
    </div>

    <div class="login-help">
        <p>忘记密码? 打电话给管理员！</p>
    </div>
</section>
</body>
</html>
