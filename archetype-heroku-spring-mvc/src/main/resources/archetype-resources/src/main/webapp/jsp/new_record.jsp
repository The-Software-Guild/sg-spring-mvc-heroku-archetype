<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Record ~ New</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="snippets/header.jsp" %>
            
            <div class="col-xs-12">
                <c:if test="${param.error != null}"><h5 class='text-danger'>Something has gone wrong. Try again?</h5></c:if>
                <%@include file="forms/new_record.jsp" %>
            </div>
        </div>

    </body>
</html>

