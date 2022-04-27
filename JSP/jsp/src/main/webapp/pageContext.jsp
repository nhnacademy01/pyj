<%@ page contentType="text/html;charset=UTF-8" language="java" %>
THIS IS pageContext.jsp.<br />
<%    String type = request.getParameter("type"); %>
<%    if ("include".equals(type)) { %>
//        pageContext.include("sub.jsp");
        <jsp:include page="sub.jsp" />
<%    } else if ("forward".equals(type)) { %>
//        pageContext.forward("sub.jsp");
        <jsp:forward page="sub.jsp" />
<%    } else {
        out.println("type parameter is needed.");
    }
%>
