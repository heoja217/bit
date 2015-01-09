function checkPwd() { //비밀번호 유효성검사
	var swanpwd1 = document.getElementById("inputPassword3").value;
	var swanpwd2 = document.getElementById("inputPassword3_check").value;

	if (swanpwd1 == null || swanpwd1.length == 0) {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "비밀번호를 입력해주세요.";
	} else if (swanpwd1.length < 6 || swanpwd2.length < 6) {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "비밀번호 6자 이상 입력하세요.";

	} else if (swanpwd1 != swanpwd2) {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "비밀번호가 일치하지 않습니다.";
	} else if (swanpwd1 == swanpwd2) {
		document.getElementById('checkPwd').style.color = "blue";
		document.getElementById('checkPwd').innerHTML = "비밀번호가 확인되었습니다.";
	} else {
		document.getElementById('checkPwd').innerHTML = "&nbsp";
	}

}

$(function() {
	$("#inputId").keyup(function() { //아이디 유효성검사
		$.get("http://localhost:3000/idcheck", {
			id : $('#inputId').val()
		}, function(data) {
			$('#checkMsg').html(data.result);
			if (data.result == "사용가능 한 아이디입니다.") {
				$('#checkMsg').css("color", "blue");
			} else if (data.result == "중복 된 아이디가 존재합니다.") {
				$('#checkMsg').css("color", "red");
			} 
		});
	});
})
function checkId() {
	var swanid = document.getElementById("inputId").value;
/*	var space = checkSpace(swanid);
	var chk_num = swanid.search(/[0-9]/g); 
    var chk_eng = swanid.search(/[a-z]/ig); 
    var Special = swanid.search(/[`~!@#$%^&*|\\\'\";:\/?]/gi);

    

	function checkSpace(str) {
		if (str.search(/\s/) != -1) {
			
			return true;
		}
	}
	if(space){
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "공백을 사용할 수 없습니다.";
	}
	if(Special<1){
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "특수문자를 사용할 수 없습니다.";
	}*/

	if (swanid == null || swanid.length == 0) {
		document.getElementById('checkMsg').style.color = "red";
		document.getElementById('checkMsg').innerHTML = "아이디를 입력해주세요.";
	} else {
		document.getElementById('checkMsg').innerHTML = "&nbsp";
	}
}




function checkCompanyName() { //상호명 유효성검사
	var swanname = document.getElementById("inputCompanyName").value;
	if (swanname == null || swanname.length == 0) {
		document.getElementById('checkCompanyName').style.color = "red";
		document.getElementById('checkCompanyName').innerHTML = "상호명을 입력해주세요.";
	} else {
		document.getElementById('checkCompanyName').innerHTML = "&nbsp";
	}
}
function checkCompanyNum() { //사업자번호 유효성검사

	var companyNum = document.getElementById('inputCompanyNum');

	var re = /^[0-9]+$/;
	if (!re.test(companyNum.value)) {
		document.getElementById('checkCompanyNum').style.color = "red";
		document.getElementById('checkCompanyNum').innerHTML = "숫자만 입력해주세요.";
//		companyNum.value = "";
//		return;
	} else {
		document.getElementById('checkCompanyNum').innerHTML = "&nbsp";
	}
}
function checkPhoneNum() { //전화번호 유효성검사
	var phoneNum = document.getElementById('inputPhoneNum');

	var re = /^[0-9]+$/;
	if (!re.test(phoneNum.value)) {
		document.getElementById('checkPhoneNum').style.color = "red";
		document.getElementById('checkPhoneNum').innerHTML = "숫자만 입력해주세요.";
		/*phoneNum.value = "";*/
		
	} else {
		document.getElementById('checkPhoneNum').innerHTML = "&nbsp";
	}
}

$(function() {
	$('#btnSelect').click(function() {
		if ($('#inputId').val().length == 0) {
			alert('아이디 입력은 필수 입력 항목입니다.');
			return false;
		} else if ($('#inputPassword3').val().length == 0) {
			alert('비밀번호 입력은 필수 입력 항목입니다.');
			return false;
		} else if ($('#inputPassword3_check').val().length == 0) {
			alert('비밀번호 입력은 필수 입력 항목입니다.');
			return false;
		} else if ($('#inputCompanyName').val().length == 0) {
			alert('상호 입력은 필수 입력 항목입니다.');
			return false;
		}
		$.post('../json/auth/signup.do' /* URL */
		, { /* 서버에 보낼 데이터를 객체에 담아 넘긴다 */
			sid : $('#inputId').val(),
			spwd : $('#inputPassword3').val(),
			stel : $('#inputPhoneNum').val(),
			scname : $('#inputCompanyName').val(),
			sname : $('#inputRepresentative').val(),
			spostno : $('#post1').val() + " - " + $('#post2').val(),
			saddr : $('#addr').val(),
			saddr_det : $('#addr2').val(),
			sbno : $('#inputCompanyNum').val(),
			smemo : $('#inputIntroduce').val()

		}, function(resultMap) { /* 서버로부터 응답을 받았을 때 호출될 메서드*/
			if (resultMap.status == "success") {
				alert("회원가입이 완료 되었습니다.");
				location.href = '../auth/Web_login.html';
			} else {

			}
		}, 'json' /* 서버가 보낸 데이터를 JSON 형식으로 처리*/)
		/* 서버 요청이 실패했을 때 호출될 함수 등록*/
		.fail(function(jqXHR, textStatus, errorThrown) {
			alert(textStatus + ":" + errorThrown);
		});
	});

})