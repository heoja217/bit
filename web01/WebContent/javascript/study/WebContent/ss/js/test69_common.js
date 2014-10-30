"use strict"; 




//window.bit = function(value) {
function bit(value) {
	var element = null;
	if (value.charAt(0) == '#') { // 아이디일 경우,
	  element = document.getElementById(value.substring(1));
	} else if (value.charAt(0) == '<') { // 태그일 경우,
	  element = document.createElement(value.replace(/<|>/g, ''));	
	}
	
	element.text = function(value) {
		this.textContent = value;
		return this;
	};
	
	element.html = function(value) {
		this.innerHTML = value;
		return this;
	};
	
	element.append = function(child) {
		this.appendChild(child);
		return this;
	};
	
	element.appendTo = function(parent) {
		parent.appendChild(this);
		return this;
	};
	
	element.attr = function(name, value) {
		this.setAttribute(name, value);
		return this;
	};
	//리스너의 값이 파라미터로 넘어온다면 리스너를 등록하고 파라미터값이 넘어오지 않는다면 else 이하(클릭 이벤트) 살행해라
	element.click = function(listener) {
		this.onclick = listener;
		return this;
	}
	
	return element;
}

var $ = bit;

// 함수도 객체다! 저장소로 사용될 수 있다.
bit.toYYYYMMDD = function(date) {
	return date.getFullYear() + '-' +
	  (date.getMonth() + 1) + '-' +
	  date.getDate();
};















