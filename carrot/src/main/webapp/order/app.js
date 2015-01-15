var currPageNo;
var maxPageNo;
var saveList="";
var aaa;


//$(document).ready(function(){});
$(function() {
  $('.header').load('../common/header.html');

	$('.form').load('form.html');

		preOrderList(1,supplierNo);

	$(document).on('click', '.data-row a', function() {
		loadOrder($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		deleteOrder($(this).attr('data-no'))
		loadOrder(0);
	});
	
	
	$(document).on('click','#order-category', function(){
		saveList = 'category';
		loadOrderList(1,'category');
	});
	
	$(document).on('click','#order-code', function(){
		saveList = 'code';
		loadOrderList(1,'code');
	});
	
	$(document).on('click','#order-name', function(){
		saveList = 'name';
		loadOrderList(1,'name');
	});
	
});


/*
$('#prevBtn').click(function(event) {
	if (currPageNo > 1) {
		loadOrderList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event) {
	if (currPageNo < maxPageNo) {
		loadOrderList(currPageNo + 1);
	}
});
*/

//paging
function setPageNo(currPageNo, maxPageNo) {
	window.currPageNo = currPageNo;
	window.maxPageNo = maxPageNo;

	if (currPageNo <= 1)
		$('#prevBtn').css('display', 'none');
	else
		$('#prevBtn').css('display', '');

	if (currPageNo >= maxPageNo)
		$('#nextBtn').css('display', 'none');
	else
		$('#nextBtn').css('display', '');
	
	$('#page-selection').bootpag({
	  total: maxPageNo,
	  page: currPageNo,
	  maxVisible: 10 
	}).on('page', function(event, num){
		preOrderList(num, saveList);		
	});

}

var supplierNo;

function preOrderList(no, saveList){
	$.getJSON('/carrot/json/auth/loginUser.do', function(data) {
		supplierNo=data.loginUser.sno;

		loadOrderList(1,supplierNo,saveList);
	});
}

function loadOrderList(pageNo, supplierNo, orderBy, category, code, name) {
	saveList = orderBy;
	if (pageNo <= 0)	pageNo = currPageNo;
	if (supplierNo == null)	supplierNo ="";
	if (orderBy == null)	orderBy ="";
	if (category == null)	category ="";
	if (code == null)	code ="";
	if (name == null)	name ="";

		
	$.getJSON('../json/order/list.do?pageNo=' + pageNo + '&orderBy=' + orderBy
			+ '&supplierNo=' + supplierNo + '&category=' + category + '&code=' + code + '&name=' + name, 
	function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var orders = data.orders;
	  
/*		
		var template = Handlebars.compile(p1);
	  var html = template(
	      {
	        cards: [
	                {name: '홍길동',age: 20,tel: '111-1111'},
	                {name: '임꺽정',age: 30,tel: '111-2222'},
	                {name: '안중근',age: 40,tel: '111-3333'},
	                {name: '윤봉길',age: 50,tel: '111-4444'},
	                {name: '유관순',age: 60,tel: '111-5555'}
	               ]
	      }
	  );
		*/
		
		require([ 'text!templates/order-table.html' ], function(html) {
			var template = Handlebars.compile(html);

			
			$('#listDiv').html(template(data));
		});
	});
	
	

}




/*

$(document).on('click', '#closeModal', function() {
  $('input').val('');
});

$(document).on('click', '#btnCancel', function() {
//$('#btnCancel').click(function(){
	$('.my-update-form').css('display', 'none');
	$('.my-new-form').css('display', '');
  $('input').val('');
	Order = null;
});

$(document).on('click', '#btnDelete', function() {
//$('#btnDelete').click(function(){		
	deleteOrder($('#no').val());
	
});

$(document).on('click', '#btnUpdate', function() {
//$('#btnUpdate').click(function(){

	$('.my-update-form').css('display', '');
	$('.my-new-form').css('display', 'none');
	if (Order.supplierNo == $('#supplierNo').val() &&
			Order.code == $('#code').val() &&
			Order.name == $('#name').val() &&
			Order.url == $('#url').val() &&
			Order.unit == $('#unit').val() &&
			Order.category == $('#category').val() &&
			Order.note == $('#note').val() &&
			Order.priceA == $('#priceA').val() &&
			Order.priceB == $('#priceB').val() &&
			Order.priceC == $('#priceC').val()) {
		alert('변경한것이 없습니다');
		return;
	}

//	if (!validateForm()) return;
	updateOrder(aaa);
});

$(document).on('click', '#btnAdd', function() {
//$('#btnAdd').click(function(){
	$.post('../json/Order/add.do' URL  , 
			{
			no : $('#no').val(),
			supplierNo : $('#supplierNo').val(),
			code : $('#code').val(),
			name : $('#name').val(),
			url : $('#url').val(),
			unit : $('#unit').val(),
			category : $('#category').val(),
			note : $('#note').val(),
			priceA : $('#priceA').val(),
			priceB : $('#priceB').val(),
			priceC : $('#priceC').val()
			}, function(result) {
				if (result.status == "success") {
					loadOrderList(maxPageNo);
					$('#btnCancel').click();
					$('#closeModal').click();
					
				} else {
					alert("등록 실패!");
				}
			} 서버로부터 응답을 받았을 때 호출될 메서드 
			, 'json' 서버가 보낸 데이터를 JSON형식으로 처리 )
			 서버 요청이 실패했을때 호출될 함수 등록 
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
});


function loadOrder(OrderNo) {
	$.getJSON('../json/Order/view.do?no=' + OrderNo, 
			function(data){
		$('#btnCancel').click();
		$('#supplierNo').val(data.Order.supplierNo),
		$('#code').val(data.Order.code),
		$('#name').val(data.Order.name),
		$('#unit').val(data.Order.unit),
		$('#category').val(data.Order.category),
		$('#note').val(data.Order.note),
		$('#priceA').val(data.Order.priceA),
		$('#priceB').val(data.Order.priceB),
		$('#priceC').val(data.Order.priceC),
//		$('#url').val(data.Order.url)

		Order = data.Order;
		aaa = data.Order.no;
		
		$('.my-update-form').css('display', '');
		$('.my-new-form').css('display', 'none');
	});
}

function deleteOrder(OrderNo) {
	$.getJSON('../json/Order/delete.do?no=' + OrderNo, 
			function(data){
		if (data.status == 'success') {
			loadOrderList(0);

			$('#btnCancel').click();
		}
	});
}



function updateOrder(OrderNo) {
	$.post('../json/Order/update.do'
			, {
				no : aaa,
				supplierNo : $('#supplierNo').val(),
				code : $('#code').val(),
				name : $('#name').val(),
				unit : $('#unit').val(),
				category : $('#category').val(),
				note : $('#note').val(),
				priceA : $('#priceA').val(),
				priceB : $('#priceB').val(),
				priceC : $('#priceC').val(),
				url : $('#url').val()
			}, function(result) {
				console.log(result);
				if (result.status == "success") {
					loadOrderList(0);
					$('#btnCancel').click();
					$('#closeModal').click();
				} else {
					alert("변경 실패!");
				}
			}
			, 'json')
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
}

*/
