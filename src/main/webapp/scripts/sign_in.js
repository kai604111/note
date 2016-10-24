/**
 * 
 */
$(function() {
	$('#regist_button').on('keydown',function(){
		if (event.keyCode==13) {
			sign();
		}
	});
	$('#regist_button').click(sign);
});

function sign() {

	var name = $('#regist_username').val();
	var nick = $('#nickname').val();
	var password1 = $('#regist_password').val();
	var password2 = $('#final_password').val();
	$.ajax({
		type: 'post',
		url: 'sign/sign.do',
		dataType: 'json',
		data: {
			'name': name,
			'nick': nick,
			'password1': password1,
			'password2': password2
		},
		success: function(result) {
			if (result.state==0) {
				window.location.href="log_in.html";
				$('#count').val(name);
			}
			console.log(result);
		},
		error: function() {
			alert(result.message);
		}
	});

}