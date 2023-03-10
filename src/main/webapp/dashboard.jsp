<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="${pageContext.request.contextPath}/fragments/headerLogged.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


<div class="m-4 p-4 width-medium">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="/app/recipe/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/app/plan/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj plan</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/app/recipe/plan/add">
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

        <c:forEach var="dayNameList" items="${dayNameList}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">${dayNameList.name}</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="list" items="${mealPlanList}">
                    <c:choose>
                        <c:when test="${list.dayName == dayNameList.name}">
                            <tr class="d-flex">
                                <td class="col-2">${list.mealName}</td>
                                <td class="col-8">${list.recipeName}</td>
                                <td class="col-2">
                                    <button type="button" class="btn btn-primary rounded-0">Szczegóły</button>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>

    </div>
</div>
</div>
</section>



<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>