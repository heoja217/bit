"use strict"; 

//목표: 라이브러리화5 
//val() 함수에 읽기 기능 추가
//삭제, 변경 버튼의 리스너 추가
//bit() 함수를 변경 => querySelectorAll()을 사용하여 처리.



changeState('create');

function changeState(state) {
	var stateMap = {
			create: 'none',
			detail: 'none'
	};

	stateMap[state] = '';

	$('.detail').css('display', stateMap.detail);
	$('.create').css('display', stateMap.create);
}

//게시글을 저장하는 객체 생성자 함수
function Board(title, content, writer, password) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
}

function resetForm() {
	$('#btnCancel').click();
}

var boardList = [];

$('#btnCancel').click(function(event) {
	changeState('create');
});

$('#btnAdd').click(function(event) {
	var board = new Board(
			$('#title').val(),
			$('#content').val(),
			$('#writer').val(),
			$('#password').val());

	boardList.push(board);

	resetForm();

	refreshBoardList();
});

$('#btnDelete').click(function(event){
	var no = $('#no').val();
	boardList.splice(no,1);
	refreshBoardList();
	resetForm();
});

$('#btnChange').click(function(event){
	var no = $('#no').val();
	var board = boardList[no];
	board.title = $('#title').val();
	board.content = $('#content').val();
	refreshBoardList();
});

function refreshBoardList() {
	var boardTable = $('#boardTable');
	
	$('.dataRow').remove();

	for (var i in boardList) {
		$('<tr>')
			.appendTo(boardTable)
			.attr('class', 'dataRow')
			.append($('<td>').html(i))
			.append($('<td>')
					.append($('<a>')
							.attr('bno', new String(i))
							.attr('href', '#')
							.click(loadBoardDetail)
							.html(boardList[i].title)))
			.append($('<td>').html(boardList[i].writer))
			.append($('<td>').html($.toYYYYMMDD(boardList[i].date)))
			.append($('<td>').html(boardList[i].count));
			
	}
}

function loadBoardDetail(event) {
	event.preventDefault();

	changeState('detail');

	var board = boardList[$(this).attr('bno')];
	$('#no').val($(this).attr('bno'));
	$('#title').val(board.title);
	$('#content').val(board.content);
	$('#writer').val(board.writer);
	$('#date').val($.toYYYYMMDD(board.date));
}















