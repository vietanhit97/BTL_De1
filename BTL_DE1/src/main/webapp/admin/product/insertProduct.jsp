<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp"%>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"><fmt:message bundle="${bun}" key="theadAddNewProduct" /></h3>
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
			<form action="InsertProduct" method="POST" role="form"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}" key="theadNameProduct" /></label> <input type="text"
								class="form-control" name="name" id=""
								placeholder="Tên sản phẩm ">
						</div>
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}" key="image" /></label> <input type="file"
								class="form-control" name="upload" id="upload"
								placeholder="Ảnh sản phẩm "> <img src="" id="show_image"
								alt="" style="width: 300px">
						</div>
						<div class="form-group">
							<label for="">Mô tả</label>
							<textarea name="description" id="content" class="form-control"
								rows="3" placeholder="Mô tả sản phẩm..."></textarea>
						</div>
						<button type="submit" class="btn btn-primary">
							<fmt:message bundle="${bun}" key="addNew" />
						</button>
					</div>
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}"
									key="theadCategory" /> :</label> <select name="catId" id="input"
								class="form-control" required="required">
								<option value=""><fmt:message bundle="${bun}"
										key="selectCategory" /></option>
								<c:forEach items="${list}" var="c">
									<option value="${c.id}">${c.catname }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}" key="theadPrice" />:</label> <input type="text"
								class="form-control" name="price" id=""
								placeholder="Giá sản phẩm ">
						</div>
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}" key="theadSalePrice" />:</label> <input type="text"
								class="form-control" name="sale_price" id=""
								placeholder="Giá khuyến mãi ">
						</div>
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}" key="quantity" /> :</label> <input type="text"
								class="form-control" name="quantity" id=""
								placeholder="Số Lượng ">
						</div>
						<div class="form-group">
							<label for=""><fmt:message bundle="${bun}" key="status" /></label>
							<div class="radio">
								<label> <input type="radio" name="status" value="1"
									checked> <fmt:message bundle="${bun}" key="show" />
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="status" value="0">
									<fmt:message bundle="${bun}" key="hide" />
								</label>
							</div>
						</div>
						
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../layout/footer.jsp"%>