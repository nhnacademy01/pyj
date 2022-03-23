
const now = new Date();
let year = now.getFullYear();
let month = (now.getMonth() + 1);
let day = (now.getDate());
let monthDate;
let week = (now.getDay() + 1);
let weekCall;

switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        monthDate = 31;
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        monthDate = 30;
        break;
    default:
        monthDate = 28;
        break;
}


document.write(`<h1>[${year}-${month} My ToDo List]</h1>`)

for (let i = 1; i <= monthDate; i++) {
    document.write(`<table class='calendar'>`);
    document.write(`<tr>`);
    document.write(`<td rowspan="2" class="day">${i}일</td>`);
    document.write(`<td colspan="1"><input type='text' id='text-box${i}'><input type='button' value='등록' id='submit-button' onclick='submit(${i})'></td>`);
    document.write(`<td colspan="1" id="result${i}"></td>`);
    document.write(`</tr>`);
    document.write(`<tr>`);
    document.write(`<td rowspan="2" colspan="1"><input type='button' value='모두삭제' id='delete' onclick='deleteText(${i})'></td>`);
    document.write(`</tr>`);
    document.write(`</table>`)

}

// 버튼 눌렀을 때 텍스트 박스 값 읽어오는거 
function submit(i) {
    let text = document.getElementById('text-box' + i).value;
    localStorage.setItem(i, text);
    let resultArea = document.getElementById("result" + i);

    for (value of todoList) {
        console.log(value)
    }

    for (let i = 0; i < todoList.length; i++) {
        console.log(1111)
        resultArea.innerHTML += `<div id='text${i}'>${todoList[i]}</div>`;
        console.log(todoList[i])
    }
}

// 클릭했을 때 삭제하는 이벤트 
function deleteText(i) {
    let resultArea = document.getElementById("result" + i);
    localStorage.removeItem(i, resultArea)
    resultArea.remove(resultArea);

}

function savedText(i) {
    if (localStorage.key(i)) {
        resultArea.innerHTML += `<div id='text${i}'>${localStorage.getItem(i)}</div>`;
    } else {

    }
}

window.onload = function () {
    let resultArea;
    for (let i = 1; i <= monthDate; i++) {
        resultArea = document.getElementById("result" + i)
        if (localStorage.key(i)) {
            resultArea.innerHTML += `<div id='text${i}'>${localStorage.getItem(i)}</div>`;
        }
    }

};
