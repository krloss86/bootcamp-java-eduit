<%@page import="ar.com.educacionit.web.enums.AttributesEnum"%>
<%
	String exito = (String)request.getAttribute(AttributesEnum.EXITO.getValue());
	String error = (String)request.getAttribute(AttributesEnum.ERROR_GENERAL.getValue());
	
	String clase = null;
	if(exito !=null || error != null) {
		clase = exito!=null ? "success" : "error";
	}
%>

<%
	if(clase != null) {
%>
	<div class="alert alert-<%=clase%>" role="alert">
	  A simple success alert—check it out!
	</div>
<%
	}
%>