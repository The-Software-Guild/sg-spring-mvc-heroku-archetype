<div class="navbar">
    <ul class="nav nav-tabs">
        <li role="presentation" <c:if test="${active eq 'index'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li role="presentation" <c:if test="${active eq 'addform'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/addForm">Add Record</a></li>
    </ul>
</div>