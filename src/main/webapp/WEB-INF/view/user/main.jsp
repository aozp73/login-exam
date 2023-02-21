<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <%@ include file="../layout/nav.jsp" %>

            <div class="container my-3">
                <div class="my-board-box row">

                    <div class="card col-lg-3 p-3">
                        <img class="card-img-top" style="height: 250px;" src="/images/spring.png" alt="Card image">
                        <hr>
                        <div class="card-body">
                            <div>작성자 : 홍길동</div>
                            <h4 class="card-title my-text-ellipsis"> 스프링 </h4>
                            <a href="/board/1" class="btn btn-primary">상세보기</a>
                        </div>
                    </div>
                    <div class="card col-lg-3 p-3">
                        <img class="card-img-top" style="height: 250px;" src="/images/java.png" alt="Card image">
                        <hr>
                        <div class="card-body">
                            <div>작성자 : 임꺽정</div>
                            <h4 class="card-title my-text-ellipsis"> Java </h4>
                            <a href="/board/1" class="btn btn-primary">상세보기</a>
                        </div>
                    </div>
                    <div class="card col-lg-3 p-3">
                        <img class="card-img-top" style="height: 250px;" src="/images/sql.png" alt="Card image">
                        <hr>
                        <div class="card-body">
                            <div>작성자 : 이순신</div>
                            <h4 class="card-title my-text-ellipsis"> SQL </h4>
                            <a href="/board/1" class="btn btn-primary">상세보기</a>
                        </div>
                    </div>
                    <div class="card col-lg-3 p-3">
                        <img class="card-img-top" style="height: 250px;" src="/images/JavaScript.png" alt="Card image">
                        <hr>
                        <div class="card-body">
                            <div>작성자 : 장보고</div>
                            <h4 class="card-title my-text-ellipsis"> JavaScript </h4>
                            <a href="/board/1" class="btn btn-primary">상세보기</a>
                        </div>
                    </div>

                </div>
                <ul class="pagination mt-3 d-flex justify-content-center">
                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </div>

            <%@ include file="../layout/footer.jsp" %>