$(document).ready(function(){
	$("#locId").change(function(){
		$.ajax({
			url:'checkid',
			data:{eid:$("#locId").val()},
			success:function(resTxt){
				$("#errmsg").text(resTxt);
				if(resTxt!=""){
					$("#locId").val("");
					$("#locId").focus();
				}
					
			}
		});
	});
});
