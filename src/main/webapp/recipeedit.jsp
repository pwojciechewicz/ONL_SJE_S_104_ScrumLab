<%--
  Created by IntelliJ IDEA.
  User: cyluna
  Date: 15.10.2022
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">

<jsp:include page="${pageContext.request.contextPath}/header.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/sideBarMenu.jsp"/>


<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
            <!-- fix action, method -->
            <!-- add name attribute for all inputs -->
            <form>
                <div class="row border-bottom border-3">
                    <div class="col"><h3 class="color-header text-uppercase">Edycja przepisu</h3></div>
                    <div class="col d-flex justify-content-end mb-2"><button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button></div>
                    <input type="hidden" id="id" name="id" value="${recipe.id}">
                </div>

                <table class="table borderless">
                    <tbody>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Nazwa Przepisu</th>
                        <td class="col-7">
                            <input class="w-100 p-1" name="name" value="${recipe.name}" id="name">
                        </td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Opis przepisu</th>
                        <td class="col-7"> <textarea name="description" value="${recipe.description}" id="description"class="w-100 p-1" rows="5"></textarea></td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2">Przygotowanie (minuty)</th>
                        <td class="col-3">
                            <input class="p-1" type="number" name="preparation_time" id="preparation_time" value="${recipe.preparationTime}">
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
                        <textarea name="preparation" id="preparation" value="${recipe.preparation}"class="w-100 p-1" rows="10"></textarea>
                    </div>
                    <div class="col-2"></div>

                    <div class="col-5 p-4">
                        <textarea name="ingredients" id="ingredients" value="${recipe.ingredients}"class="w-100 p-1" rows="10"></textarea>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
</section>


<jsp:include page="${pageContext.request.contextPath}/footer.jsp"/>