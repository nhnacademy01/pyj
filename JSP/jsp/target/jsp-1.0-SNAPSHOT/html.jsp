<%@ page contentType="text/plain;charset=UTF-8" language="java" %>
<%--getProperty에서 property에 html을 넣으면 text/html 에서 자동으로 랜더링이 되어서
text/plain으로 바꿨고, <head>와 같은 html 태그를 지웠다--%>
<jsp:useBean id="htmlBeautifier" scope="request" class="com.nhnacademy.jsp.domain.HtmlBeautifier">
<jsp:setProperty name="htmlBeautifier" property="html" param="html"/>
    <!-- parameter로 날라온 form의 값이 그대로 박힘 -->
</jsp:useBean>

<jsp:getProperty name="htmlBeautifier" property="html"/>

