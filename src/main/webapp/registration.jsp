<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<jsp:include page="${pageContext.request.contextPath}/header.jsp"/>

    <section class="dashboard-section">
        <div class="container pt-4 pb-4">
            <div class="border-dashed view-height">
                <div class="container w-25">
                    <!-- fix action, method -->
                    <!-- add name attribute for all inputs -->
                    <form class="padding-small text-center" action="/register" method="post">
                        <h1 class="text-color-darker">Rejestracja</h1>
                        <div class="form-group">
                            <input type="text" class="form-control" id="name" name="name" placeholder="podaj imię">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="surname" name="surname" placeholder="podaj nazwisko">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="email" name="email" placeholder="podaj email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="repassword" name="repassword" placeholder="powtórz hasło">
                        </div>
                        <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                    </form>
                 </div>
            </div>
        </div>
    </section>


<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>