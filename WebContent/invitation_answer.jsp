<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>帖子浏览</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/spinner/ui.spinner.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/spinner/jquery.mousewheel.js"></script>

<script src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/charts/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/charts/jquery.sparkline.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/forms/uniform.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.cleditor.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.validationEngine-en.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.validationEngine.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.tagsinput.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/autogrowtextarea.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.maskedinput.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.dualListBox.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.inputlimiter.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/chosen.jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.form.wizard.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.html5.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.html4.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/jquery.plupload.queue.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/tables/datatable.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/tables/tablesort.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/tables/resizable.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.tipsy.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.collapsible.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.prettyPhoto.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.progress.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.timeentry.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.colorpicker.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.jgrowl.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.breadcrumbs.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.sourcerer.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/calendar.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/elfinder.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>

<!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  -->
<style>
.w-e-text-container{
    height: 140px !important;/*!important是重点，因为原div是行内样式设置的高度300px*/
}
</style>
</head>

<body>

<!-- Left side content -->
<%@ include file="user_left_side.jsp" %>

<!-- Right side -->
<div id="rightSide">

	<%@ include file="user_top_nav.jsp" %>
	<form id="validate" class="form" method="post" action="">
		<fieldset>
			<div class="widget">
				<!-- 帖子内容 -->
				<div class="title"><h6>${invitation.invitationTitle }</h6></div>
 				<div class="formRow">
 					<img style="width:30px;" src="${pageContext.request.contextPath}/static/file/${invitation.userPhoto }" alt="" /><br/>
					<label>${invitation.userAlice }</label>
					<div class="formRight">${invitation.invitationMessage }</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<!-- 帖子回复 -->
				<div class="formRow">
					<img style="width:30px;" src="${pageContext.request.contextPath}/static/file/xxx.jpg" alt="" /><br/>
					<label>李四</label>
					<div class="formRight">你怕有病吧</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<!-- 帖子回复 -->
				<div class="formRow">
					<img style="width:30px;" src="${pageContext.request.contextPath}/static/file/xxx.jpg" alt="" /><br/>
					<label>王五</label>
					<div class="formRight">记得吃药！</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<!-- 回复 -->
				<div class="formRow">
					<label>&nbsp;</label>
					<div class="formRight" id="editor"></div>
					<div class="clear"></div>
				</div>
				<div class="formSubmit"><input type="submit" value="回复" class="redB" /></div>
				<div class="clear"></div>
			</div>
		</fieldset>
	</form>
    
    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">&nbsp;</div>
    </div>

</div>

<div class="clear"></div>
<script>
var E = window.wangEditor;
var editor = new E('#editor');
// 自定义菜单配置
editor.customConfig.menus = [
    'head',// 标题
    'bold',// 加粗
    'fontSize',//字号
    'fontName', //字体
    'italic',//倾斜
    'underline',//下划线
    'strikeThrough',  // 删除线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'justify',  // 对齐方式
    'emoticon',  // 表情
    'image',  // 插入图片
    'undo',  // 撤销
    'redo'  // 重复
];
	// 自定义配置颜色（字体颜色、背景色）
editor.customConfig.colors = [
    '#000000',
    '#eeece0',
    '#1c487f',
    '#4d80bf',
    '#c24f4a',
    '#8baa4a',
    '#7b5ba1',
    '#46acc8',
    '#f9963b'
];
// 自定义字体
editor.customConfig.fontNames = [
    '宋体',
    '黑体',
    '华文新魏',
    '微软雅黑',
    'Arial',
    'Tahoma',
    'Verdana'
];
// 关闭粘贴样式的过滤
editor.customConfig.pasteFilterStyle = true;
// 忽略粘贴内容中的图片
editor.customConfig.pasteIgnoreImg = true;
	// 上传图片到服务器
editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/upload';
	// 隐藏“网络图片”tab
editor.customConfig.showLinkImg = false;
	// 将图片大小限制为 2M
editor.customConfig.uploadImgMaxSize = 2 * 1024 * 1024;
// 限制一次最多上传 5 张图片
editor.customConfig.uploadImgMaxLength = 5;
	// 监听函数，可使用监听函数在上传图片的不同阶段做相应处理
	editor.customConfig.uploadImgHooks = {
	customInsert: function (insertImg, result, editor) {
    	for(var i in result){
    		insertImg('${pageContext.request.contextPath}/static/file/'+result[i]);
    	}
	}
}
editor.create();
// 下面的script用于处理提交 
$(function(){
 $("form").submit(function(){
	 // 把富文本框中的内容作为id为invitationMessage的值
	 $("#invitationMessage").val(editor.txt.html());
 });
});
</script>
</body>
</html>

    