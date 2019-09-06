<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>

<blockquote class="layui-elem-quote layui-text">
    登录
</blockquote>
<form action="login" method="post" class="layui-form">

    <div class="layui-form-item">
        <label class="layui-form-label">用户名：</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码 ：</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="../layui/layui.js"></script>
<script>

    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
            , form = layui.form;
        var $ = layui.$;

        form.verify({
            username: function (value) {
                if (!value || value.length == 0) {
                    return '请输入用户名';
                }
            },
            password: function (value) {
                if (!value || value.length == 0) {
                    return '请输入密码';
                }
            }
        });

        //监听提交
        form.on('submit(login)', function (data) {
            console.log(JSON.stringify(data.field));
            form.submit();
        })
</script>
</body>
</html>
