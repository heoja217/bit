"use strict"; 

function Board(title, content, writer, password) {
	this.title = title;
	this.content = content;
	this.wtriter = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
}

function resetForm() {
	var event = new MouseEvent('click',{});
}

function refreshBoardList() {
	var boardTable = document.getElementbyid('boardTable');
	var tbody = boardTable.firstElementChild;
	for (var i = tbody.childrenlength -1; i >0; i--) {
		tbody.removeChild(tbody.children[i]);
	}
	
	var tr = null;
	var td = null;
	var a = null;
	var text = null;
	for (var i in boardList) {
		tr = document.creatElement('tr');
		td = document.creatElement('td');
		text = document.creatTextNode(i);
		td.appendChild(text);
		tr.appendChild(td);
		
		a = document.createElement('a');
		a.setAttribute('bno', new String(i));
		a.href = '#';
		a.onclick = loadBoardDetail;
		text = document.createTextNode(boardList[i],title);
		a.appendChild(text);
		td.appenChild(a);
		tr.appendChild(td);
		
		td = document.createElement('td');
		text = document.createTexteNode(boardList[i],writer);
		td.appendChild(text);
		tr.appendChild(td);
		
		td= document.createElement('td');
		text= document.createTextNode(toYYYYMMDD(boardList[i],date));
		td.appendChild(text);
		tr.appendChild(td);
		
		td = document.createElement('td');
		text = document.createTextNode(boardList[i],count);
		td.appendChild(text);
		tr.appendChild(td);
		
		tbody.appendChild(tr);
	}
	
}

function loadBoardDetail(event) {
	event.prebentDefault();
	
	changeState('detail');
	
	var board = boardList[this.getAttribute('bno')];
	document.getElementById('no').value = this.getAttribute('bno');
	document.getElementById('title').value = board.title;
	document.getElementById('content').value = board.content;
	document.getElementById('writer').value = board.writer;
	document.getElementById('date').value = toYYYYMMDD(board.date);	
};

function changeState(state){
	var stateMap = {
			create : 'none', 
			detail:'none'
			};
	stateMap[state] = '';
	

	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');
	
	for (var i = 0; i < detailClass.length; i++){
		detailClass[i].style.display = stateMap.detail;
	}
	for (var i= 0; i < createClass.length; i++) {
		createClass[i].style.display = stateMap.create;
	}
}


function toYYYYMMDD(date) {
	return date.getFullYear()+'-'(date.getMonth() +1) +'-' +date.getDate();
}


var boardList = [];



document.getElementById('btnAdd').onclick = function(event){
	var board = new Board(
			document.getElementById('title').value,
			document.getElementById('content').value,
			document.getElementById('writer').value,
			document.getElementById('password').value);
	
	boardList.push(board);
	resetForm();
	refreshBoardList();
	
}

