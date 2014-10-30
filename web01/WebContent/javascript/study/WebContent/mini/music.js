"use strict";


var nowNo = 0;

var musicList = [
    {no: 0, music:"mu1.mp3", image:"1st.jpg", title: "포스트맨-신촌을 못가" },
	{no: 1, music:"mu2.mp3", image:"2st.jpg", title: "곽진언-당신만이" },
	{no: 2, music:"mu3.mp3", image:"3st.jpg", title: "Adam Levine (Maroon 5)-Lost Stars" },
	{no: 3, music:"mu4.mp3", image:"4st.jpg", title: "t 윤미래-너를 사랑해" },
	{no: 4, music:"mu5.mp3", image:"5st.jpg", title: "아이언-독기" },
	{no: 5, music:"mu6.mp3", image:"6st.jpg", title: "박보람-예뻐졌다 (Feat. 지코 Of Block B)" },
	{no: 6, music:"mu7.mp3", image:"7st.jpg", title: "NS 윤지-설렘주의" },
	{no: 7, music:"mu8.mp3", image:"8st.jpg", title: "소유-틈" },
	{no: 8, music:"mu9.mp3", image:"9st.jpg", title: "에일리-손대지마" },
	{no: 9, music:"mu10.mp3", image:"10st.jpg", title: "WINNER-공허해" },
	];

function listView(){
	for(var i=0 ; i<musicList.length ; i++) {
		$('<li>')
		.appendTo(list)
		.html((musicList[i].no+1)+'.'+' ')
		.append($('<a>')
				.attr('bno', new String(i))
				.attr('href', '#')
				.click(songPlay)
				.html(musicList[i].title));
		
		console.log(musicList[i]);
		}
	
	}

listView();


function songPlay(event) {
	event.preventDefault();

	var board = musicList[$(this).attr('bno')];
	$('#music').css('display', '');
	document.getElementById('audio').src = board.music;
	document.getElementById('image').src = board.image;
	$('#muTitle').text(board.title);

	nowNo=board.no;
	return nowNo;

}


document.getElementById('nextBtn').onclick = function(event) {
	nowNo++;
	if (nowNo>=musicList.length){
		alert('목록의 마지막 곡입니다');
		nowNo--;
	} else {
		document.getElementById('audio').src = musicList[nowNo].music;
	
	document.getElementById('image').src = musicList[nowNo].image;
	$('#muTitle').text(musicList[nowNo].title);
	}

};

document.getElementById('prevBtn').onclick = function(event) {
	nowNo--;	
	if (nowNo<0){
		alert('플레이리스트의 첫 곡입니다');
		nowNo++;
	} else {
		document.getElementById('audio').src = musicList[nowNo].music;
	
	document.getElementById('image').src = musicList[nowNo].image;
	$('#muTitle').text(musicList[nowNo].title);
	}

}
