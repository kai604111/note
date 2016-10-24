/*
 * edit.js
 */
$(function(){
	listNotebooksAction();
	$('#add_note').click(addNoteAction);
	$('#add_notebook').click(addNotebookAction);
	$('#save_note').click(saveNoteAction);
	$('#myEditor').on('blur',saveSure);
	$('#logout').click(logout);
})

//模型
var model = {
	notebooks:[],
	notes:[],
	updateNotebooks:function(notebooks){
		this.notebooks = notebooks;
		this.updateNotebooksView();
	},
	updateNotebooksView:function(){
		var view = $('#notebooks-view').empty();
		var view11 = $('#listnote-view').empty();
		for (var i=0;i<this.notebooks.data.length;i++) {
			var bookName = this.notebooks.data[i].name;
			var bookId = this.notebooks.data[i].id;
			var li = $('<li class="online"></li>');
			var a = $('<a></a>');
			var ico = $('<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>');
			li.append(a.append(ico,bookName));
			view.append(li);
			
			if (model.currentNotebookId) {
				if (model.currentNotebookId == bookId) {
					a.addClass('checked');
				}
			}
			
			a.data("index",i)
			
			a.click(function() {
				$('#notebooks-view a').removeClass();
				$(this).addClass('checked');
				//$(this).attr('class','checked');
				index = $(this).data('index');
				model.currentNotebookIndex = index;
				//点击鼠标选的笔记信息
				bookId = model.notebooks.data[index].id;
				listNotesAction(bookId);
				return false;//阻止事件冒泡
			});
		}		
	}
};

model.updateNotes = function (notes) {
	this.notes = notes;
	this.updateNotesView();
}
model.updateNotesView = function () {
	var view = $('#listnote-view').empty();
	for (var i = 0; i < this.notes.data.length; i++) {
		var noteTitle = this.notes.data[i].title;
		var note
		var li = $('<li class="online"></li?>');
		var a = $('<a></a>');
		var ico = $('<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>');
		var menuButton = $('<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>');
		var div = $(
			'<div class="note_menu" tabindex="-1">'+
				'<dl>'+
					'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
					'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
					'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
					'</dl>'+
				'</div>'
//			'</li>'
		);
		
		li.append(a.append(ico,noteTitle,menuButton),div);
		view.append(li);
		
		if(model.currentNoteId == this.notes.data[i].id){
			a.addClass('checked');
		}
		
		a.data("index",i)
		a.click(function (e) {
			$('#listnote-view a').removeClass();
//			model.currentNoteId = undefined;
			$(this).attr('class','checked');
			index = $(this).data('index');
			model.currentnoteIndex = index;
			noteId = model.notes.data[index].id;
			showNoteAction(noteId);
			
			return false;//阻止事件冒泡
		});
		menuButton.data("index",i)
		menuButton.click(function () {
			index = $(this).data('index');
			model.currentMoveNoteIndex=index;
			var menu = $(this).parent().next(); 
			var ico = $(this).children('i');
			ico.removeClass('fa-chevron-down').addClass('fa-chevron-up');
			menu.toggle(function(){
				ico.removeClass('fa-chevron-down').removeClass('fa-chevron-up');
				if ($(this).css('display')=='none') {
					ico.addClass('fa-chevron-down');
				}else{
					ico.addClass('fa-chevron-up');
				}
			},false);
			return false;
		});
//		$('#listnote-view .btn_move').eq(index).click(moveNote);
		div.find('.btn_move').click(moveNote);
		div.find('.btn_delete').click(deleteNote);
	};
}

model.showNote = function (note) {
	this.note = note;
	this.showNoteView();
}

model.showNoteView = function () {
	$('#input_note_title').val(this.note.data.title);
//	$('#myEditor p').html(this.note.data.body);
	um.setContent(this.note.data.body);
	model.currentNoteId=this.note.data.id;
}

model.keyDown = function(id){
	this.id = id
	this.keyDownAction();
}
model.keyDownAction = function(){
	$('#'+this.id).on('keydown',function(){
		if (event.keyCode==13) {
			console.log("执行成功");
			$('#can .sure').click();
			
		}
	});
}

function deleteNote(){
	var url = 'alert/alert_delete_note.html';
	var data = {'abc':Math.random()};
	$('#can').empty().load(url,data,function(){
		$('#can .close ,#can .cancle').click(function(){
			$('#can').empty();
		});
		$('#can .sure').click(function(){
			
			$('#can').empty();
		});
	});
}

function moveNote(){
	var url = 'alert/alert_move.html';
	var data = {'abc':Math.random()};
	$('#can').empty().load(url,data,function(){
		$('#can .close ,#can .cancle').click(function(){
			$('#can').empty();
		});
		var titleval = model.notes.data[model.currentMoveNoteIndex].title;
		$('#can h4').append("  ").append(titleval);
		$('#moveSelect').empty();
		var notebooks = model.notebooks.data;
		for (var i = 0; i < notebooks.length; i++) {
			var notebook = notebooks[i];
//			var opt = $('<option></option>').val(notebook.id).append(notebook.name);
			
			var opt=$('<option></option>').val(notebook.id)
			.append(notebook.name);
			if(notebook.id==model.notebooks.data[model.currentNotebookIndex].id){
				opt.attr('selected', 'selected');
			}
			$('#moveSelect').append(opt);
		}
		$('#can .sure').click(function () {
			moveNoteAction();
			$('#can').empty();
		})
	});
	return false;
}

function moveNoteAction(){
	var notebookId = $('#moveSelect').val();
	var curnotebookId = model.notebooks.data[model.currentNotebookIndex].id;
	if(curnotebookId == notebookId){
		return;
	}
	model.currentNotebookId = notebookId;
	var url = "note/move.do";
	var noteId = model.notes.data[model.currentMoveNoteIndex].id
	var data = {'noteId':noteId,'notebookId':notebookId};
	$.post(url,data,function(result){
		if(result.state == SUCCESS){
			for (var i = 0; i < model.notebooks.data.length; i++) {
				var nId = model.notebooks.data[i].id
				if(nId ==notebookId){
					model.currentNotebook = model.notebooks.data[i];
					model.updateNotebooksView();
//					break;
				}
				
				listNotesAction(model.currentNotebookId);
//				model.currentNote.notebookId = model.currentNotebook.id;
			}
			
			
		}else{
			alert(result.message);
		}
		
	});
}

function saveSure(){
	var title = $('#input_note_title').val();
	var body = um.getContent();
	
	if(!model.note){
		return false;
	}
	if(body==model.note.data.body){
		return false;
	}
	var url = 'alert/alert_save.html';
	var data = {'abc':Math.random()};
	$('#can').empty().load(url,data,function(){
		$('#can .close ,#can .cancle').click(function(){
			$('#can').empty();
		});
		$('#can .sure').click(function () {
			saveNoteAction();
			$('#can').empty();
		})
	});
}

function saveNoteAction(){
	
	if(!(model.currentNotebookIndex+1)){
		alert('请先选定笔记本!');
		return false;
	}
	if (!(model.currentnoteIndex+1)) {
		alert('没有选择笔记本');
		return false;
	}
	var url = 'note/modify.do';
	var noteId = model.notes.data[model.currentnoteIndex].id;
	var title = $('#input_note_title').val();
	var body = um.getContent();
	var data = {'noteId':noteId,'title':title,'body':body};
	if (title==model.note.data.title && body==model.note.data.body) {
		return false;
	}
	$.post(url,data,function(result){
		model.note=result;
		model.notes.data[model.currentnoteIndex].title=model.note.data.title;
		model.updateNotesView();
	});
}

function addNotebookAction(){
	var url = 'alert/alert_notebook.jsp';
	var userId = getCookie('loginUserId');
	var data = {'userId':userId};
	$('#can').empty().load(url,data,function(){
		$('#can .close ,#can .cancle').click(function(){
			$('#can').empty();
		});
		
		//TODO 输入框为空时有bug
		$('#can .sure').click(function(){
			var notebookName = $('#input_notebook').val();
			var userId = getCookie('loginUserId');
			var url = 'notebook/add.do';
			var data = {'userId':userId,'name':notebookName};
			$.post(url,data,function(result){
				model.currentNotebookId = result.data.id;
				listNotebooksAction();
				$('#can').empty();
			});
		});
	});
}

function addNoteAction () {
	
	if (!(model.currentNotebookIndex+1)) {
		alert('请先选定笔记本!');
		return false;
	}
	
	var url = 'alert/alert_note.jsp';
	var data = {'abc':Math.random()};
	$('#can').empty().load(url,data,function(){
		$('#can .close ,#can .cancle').click(function(){
			$('#can').empty();
		});
		model.keyDown('input_note');
		$('#can .sure').click(function () {
			var title = $('#input_note').val();
			var userId = getCookie('loginUserId');
			var notebookId = model.notebooks.data[model.currentNotebookIndex].id; 
			var data = {'notebookId':notebookId,'userId':userId,'title':title};
			var url = 'note/add.do';
			$.post(url,data,function (result) {
				if (result.state==SUCCESS) {
					var note = result;
					model.showNote(note);
					model.currentNoteId = note.data.id;
					model.notes.data.unshift({id:note.data.id,notebookId:note.data.notebookId,title:note.data.title});
					model.updateNotesView(model.notes);
					$('#can').empty();
				} else {
					
				}
			})
//			console.log(title);
//			console.log(userId);
//			console.log(notebookId)
//			console.log(url);
			
		})
	});
}

function showNoteAction (noteId) {
	var url = 'note/load.do';
	var data = {'noteId':noteId};
	$.getJSON(url,data,function (result) {
		if (result.state == SUCCESS) {
			model.showNote(result);
		} else {
			alert(result.message);
		}
	});
}

function listNotesAction (bookId) {
	var url = 'note/list.do';
	var data = {'notebookId':bookId};
	$.getJSON(url,data,function (result) {
		if(result.state==SUCCESS){
			model.updateNotes(result);
		}
	});
}

function listNotebooksAction(){
	var url = "notebook/list.do";
	var userId = getCookie('loginUserId');
	var data = {'userId':userId};
	$.getJSON(url,data,function(result){
		if (result.state==SUCCESS) {
			model.updateNotebooks(result);
		}
	});
}

function logout(){
	delCookie('loginUserId');
	window.location.href="log_in.html";
}
