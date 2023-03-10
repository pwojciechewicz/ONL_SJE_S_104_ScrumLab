<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<jsp:include page="${pageContext.request.contextPath}/fragments/headerLogged.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


<div class="m-4 p-3 width-medium">
<div class="dashboard-content border-dashed p-3 m-4 view-height">
<div class="row border-bottom border-3 p-1 m-1">
    <div class="col noPadding">
        <h3 class="color-header text-uppercase">LISTA PLANÓW</h3>
    </div>
    <div class="col d-flex justify-content-end mb-2 noPadding">
        <a href="/app/plan/add" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj plan</a>
    </div>
</div>

<div class="schedules-content">
<table class="table border-bottom">
<thead>
<tr class="d-flex">
    <th class="col-1">ID</th>
    <th class="col-2">NAZWA</th>
    <th class="col-7">OPIS</th>
    <th class="col-2 center">AKCJE</th>
</tr>
</thead>
<tbody class="text-color-lighter">
<c:forEach var="plan" items="${plans}">
    <tr class="d-flex">
    <td class="col-1">${plan.id}</td>
    <td class="col-2">${plan.name}</td>
    <td class="col-7">${plan.description}</td>
    <td class="col-2 d-flex align-items-center justify-content-center flex-wrap"><a href="/delete/list/plan?id=${plan.id}" class="btn btn-danger rounded-0 text-light m-1" onclick="return confirm('Czy na pewno chcesz to usunąć?')">Usuń</a>
    <a href="/app/plan/details?id=${plan.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
    <a href="/app/plan/edit?id=${plan.id}" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>
    </td>
    </tr>
</c:forEach>
<%--    <tr class="d-flex">--%>
<%--    <td class="col-1">2</td>--%>
<%--    <td class="col-2">Plan jarski na bezmięsny tydzień</td>--%>
<%--    <td class="col-7">--%>
<%--    Pojęcie kuchnia wegetariańska określa pożywienie, które ani nie zawiera mięsa, ani nie zostało przygotowane na bazie pochodzącej z mięsa (np. na rosole drobiowym). Laktoowowegetarianie (najczęściej spotykany typ wegetarian w zachodnim świecie) spożywają nabiał, laktowegetarianie wykluczają jaja, ale nie inne produkty nabiałowe.--%>
<%--    </td>--%>
<%--    <td class="col-2 d-flex align-items-center justify-content-center flex-wrap"><a href="#" class="btn btn-danger rounded-0 text-light m-1 " onclick="return confirm('Czy na pewno chcesz to usunąć?')">Usuń</a>--%>
<%--    <a href="/app/plan/details" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>--%>
<%--    <a href="/app/plan/edit" class="btn btn-warning rounded-0 text-light m-1">Edytuj</a>--%>
<%--    </td>--%>
<%--    </tr>--%>
    </tbody>
    </table>
    </div>
    </div>
    </div>
    </div>
    </section>

    <jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>

