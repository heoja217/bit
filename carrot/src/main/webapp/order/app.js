var currPageNo;
var maxPageNo;
var saveList="";
var aaa;


//$(document).ready(function(){});
$(function() {
	  $('.header').load('../common/header.html');
	  $('.form').load('form.html');
	  $('.footer').load('../common/footer.html');

	loadOrderList(1);

$(document).on('click', '.data-row a', function() {
	loadOrderDetail(1, $(this).attr('data-no'));
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
$(function () {
$('[data-toggle="popover"]').popover()
})
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


function loadOrderList(pageNo, supplierNo, orderBy, category, code, name) {
saveList = orderBy;
if (pageNo <= 0)		pageNo = currPageNo;
if (supplierNo == null)	supplierNo ="";
if (orderBy == null)	orderBy ="";
if (category == null)	category ="";
if (code == null)		code ="";
if (name == null)		name ="";

	
$.getJSON('../json/order/list.do?pageNo=' + pageNo + '&orderBy=' + orderBy
		+ '&category=' + category + '&code=' + code + '&name=' + name, 
function(data) {
	setPageNo(data.currPageNo, data.maxPageNo);
	var orders = data.orders;
	
	require([ 'text!templates/orderClient-table.html' ], function(html) {
		var template = Handlebars.compile(html);

		
		$('#listDiv').html(template(data));
	});
});

}

function loadOrderDetail(pageNo, supplierNo, orderBy, category, code, name) {
saveList = orderBy;
if (pageNo <= 0)		pageNo = currPageNo;
if (supplierNo == null)	supplierNo ="";
if (orderBy == null)	orderBy ="";
if (category == null)	category ="";
if (code == null)		code ="";
if (name == null)		name ="";

	
$.getJSON('../json/order/list.do?pageNo=' + pageNo + '&orderBy=' + orderBy
		+ '&supplierNo=' + supplierNo + '&category=' + category + '&code=' + code + '&name=' + name, 
function(data) {
	setPageNo(data.currPageNo, data.maxPageNo);
	var orders = data.orders;
	
	require([ 'text!templates/order-table.html' ], function(html) {
		var template = Handlebars.compile(html);

		
		$('#form').html(template(data));
	});
});





}

