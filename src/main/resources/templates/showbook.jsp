<%--
  Created by IntelliJ IDEA.
  User: TongXin
  Date: 2020/5/14
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<link rel="shortcut icon" href="../resources/favicon.ico" th:href="@{/static/favicon.ico}"/>


<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>Bootstrap</title>
    <!-- Bootstrap -->
    <link th:href="@{/static/bootstrap.min.css}" rel="stylesheet">
    <style type="text/css">
        a{
            text-decoration: none;
        }
        a:hover{
            text-decoration: none;
        }
        a:focus{
            text-decoration: none;
        }
    </style>


</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-4" style="text-align: center;height: 80px;background-color: #6f42c1;" >

            <img src="../static/js/logo.png" height="70%"/></div>
        <div class="col-lg-8" style="text-align: left;height: 80px;background-color: #6f42c1;font-size:40px;font-family: 幼圆">

            <a href="" style="text-decoration: none;color: white;display: block">欢迎来到松鼠图书馆！</a>

        </div>
    </div>
    <div class="row">
        <div class="col-lg-2" style="height: 900px;background-color: #b3d7ff">
            <div class="text-center" style="height: 50px;line-height: 50px">
                <a href="" style="text-decoration: none;color: white;display: block">图书管理系统</a>
            </div>
            <div style="height: 1px;background-color: black;width: 100%"></div>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h5 class="panel-title text-center" >
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                图书管理
                            </a>
                        </h5>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse.in" role="tabpanel" aria-labelledby="headingOne">
                        <ul class="list-group text-center">
                            <a class="list-group-item" href="http://localhost:8080/book/findBook">
                                <i class="icon-double-angle-right">图书借阅</i>
                            </a>
                            <a class="list-group-item" href="http://localhost:8080/book/findBookById00">图书归还</a>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h5 class="panel-title text-center">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                个人信息管理
                            </a>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <ul class="list-group text-center">
                            <a class="list-group-item" href="http://localhost:8080/book/findBookById01">查询借阅信息</a>
                            <a class="list-group-item" href="http://localhost:8080/modifyreader.html">修改个人信息</a>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading panel" role="tab" id="headingFour">
                        <h5 class="panel-title text-center">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                返回首页
                            </a>
                        </h5>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                        <ul class="list-group text-center">
                            <a class="list-group-item" href="http://localhost:8080/okLogin">返回首页</a>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading panel" role="tab" id="headingThree">
                        <h5 class="panel-title text-center">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                退出登录
                            </a>
                        </h5>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                        <ul class="list-group text-center">
                            <a class="list-group-item" href="http://localhost:8080/loginIn">退出登录</a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-10" style="height: 900px;background-color: #6495ED">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    图书类别
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu " aria-labelledby="dropdownMenu1">
                    <li><a href="http://localhost:8080/book/findBook">全部</a></li>
                    <li><a href="http://localhost:8080/book/findZhengFa">政治、法律</a></li>
                    <li><a href="http://localhost:8080/book/findHistory">历史、地理</a></li>
                    <li><a href="http://localhost:8080/book/findScience">自然科学</a></li>
                    <li><a href="http://localhost:8080/book/findEconomy">经济</a></li>
                    <li><a href="http://localhost:8080/book/findArmy">军事</a></li>
                    <li><a href="http://localhost:8080/book/findWenxue">文学</a></li>
                    <li><a href="http://localhost:8080/book/findArt">艺术</a></li>
                </ul>
            </div>
            <table class="table table-striped table-dark table-hover" >


                <thead >
                <tr>
                    <th scope="col">书号</th>
                    <th scope="col">书名</th>
                    <th scope="col">出版社</th>
                    <th scope="col">价格</th>
                    <th scope="col">类别</th>
                    <th scope="col">图书状态</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <c:forEach items=" ${pb.list}" var="books" varStatus="s">
                    <td>${books.bookid}</td>
                    <td>${books.bookname}</td>
                    <td>${books.publisher}</td>
                    <td>${books.price}</td>
                    <td>${books.kind}</td>




                </tr>
            </table>
        </div>
    </div>

</div>


<script src="https://cdn.bootcss.com/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->

<script th:src="@{/js/jquery-3.2.1.js}"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script th:src="@{/static/bootstrap.min.js}"></script>
</body>
</html>
