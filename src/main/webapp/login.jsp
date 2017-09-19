<%@ page import="java.nio.file.Path"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh" class="no-js">

<head>

<meta charset="utf-8">
<title>后台登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body oncontextmenu="return false">

	<div class="page-container">
		<input type="hidden" id="error" value="${error}" />
		<h1>Login</h1>
		<form action="${pageContext.request.contextPath }/loginAdmin"
			method="post">
			<div>
				<input type="text" name="userName" class="username"
					placeholder="Username" autocomplete="off" />
			</div>
			<div>
				<input type="password" name="password" class="password"
					placeholder="Password" oncontextmenu="return false"
					onpaste="return false" />
			</div>
			<button id="submit" type="submit">Sign in</button>
		</form>

		<div class="connect">
			<p>You never know what you can do till you try.</p>
			<p style="margin-top: 20px;">除非你亲自尝试一下,否则你永远不知道你能做什么。</p>
		</div>
	</div>

	<!-- Javascript -->
	<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js"
		type="text/javascript"></script>
	<script>
		var u = $("input[name=username]");
		var p = $("input[name=password]");
		$("#submit").live('click', function() {
			if (u.val() == '' || p.val() == '') {
				alert("用户名或密码不能为空~");
				return false;
			} else {
				var reg = /^[0-9A-Za-z]+$/;
				if (!reg.exec(u.val())) {
					alert("用户名错误");
					return false;
				}
			}
		});
		window.onload = function() {
			var error = $("#error").val();
			if (error != "") {
				alert("用户名或密码错误！");
			}
		}
	</script>
</body>

</html>