/**
 * script/log_in.js编码UTF-8
 */

//var SUCCESS = 0;
//var ERROR = 1; count.js常量表代替
//console.log("Hello!");
$(function(){
//	console.log('呵呵');
//	var obj = $('#login');
//	console.log(obj);
	$('#login').click(loginAction);
	$('#count')
	.on('blur',checkName)
	.on('focus',function(){
		$('#count_msg').empty();
	}).focus();
	$('#password')
	.on('blur',checkPassword)
	.on('focus',function(){
		$('#password_msg').empty();
	}).on('keydown',function(){
		if (event.keyCode==13) {
			loginAction();
		}
	});
	
});


function checkName(){
	var name = $('#count').val();
	if(name==''){
		$('#count_msg').empty().append('不能为空');
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(reg.test(name)){
		$('#count_msg').empty();
		return true;
	}
	$('#count_msg').empty().append('3~10个字符');
	return false;
}

function checkPassword(){
	var password = $('#password').val();
	if(password==''){
		$('#password_msg').empty().append('不能为空');
		return false;
	}
	var reg = /^\w{3,18}$/;
	if(reg.test(password)){
		$('#password_msg').empty();
		return true;
	}
	$('#password_msg').empty().append('3~18个字符');
	return false;
}

function loginAction(){
//	console.log("Login Clicked!");
	checkName();
	checkPassword();
	var name = $('#count').val();
	var password = $('#password').val();

//	表单检查,如果没有用户名或密码就不在提交了
	var namePass = checkName();
	var pwdPass = checkPassword();
	if(!namePass || !pwdPass){
		return false;
	}
	
	$.ajax({
		url:'account/login.do',
		type:'post',
		data:{'name':name,'password':password},
		dataType:'JSON',
		success:function(result){
			if(result.state==SUCCESS){
				var user = result.data;
//				setCookie(USER_ID,user.userId);
				window.location.href='edit.html';
				return ;
			}
			var field = result.state;
			if(field==1||field==3){
//				显示用户名错误
				$('#count_msg').append(result.message);
			}
			if(field==2||field==4){
//				显示密码错误
				$('#password_msg').append(result.message);
			}
		},
		error:function(result){
			console.log('登录失败');
		}
	});
}

