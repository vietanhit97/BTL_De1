<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp"%>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">
				<fmt:message bundle="${bun}" key="manageCategory" />
			</h3>
			<form action="${pageContext.request.contextPath}/SearchCategores"
				method="post" class="form-inline" role="form">
				<div class="form-group">
					<input oninput="searchByName(this)" id="content" type="text"
						name="key" class="form-control"
						placeholder="<fmt:message bundle="${bun}" key="Search"/>">
				</div>
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>
				<a
					href="${pageContext.request.contextPath}/admin/category/insertCategory.jsp"
					class="btn btn-success btn-sm"><fmt:message bundle="${bun}"
						key="theadAddNewCategory" /></a>
			</form>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse" data-toggle="tooltip" title="Collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-widget="remove"
					data-toggle="tooltip" title="Remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><fmt:message bundle="${bun}" key="theadId" /></th>
						<th><fmt:message bundle="${bun}" key="theadNameCategory" /></th>
						<th>status</th>
						<th>parentId</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="c">
						<tr>
							<td>${c.id }</td>
							<td>${c.catname }</td>
							<td><c:choose>
									<c:when test="${c.status == 0}">
										<span class="label label-danger"> <fmt:message bundle="${bun}" key="theadCategory" />hide</span>
									</c:when>
									<c:otherwise>
										<span class="label label-success"> <fmt:message bundle="${bun}" key="show" /></span>
									</c:otherwise>
								</c:choose></td>
							<td>${c.parentld }</td>
							<td><a
								href="${pageContext.request.contextPath}/DeleteCategory?id=${c.id}"
								class="btn btn-danger btn-sm"
								onclick="return confirm('Bạn có muốn xóa không ?')"><fmt:message
										bundle="${bun}" key="theadDelete" /></a> <a
								href="${pageContext.request.contextPath}/PreUpdateCategory?id=${c.id}"
								class="btn btn-success btn-sm"><fmt:message bundle="${bun}"
										key="theadUpdate" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-center">
			<nav aria-label="Page navigation ">
				<ul class="pagination">
					<c:forEach begin="1" end="${endPage}" var="i">
						<li class="page-item"><a class="page-link" id="${i}"
							href="${pageContext.request.contextPath}/ListCategory?index=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../layout/footer.jsp"%>