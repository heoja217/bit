"use strict";

function bit(value) {
	var element = null;
	if (value instanceof Element) {
		element=value;
	} else if(value.charAt(0)== '#') {
		element = document.getElementById(value.substring(1));
	} else if(value.charAt(0)== '#') {
		element = document.createElementById(value.replace(/<|>/g, ''));
	}
	}
	
}