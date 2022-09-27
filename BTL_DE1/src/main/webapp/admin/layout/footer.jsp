<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</div>
<!-- /.content-wrapper -->
<footer class="main-footer">
	<div class="pull-right hidden-xs">
		<b>Version</b> 2.4.0
	</div>
	<strong>Copyright &copy; 2014-2016 <a
		href="https://adminlte.io">Almsaeed Studio</a>.
	</strong> All rights reserved.
</footer>
</div>
<!-- ./wrapper -->
<!-- jQuery 3 -->
<script
	src="${pageContext.request.contextPath}/admin/css/js/jquery.min.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/js/jquery-ui.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/js/bootstrap.min.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/js/adminlte.min.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/js/dashboard.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/tinymce/tinymce.min.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/tinymce/config.js" /></script>
<script
	src="${pageContext.request.contextPath}/admin/css/js/function.js" /></script>
<script>
	document.getElementById('${index}').style.backgroundColor = "CornflowerBlue";
	document.getElementById('${index}').style.color = "black";
</script>
<script>
	function submitForm(){
		document.getElementById('changeLang').submit();
	}
</script>
<script>
$('#upload').change(function(ev) {
    var input = $(this)[0];
    console.log(input);
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#show_image').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
})
</script>
</body>
</html>
