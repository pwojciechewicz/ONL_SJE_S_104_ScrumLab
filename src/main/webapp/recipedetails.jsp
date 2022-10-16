<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<jsp:include page="${pageContext.request.contextPath}/fragments/headerLogged.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


    <div class="m-4 p-3 width-medium text-color-darker">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
          <div class="row border-bottom border-3">
            <div class="col"><h3 class="color-header text-uppercase">Szczegóły przepisu</h3></div>
            <div class="col d-flex justify-content-end mb-2"><a href="/app/recipe/list" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a></div>
          </div>

          <table class="table borderless">
            <tbody>

            <tr class="d-flex">
              <th scope="row" class="col-2">Nazwa Przepisu</th>
              <td class="col-7">${recipeName.name}</td>
            </tr>
            <tr class="d-flex">
              <th scope="row" class="col-2">Opis przepisu</th>
              <td class="col-7">${recipeName.description}</td>
            </tr>
            <tr class="d-flex">
              <th scope="row" class="col-2">Przygotowanie (minuty)</th>
              <td class="col-7">${recipeName.preparationTime}</td>
            </tr>
            </tbody>
          </table>

          <div class="row d-flex">
            <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Sposób przygotowania</h3></div>
            <div class="col-2"></div>
            <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Składniki</h3></div>
          </div>
          <div class="row d-flex">
            <div class="col-5 p-4">
              <p>${recipeName.preparation}</p>
            </div>
            <div class="col-2"></div>
            <ul class="col-5 p-4 list-unstyled">
              <li>${recipeName.ingredients}</li>

            </ul>
          </div>

        </div>
      </div>
    </div>
  </div>
</section>

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>