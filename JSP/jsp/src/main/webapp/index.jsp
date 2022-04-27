<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String name="AA"; %>

<html>
    <head>
        <title><%= "title" %>></title>
    </head>
    <body>
    <%= "Hello, Wolrd! "%>
    <%= name %>

    <% for(int i=2; i<10; i++) { %>
        <%for(int j=1; j<10; j++) { %>
            <%= i + " * " + j + " = " + (i*j) %>
            <br>
        <% }%>
    <br>
    <% } %>

    </body>
</html>
