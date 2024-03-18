<%@ page errorPage="../../ErrorPage.jsp"%>
<%@ page import="fr.paris.lutece.plugins.blog.web.ManageBlogJspBean"%>

<jsp:useBean id="blogJspBean" scope="session" class="fr.paris.lutece.plugins.blog.web.BlogJspBean" />

<%
blogJspBean.init( request, ManageBlogJspBean.RIGHT_MANAGEHTMLDOCS );
response.sendRedirect( blogJspBean.doExecuteSelectedAction( request ) );
%>