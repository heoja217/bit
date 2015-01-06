var currPageNo;
var maxPageNo;


//$(document).ready(function(){});
$(function() {
	$('.form').load('form.html');
	
	loadGoodsList(1);

	$(document).on('click', '.data-row a', function() {
		loadGoods($(this).attr('data-no'));
	});

	$(document).on('click', '.my-delete-btn', function() {
		deleteGoods($(this).attr('data-no'))
		loadGoods(0);
	});
});

$('#prevBtn').click(function(event) {
	if (currPageNo > 1) {
		loadGoodsList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event) {
	if (currPageNo < maxPageNo) {
		loadGoodsList(currPageNo + 1);
	}
});

function setPageNo(currPageNo, maxPageNo) {
	window.currPageNo = currPageNo;
	window.maxPageNo = maxPageNo;

	$('#pageNo').html(currPageNo);

	if (currPageNo <= 1)
		$('#prevBtn').css('display', 'none');
	else
		$('#prevBtn').css('display', '');

	if (currPageNo >= maxPageNo)
		$('#nextBtn').css('display', 'none');
	else
		$('#nextBtn').css('display', '');
}

function loadGoodsList(pageNo) {
	if (pageNo <= 0)
		pageNo = currPageNo;
	$.getJSON('../json/goods/list.do?pageNo=' + pageNo, 
	function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var goodss = data.goodss;
		
		require([ 'text!templates/goods-table.html' ], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
		});
	});
}

/*

$('#btnCancel').click(function(){
	$('.my-update-form').css('display', 'none');
	$('.my-new-form').css('display', '');
	//goods = null;
});

$('#btnDelete').click(function(){		
	deleteGoods($('#no').val());
});

$('#btnUpdate').click(function(){
	if (goods.name == $('#name').val() &&
			goods.quantity == $('#quantity').val() &&
			goods.makerNo == $('#makerNo').val() &&
			yyyyMMdd(goods.madeDate) == $('#madeDate').val()) {
		alert('변경한것이 없습니다');
		return;
	}
	if (!validateForm()) return;

	updateGoods($('#no').val());
});


$('#btnAdd').click(function(){
	$.post('../json/goods/add.do' URL 
			,{
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
					loadGoodsList(-1);
					$('#btnCancel').click();

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


function loadGoods(goodsNo) {
	$.getJSON('../json/goods/view.do?no=' + goodsNo, 
			function(data){
		$('#btnCancel').click();
		$('#no').val(data.goods.no);
		//console.log(data);
		$('#name').val(data.goods.name);
		$('#quantity').val(data.goods.quantity);
		$('#makerNo').val(data.goods.makerNo);
		if (data.goods.madeDate) {
			$('#madeDate').val(yyyyMMdd(data.goods.madeDate));
		}

		goods = data.goods;

		$('.my-update-form').css('display', '');
		$('.my-new-form').css('display', 'none');
	});
}

function deleteGoods(goodsNo) {
	$.getJSON('../json/goods/delete.do?no=' + goodsNo, 
			function(data){
		if (data.status == 'success') {
			loadGoodsList(0);

			$('#btnCancel').click();
		}
	});
}



function updateGoods(goodsNo) {
	$.post('../json/goods/update.do'
			, {
				no : $('#no').val(),
				name : $('#name').val(),
				quantity : $('#quantity').val(),
				makerNo : $('#makerNo').val(),
				madeDate : $('#madeDate').val(),
				photofile2 : $('#photofile').val()
			}, function(result) {
				if (result.status == "success") {
					loadGoodsList(0);
				} else {
					alert("변경 실패!");
				}
			}
			, 'json')
			.fail(function(jqXHR, textStatus, errorThrown){
				alert(textStatus + ":" + errorThrown);
			});
}*/