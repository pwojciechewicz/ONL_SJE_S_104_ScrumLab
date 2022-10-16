<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<jsp:include page="${pageContext.request.contextPath}/header.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/app/recipe/plan/add" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Wyślij</a>
            </div>
        </div>

        <div class="schedules-content">
            <form action="/app/recipe/plan/add" method="post">
                <div class="form-group row">
                    <label for="choosePlan" class="col-sm-2 label-size col-form-label">
                        Wybierz plan
                    </label>
                    <div class="col-sm-3">
                        <select class="form-control" id="choosePlan">
                            <c:forEach var="planName" items="${planNames}">

                                <option value="${planName.id}">${planName.name}</option>

                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 label-size col-form-label">
                        Nazwa posiłku
                    </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="mealName" value="${mealName}" id="name"
                               placeholder="Nazwa posiłku">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="number" class="col-sm-2 label-size col-form-label">
                        Numer posiłku
                    </label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="mealDisplayOrder" value="${mealDisplayOrder}" id="number"
                               placeholder="Numer posiłki">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="recipe" class="col-sm-2 label-size col-form-label">
                        Przepis
                    </label>
                    <div class="col-sm-4">

                        <select class="form-control" id="recipe">

                            <c:forEach var="recipeName" items="${recipeNames}">

                                <option value="${recipeName.id}">${recipeName.name}</option>
                         </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="day" class="col-sm-2 label-size col-form-label">
                        Dzień
                    </label>
                    <div class="col-sm-2">
                        <select class="form-control" id="day">
                            <c:forEach var="dayName" items="${dayNames}">
                                <option value="${dayName.id}">${dayName.name}</option>

                            </c:forEach>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</section>

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>