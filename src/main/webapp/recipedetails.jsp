<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<jsp:include page="${pageContext.request.contextPath}/header.jsp"/>

<section class="dashboard-section">
  <div class="row dashboard-nowrap">
    <ul class="nav flex-column long-bg">
      <li class="nav-item">
        <a class="nav-link" href="/dashboard.html">
          <span>Pulpit</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/app-recipes.html">
          <span>Przepisy</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/app-schedules.html">
          <span>Plany</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/app-edit-user-data.html">
          <span>Edytuj dane</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="/app-edit-password.html">
          <span>Zmień hasło</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/super-admin-users.html">
          <span>Użytkownicy</span>
          <i class="fas fa-angle-right"></i>
        </a>
      </li>
    </ul>

    <div class="m-4 p-3 width-medium text-color-darker">
      <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
          <div class="row border-bottom border-3">
            <div class="col"><h3 class="color-header text-uppercase">Szczegóły przepisu</h3></div>
            <div class="col d-flex justify-content-end mb-2"><a href="app/recipe/list" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a></div>
          </div>

          <table class="table borderless">
            <tbody>
            <tr class="d-flex">
              <th scope="row" class="col-2">Nazwa Przepisu</th>
              <td class="col-7">
                Zapiekanka z ziemniakami i brukselką
              </td>
            </tr>
            <tr class="d-flex">
              <th scope="row" class="col-2">Opis przepisu</th>
              <td class="col-7">Mamusina najlepsza zapiekanka pod słońcem. Można ją podać jako główne danie albo jako kolację. W zapiekance możesz użyć również kiełbasy paprykowej sprawi ona, że zapiekanka będzie ostrzejsza w smaku. Zgodnie z zalecanimi Makłowicza, podawać z dobrze dobranym winkiem ;)</td>
            </tr>
            <tr class="d-flex">
              <th scope="row" class="col-2">Przygotowanie (minuty)</th>
              <td class="col-7">
                45
              </td>
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
              <p>Po tym czasie ziemniaki zalej śmietaną wymieszaną z Knorr Naturalnie smaczne, dodaj liście brukselki i dokładnie wymieszaj.</p>
            </div>
            <div class="col-2"></div>
            <ul class="col-5 p-4 list-unstyled">
              <li>brukselka 300g</li>
              <li>ziemniaki 500g</li>
              <li>Fix Naturalnie makaronowa z szynką Knorr 1 szt.</li>
              <li>średnia cebula 1szt.</li>
              <li>ząbek czosnku 1szt.</li>
              <li>kiełbasa np. śląska 500g</li>
              <li>śmietana 18% 200 ml</li>
              <li>Rama Smaż jak szef kuchni, wariant klasyczny 4 łyżki</li>
              <li>gałązka tymianku 1 szt.</li>
            </ul>
          </div>

        </div>
      </div>
    </div>
  </div>
</section>

<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>