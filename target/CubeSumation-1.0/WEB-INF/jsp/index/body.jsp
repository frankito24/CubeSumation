<%@include file="/WEB-INF/jsp/layout/taglib.jsp"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!--Cabecera-->
<nav class="teal darken-2">
    <div class="nav-wrapper">
        <a href="#" class="brand-logo">Test Cube Sumation</a>
    </div>
</nav>

<div class="container">
    <form:form method='POST' class="col s12" commandName="indexForm">
    <div class="row">
        <div class="col s12">
            <ul class="collapsible" data-collapsible="accordion">
                <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Request</a>
                    <div class="collapsible-body" style="">
                        <div class="row">
                            <div class="col s12">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:textarea path="request" id="request" class="materialize-textarea"/>
                                        <label for="request">Request</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="bold"><a class="collapsible-header  waves-effect waves-teal">Response</a>
                    <div class="collapsible-body" style="">
                        <div class="row">
                            <div class="col s12">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <form:textarea path="response" id="response" class="materialize-textarea"/>
                                        <label for="response">Response</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>

    <!--Boton-->
    <div class="row">
        <div class="col s12 m6 l3 center">
            <button class="waves-effect waves-light btn" type="submit" name="action"><i class="material-icons">send</i> Submit</button>
        </div>
    </div>
</form:form>
</div>