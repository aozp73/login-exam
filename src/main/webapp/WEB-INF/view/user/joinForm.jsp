<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <%@ include file="../layout/header.jsp" %>
        <%@ include file="../layout/nav.jsp" %>

    <%-- header / nav 경계선 --%>

            <div class="container my-3">
                <div class="container d-flex justify-content-center">
                    <form action="/join" method="post" onsubmit="return valid()">

                        <div class="d-flex form-group mb-2">
                            <div class="d-flex ">
                                <input id="username" type="text" name="username" class="form-control"
                                    placeholder="Enter username" size="40">
                            </div>
                        </div>



                        <div class="d-flex form-group mb-2">
                            <div class="d-flex">
                                <input id="password" type="password" name="password" class="form-control"
                                    placeholder="Enter password" size="40">
                            </div>
                        </div>

    

                        <div class="d-flex form-group mb-2">
                            <div class="d-flex">
                                <input id="email" type="email" name="email" class="form-control"
                                    placeholder="Enter email" size="40">
                            </div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-primary">회원가입</button>
                        </div>
                    </form>
                </div>
            </div>


    <%-- footer 경계선 --%>

        <%@ include file="../layout/footer.jsp" %>





