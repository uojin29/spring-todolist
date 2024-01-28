<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Fancy To-Do List</title>
</head>
<body>
<h1>Fancy To-Do List</h1>
<form action="${context}/tasks" method="post">
    <input type="text" name="title" placeholder="Task title" required>
    <button type="submit">Add Task</button>
</form>
<ul>
    <c:forEach items="${tasks}" var="task" varStatus="loopStatus">
        <li class="list">
            <label>
                <input type="checkbox" class="complete" onclick="deleteTask(${task.id})"/>
            </label>
            <span class="task-title">${task.title}</span>
            <button type="button" class="edit-btn" data-id="${task.id}" data-title="${task.title}"
                    data-index="${loopStatus.index}">edit
            </button>
        </li>
    </c:forEach>
</ul>
<script src="${context}/static/js/script.js"></script>
</body>
</html>

