<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>
  
<p>Thank you for your patronage of the Belk Library.</p> 
<p>You've successfully checked out the book, ${bookTitle}.</p>
<p>Please note that this book is due back on ${dueDate}.</p>
<p>A friendly email reminder will be sent to you if your
  book becomes overdue.</p>
<a href="<c:url value='/library'/>">
    Return to front page
</a>
</div>

<%@ include file="/includes/footer.jsp" %>