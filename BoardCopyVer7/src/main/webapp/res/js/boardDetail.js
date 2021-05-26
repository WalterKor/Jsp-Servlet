var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');





function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;	
	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};	
	regAjax(param);
}

//서버에게 등록해줘~~~
function regAjax(param) {
	const init = {
		method: 'POST',				
	    body: new URLSearchParams(param)
	};
	
	fetch('cmtInsSel', init)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		switch(myJson.result) {
			case 0:
				alert('등록 실패!');
			break;
			case 1:
				cmtFrmElem.cmt.value = '';
				
				getListAjax();
			break;
		}
	});		
}

//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		makeCmtElemList(myJson);
	});
}

function makeCmtElemList(data) {
	
	cmtListElem.innerHTML = '';
	
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');
	
	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';
	
	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);
	
	tableElem.append(trElemTitle);	
	cmtListElem.append(tableElem);
	
	var loginUserPk = cmtListElem.dataset.login_user_pk;
	
	
	
	data.forEach(function(item) {
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');
		
		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);
		
		if(parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';
			
			delBtn.addEventListener('click' , function(){
				//closer
				delAjax(item.icmt);
			});
			
			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}
		
		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);
		
		tableElem.append(trElemCtnt);
	});

	function delAjax(icmt){
		//Promise객체라서 사용하기위해서
		fetch('cmtDelUpd?icmt=' +icmt)
		.then(function(res){
			return res.json();
		})
		.then(function(myJson){
			console.log(myJson);
			
			switch(myJson.result){
				case 0:
					alert('삭제에 실패했습니다.');
				break;
				
				case 1:
					getListAjax(); //다시찍는다.
				break;
				
			
			}
			
		});
	}
		
}


getListAjax(); //이 파일이 임포트되면 함수 1회 호출!



