<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
    </div>
    <ul class="nav navbar-top-links navbar-right">

<!--내부통지-->
        <li class="dropdown">
            <a id="ins" class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                    <i class="fa fa-envelope"></i>  <span class="label label-warning isnVal"></span>
            </a>
            <ul id="insNotRead" class="dropdown-menu dropdown-messages">

            </ul>
        </li>

<!--공지알람-->
        <li class="dropdown">
            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="mailbox.html" class="dropdown-item">
                        <div>
                            <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                            <span class="float-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="dropdown-divider"></li>
                <li>
                    <a href="profile.html" class="dropdown-item">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                            <span class="float-right text-muted small">12 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="dropdown-divider"></li>
                <li>
                    <a href="grid_options.html" class="dropdown-item">
                        <div>
                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                            <span class="float-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
            </ul>
        </li>

        <li>
            <a href="login.html">
                <i class="fa fa-sign-out"></i> 로그아웃
            </a>
        </li>
    </ul>
</nav>
