<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="${pageContext.request.contextPath}/fragments/headerLogged.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


<div class="m-4 p-3 width-medium ">
    <div class="dashboard-content border-dashed p-3 m-4">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">SZCZEGÓŁY PLANU</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/app/plan/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
        </div>

        <div class="schedules-content">
            <div class="schedules-content-header">
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">
                            <c:if test="${not empty planName}">
                                ${planName}
                            </c:if>
                        </p>
                    </div>
                </div>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">
                            <c:if test="${not empty planDescription}">
                                ${planDescription}
                            </c:if>
                        </p>
                    </div>
                </div>
            </div>
            <c:if test="${not empty planDetailsList}">
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

                        <c:forEach var="list" items="${planDetailsList}">
                            <c:choose>
                                <c:when test="${list.dayName == dayNameList.name}">
                                    <tr class="d-flex">
                                        <td class="col-2">${list.mealName}</td>
                                        <td class="col-8">${list.recipeName}</td>
                                        <td class="col-1 center">
                                            <a href="/delete/recipe/from/plan?id1=${list.recipePlanId}&id2=${list.planId}"
                                               class="btn btn-danger rounded-0 text-light m-1"
                                               onclick="return confirm('Czy na pewno chcesz to usunąć?')">Usuń</a>
                                        </td>
                                        <td class="col-1 center">
                                            <a href="/app/recipe/details?id=${list.recipeId}"
                                               class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
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
            </c:if>

        </div>
    </div>
</div>
</div>
</section>


<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>