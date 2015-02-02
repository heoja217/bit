var currPageNo;
var maxPageNo;
var sno;
$(function() {
	$('.header').load('../common/header.html');
	$('.form').load('form.html');
	$('.footer').load('../common/footer.html');
	loadDeliveryList(1);
	$(document).on('click', '.data-row a', function() {
		loadDeliveryList($(this).attr('data-no'));
	});

});

$('#prevBtn').click(function(event) {
	if (currPageNo > 1) {
		loadDeliveryList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event) {
	if (currPageNo < maxPageNo) {
		loadDeliveryList(currPageNo + 1);
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

function loadDeliveryList(pageNo, sno) {
	if (pageNo <= 0)
		pageNo = currPageNo;

	$.getJSON('../json/delivery/list.do?pageNo=' + pageNo, function(data) {
		setPageNo(data.currPageNo, data.maxPageNo);
		var deliverys = data.deliverys;

		require([ 'text!templates/delivery-table.html' ], function(html) {
			var template = Handlebars.compile(html);
			$('#listDiv').html(template(data));
			//console.log("deliverys : " + deliverys);
		});
	});
}

