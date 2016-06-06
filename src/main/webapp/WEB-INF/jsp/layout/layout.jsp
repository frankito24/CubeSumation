<%@ include file="/WEB-INF/jsp/layout/taglib.jsp"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><tiles:insertAttribute name="title"/></title>
        <%@ include file="/WEB-INF/jsp/layout/css.jsp"%>
        <%@ include file="/WEB-INF/jsp/layout/js.jsp"%>
        <tiles:insertAttribute name="css"/>
        <tiles:insertAttribute name="js"/>

    </head>
    <body>
        <tiles:insertAttribute name="body"/>
        <footer>
            <tiles:insertAttribute name="footer"/>
        </footer>
    </body>

</html>
