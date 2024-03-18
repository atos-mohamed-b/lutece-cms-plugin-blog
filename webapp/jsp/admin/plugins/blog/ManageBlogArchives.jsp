<jsp:useBean id="manageBlogArchives" scope="session" class="fr.paris.lutece.plugins.blog.web.ManageBlogArchivesJspBean" />
<% String strContent = manageBlogArchives.processController ( request , response ); %>

<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />
<%= strContent %>
<%@ include file="../../AdminFooter.jsp" %>