<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>picture details</title>
<link rel="Shortcut Icon"
	href="${pageContext.request.contextPath}/picture/ico/ts2.png">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/user_info.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/latest.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/picture_drtails.css">
</head>

<body>
	<!-- ------------------------------------------网页顶部开始------------------------------------------ -->
	<div id="periphery-top">
		<div class="ts-top">
			<a href="${pageContext.request.contextPath}/index.jsp" id="logo">TSwallpape</a>
			<!-- 搜索框 -->
			<div class="search-box">
				<form action="" method="post">
					<input name="search-value" type="text" class="form-control"
						value="" placeholder="Search..." />
					<button class="search-icon">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
			</div>
			<div id="userpanel">
				<c:choose>
					<c:when test="${not empty sessionScope.user}">
						<span class="welcome-text">welcome back</span>
						&nbsp;
						<!-- 用户名 -->
						<div class="btn-group">
							<button data-toggle="dropdown"
								class="btn btn-primary dropdown-toggle" type="button">${sessionScope.user.u_name}
								<span class="caret"></span>
							</button>
							<ul role="menu" class="dropdown-menu username">
								<li>用户菜单</li>
								<li class="divider"></li>
								<li>
									<div class="user-info">
										<div class="user-info-left">
											<!-- 用户头像 -->
											<div class="user-portrait-box">
												<c:choose>
													<c:when test="${not empty sessionScope.user.u_photo}">
														<a
															href="${pageContext.request.contextPath}/pages/users_info.jsp">
															<img class="user-portrait"
															src="${pageContext.request.contextPath}/${sessionScope.user.u_photo}">
														</a>
													</c:when>
													<c:otherwise>
														<a
															href="${pageContext.request.contextPath}/pages/users_info.jsp">
															<img class="user-portrait-default"
															src="${pageContext.request.contextPath}/picture/headPortrait/default/user.jpg">
														</a>
													</c:otherwise>
												</c:choose>
											</div>

											<!-- 用户名称 -->
											<div class="user-name-box">
												<a
													href="${pageContext.request.contextPath}/pages/users_info.jsp">${sessionScope.user.u_name}</a>
											</div>
										</div>

										<div class="user-info-right">
											<div class="guanzhu">
												<a href="#"> <span>${sessionScope.user.u_attention}</span>
													<span>关注</span>
												</a>
											</div>

											<div class="fensi">
												<a href="#"> <span>${sessionScope.user.u_fans}</span> <span>粉丝</span>
												</a>
											</div>

											<div class="uploads">
												<a href="#"> <span class="glyphicon glyphicon-upload"></span>
													&nbsp; <span>${sessionScope.user.u_upload}</span>
												</a>
											</div>

											<div class="favorites">
												<a href="#"> <span class="glyphicon glyphicon-star"></span>
													&nbsp; <span>${sessionScope.user.u_collect}</span>
												</a>
											</div>

										</div>

									</div>
								</li>
								<li class="divider"></li>

								<li>
									<div class="user-setting">
										<div class="setting-icon-box">
											<span class="glyphicon glyphicon-cog"></span>
										</div>
										<div>
											<a href="#">修改个人信息</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp; <a
												href="#">修改密码</a>
										</div>
									</div>
								</li>

								<li class="divider"></li>

								<li>
									<div class="user-message">
										<div class="setting-message-box">
											<span class="glyphicon glyphicon-envelope"></span>
										</div>

										<div>
											<a href="#">新消息：0</a>
										</div>
									</div>

								</li>
								<li class="divider"></li>
								<li><a
									href="${pageContext.request.contextPath}/usersAction/logout">
										<span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;安全退出
								</a></li>
							</ul>
						</div>
					</c:when>

					<c:otherwise>
						<!-- 按钮 -->
						<button type="button" class="btn btn-success btn-sm btm-me"
							data-toggle="modal" data-target="#myModal">登录</button>

						<!-- 对话框开始 -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">

								<div class="modal-content">

									<!-- 1.对话框标题 -->
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">用户登录</h4>
									</div>

									<!-- 2.对话框内容开始 -->
									<div class="modal-body">

										<form id="myform"
											action="${pageContext.request.contextPath}/usersAction/login"
											method="post">
											<div class="login-form login-form-me">

												<div class="form-group">
													<input name="u_name" type="text"
														class="form-control login-field" value="taylor"
														placeholder="用户名" id="login-name" /> <label
														class="login-field-icon fui-user" for="login-name"></label>
												</div>

												<div class="form-group">
													<input name="u_pass" type="password"
														class="form-control login-field" value="123"
														placeholder="密码" id="login-pass" /> <label
														class="login-field-icon fui-lock" for="login-pass"></label>
												</div>

												<a class="btn btn-primary btn-lg btn-block"
													href="javascript:validate()">登录</a>
												<div class="login-bottom">
													<a class="login-link" href="#">忘记密码?</a>
													&nbsp;&nbsp;&nbsp;&nbsp; <a class="login-link"
														href="${pageContext.request.contextPath}/pages/users_register.jsp">注册</a>
												</div>
											</div>
										</form>

									</div>
									<!-- 2.对话框内容结束  -->

								</div>

							</div>
						</div>
						<!-- 对话框结束 -->

					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<!-- ------------------------------------------网页顶部 结束------------------------------------------ -->
	
	<div id="main-body-content">
		<div id="picture-region">
			<div class="picture-box">
				<img id="picture-details" class="picture-details" alt="" src=""  rel="">
			</div>
		</div>
		
		<div class="picture-info">
			<div class="picture-title">图片信息</div>
			<!-- <div class="pictire-name">
				名称：<span class="pname"></span>
			</div>
			<div class="ticture-uploaddate">
				上传日期：<span class="pdatetime"></span>
			</div> -->
			
			<table>
				<tr>
					<td>名称</td>
					<td><span class="pname"></span></td>
				</tr>
				<tr>
					<td>上传日期</td>
					<td>
						<span class="pdatetime"></span>
					</td>
				</tr>
				<tr>
					<td>类型</td>
					<td>
						<span class="typename"></span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
			</table>
			
		</div>
		
		<div style="width: 1200px;height: 300px;background:rgba(55,55,55,.8);float: left;">
			
		</div>
		
	</div>
<script type="text/javascript">
//获取地址栏参数
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]); return null;
}
$(document).ready(function(){
	var parameter = "${pageContext.request.contextPath}/" + getQueryString("par");
	$(".picture-details").attr("src", parameter);
	$(".picture-details").attr("rel", parameter);
	$(".pname").html(getQueryString("name"));
	$(".pdatetime").html(getQueryString("datemime"));
	$(".typename").html(getQueryString("typename"),"UTF-8");
	
});
$(function() {
    $('.picture-box').imageView({width: 950, height:605});
});


</script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<!-- Including imageView jQuery plugin -->
<script src="${pageContext.request.contextPath}/js/jquery.imageView.js"></script>
</body>
</html>










