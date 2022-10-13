<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="${pageContext.request.contextPath}/header.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


<div class="m-4 p-4 width-medium">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj plan</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis do planu</span>
                </a>
            </div>
        </div>

        <div class="dashboard-alerts">
            <div class="alert-item alert-info">
                <i class="fas icon-circle fa-info-circle"></i>
                <span class="font-weight-bold">Liczba przepisów:
                             <c:if test="${not empty recipeQuantity}">
                                 ${recipeQuantity}
                             </c:if>
                            </span>
            </div>
            <div class="alert-item alert-light">
                <i class="far icon-calendar fa-calendar-alt"></i>
                <span class="font-weight-bold">Liczba planów:
                            <c:if test="${not empty plansQuantity}">
                                ${plansQuantity}
                            </c:if>
                            </span>
            </div>
        </div>
    </div>
    <div class="m-4 p-4 border-dashed">
        <h2 class="dashboard-content-title">
            <span>Ostatnio dodany plan:</span>
            <c:if test="${not empty planName}">
                ${planName}
            </c:if>
        </h2>

        <table class="table">
            <thead>
            <tr class="d-flex">
                <th class="col-2">Poniedziałek</th>
                <th class="col-8"></th>
                <th class="col-2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${mealPlanList}">
                <c:choose>
                    <c:when test="${list.dayName == 'poniedziałek'}">
                        <tr class="d-flex">
                            <td class="col-2">${list.mealName}</td>
                            <td class="col-8">${list.recipeName}</td>
                            <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>

        <table class="table">
            <thead>
            <tr class="d-flex">
                <th class="col-2">Wtorek</th>
                <th class="col-8"></th>
                <th class="col-2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${mealPlanList}">
                <c:choose>
                    <c:when test="${list.dayName == 'wtorek'}">
                        <tr class="d-flex">
                            <td class="col-2">${list.mealName}</td>
                            <td class="col-8">${list.recipeName}</td>
                            <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>

        <table class="table">
            <thead>
            <tr class="d-flex">
                <th class="col-2">Środa</th>
                <th class="col-8"></th>
                <th class="col-2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${mealPlanList}">
                <c:choose>
                    <c:when test="${list.dayName == 'środa'}">
                        <tr class="d-flex">
                            <td class="col-2">${list.mealName}</td>
                            <td class="col-8">${list.recipeName}</td>
                            <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>





<%--        <table class="table">--%>
<%--            <thead>--%>
<%--            <tr class="d-flex">--%>
<%--                <th class="col-2">Poniedziałek</th>--%>
<%--                <th class="col-8"></th>--%>
<%--                <th class="col-2"></th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tr class="d-flex">--%>
<%--                <td class="col-2">śniadanie</td>--%>
<%--                <td class="col-8">płatki owsiane z jagodami i komosą ryżową</td>--%>
<%--                <td class="col-2">--%>
<%--                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="d-flex">--%>
<%--                <td class="col-2">śniadanie</td>--%>
<%--                <td class="col-8">kanapka z pastą rybną</td>--%>
<%--                <td class="col-2">--%>
<%--                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="d-flex">--%>
<%--                <td class="col-2">obiad</td>--%>
<%--                <td class="col-8">zupa pomidorowa</td>--%>
<%--                <td class="col-2">--%>
<%--                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--        <table class="table">--%>
<%--            <thead>--%>
<%--            <tr class="d-flex">--%>
<%--                <th class="col-2">Wtorek</th>--%>
<%--                <th class="col-8"></th>--%>
<%--                <th class="col-2"></th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr class="d-flex">--%>
<%--                <td class="col-2">śniadanie</td>--%>
<%--                <td class="col-8">płatki owsiane z jagodami i komosą ryżową</td>--%>
<%--                <td class="col-2">--%>
<%--                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="d-flex">--%>
<%--                <td class="col-2">drugie śniadanie</td>--%>
<%--                <td class="col-8">pączki</td>--%>
<%--                <td class="col-2">--%>
<%--                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr class="d-flex">--%>
<%--                <td class="col-2">obiad</td>--%>
<%--                <td class="col-8">schabowy w panierce</td>--%>
<%--                <td class="col-2">--%>
<%--                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
    </div>
</div>
</div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>