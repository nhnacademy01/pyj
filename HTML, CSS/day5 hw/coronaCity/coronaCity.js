const serviceKey = "9tCgfIMwqY9z9%2F5P3dO3F%2BM88YVNdYA3xzhMZBuHYn9UeBHvajp68NQXGJAlTDi33ZTOZLUsbKV0mFpTDSpjLg%3D%3D";
let pageCount = 0;
let itemList = [];

// 공공 Data에서 api로 값 가져오는 함수
const promise = new Promise((resolve, reject) => {
    var xhr = new XMLHttpRequest();
    var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson'; /*URL*/
    var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
    const currentDate = toStringByFormatting(new Date())
    console.log(currentDate)
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent(currentDate); /**/
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent(currentDate); /**/
    xhr.open('GET', url + queryParams);
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (this.status == 200) {
                let msg = this.responseXML.getElementsByTagName("resultMsg")[0].innerHTML;
                if (msg == "NORMAL SERVICE.") {
                    resolve(this.responseXML);
                } else {
                    reject(new Error(msg));
                }
            } else if (this.status == 403) {
                reject(new Error("Forbidden"));
            } else if (this.status == 404) {
                reject(new Error("Not Found"));
            } else if (this.status == 500) {
                reject(new Error("Internal Server Error"));
            } else {
                reject(new Error("Unknown Error"));
            }
        }
    };
    xhr.send("");
});

// 공공 Data에서 필요한 값들 저장하기
promise.then((xmlDoc) => {
    let items = xmlDoc.getElementsByTagName("item");

    for (let i = 1; i < items.length - 1; i++) {
        let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
        let gubun = items[i].getElementsByTagName("gubun")[0].innerHTML;
        let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;
        let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;

        let item = {
            createDt, // 등록 날짜
            gubun, // 시도명
            defCnt, // 확진자수
            incDec // 전일대비 증감수
        }
        itemList.push(item);
    }
    itemList = itemList.reverse();

    return itemList;
}).then((itemList) => {
    // getCityData(itemList);
    getDataNext(itemList, 0);
}).catch(error => {
    console.log("error:" + error);
    alert(error);
}).finally(() => {
    console.log("무조건 실행!");
});

// 페이징 넘어가기
function getDataNext(itemList, pageCount) {
    // createDt, // 등록 날짜
    // gubun, // 시도명
    // defCnt, // 확진자수
    // incDec // 전일대비 증감수
    let count = 1;

    // for (item of itemList) {
    for(let i= (pageCount*6); i<17; i++){
        const tr = document.createElement("tr");

        const localTd = document.createElement("a");
        localTd.id = "corona-city-table-td-local";
        localTd.href = "detailCity.html?name=" + ((pageCount*6)+count);

        localTd.tagName = "a href"
        const defCntTd = document.createElement("td");
        const incDecTd = document.createElement("td");
        incDecTd.id = "corona-city-table-td-incDec";

        localTd.textContent = itemList[i].gubun;
        defCntTd.textContent = setComma(itemList[i].defCnt);
        incDecTd.textContent = setPlus(setComma(itemList[i].incDec));

        tr.insertAdjacentElement("beforeend", localTd);
        tr.insertAdjacentElement("beforeend", defCntTd);
        tr.insertAdjacentElement("beforeend", incDecTd);
        const table = document.getElementById("corona-city-table");
        table.insertAdjacentElement("beforeend", tr);
        count += 1;
    }
    beforePage(pageCount)
}

// 페이징 넘어가기용
function beforePage(pageCount) {
    var parent = document.querySelector('#corona-city-table');
    if (pageCount == 0) {
        for (let i = 18; i > 7; i--) {
            parent.removeChild(parent.childNodes[i]);
        }
    } else if (pageCount == 1) {
        for (let i = 18; i > 13; i--) {
            parent.removeChild(parent.childNodes[i]);
        }
        for (let i = 2; i < 8; i++) {
            parent.removeChild(parent.childNodes[2]);
        }

    } else if (pageCount == 2) {
        for (let i = 2; i < 8; i++) {
            parent.removeChild(parent.childNodes[2]);
        }
    }
}

// 페이징 뒤로가기
function getDataBefore(itemList, pageCount) {
    // createDt, // 등록 날짜
    // gubun, // 시도명
    // defCnt, // 확진자수
    // incDec // 전일대비 증감수
    let count = 1;

    console.log(pageCount)
    for(let i= (pageCount*6); i<(pageCount*6)+6; i++){
        console.log(itemList[i].gubun)
        const tr = document.createElement("tr");

        const localTd = document.createElement("a");
        localTd.id = "corona-city-table-td-local";
        localTd.href = "detailCity.html?name=" + ((pageCount*6)+count);

        localTd.tagName = "a href"
        const defCntTd = document.createElement("td");
        const incDecTd = document.createElement("td");
        incDecTd.id = "corona-city-table-td-incDec";

        localTd.textContent = itemList[i].gubun;
        
        defCntTd.textContent = setComma(itemList[i].defCnt);
        incDecTd.textContent = setPlus(setComma(itemList[i].incDec));

        tr.insertAdjacentElement("beforeend", localTd);
        tr.insertAdjacentElement("beforeend", defCntTd);
        tr.insertAdjacentElement("beforeend", incDecTd);
        const table = document.getElementById("corona-city-table");
        table.insertAdjacentElement("beforeend", tr);
        count += 1;
    }
    afterPage(pageCount)
}

// 페이징 뒤로가기용
function afterPage(pageCount) {
    var parent = document.querySelector('#corona-city-table');
    if (pageCount == 1 || pageCount == 0 ) {
        for (let i = 6; i > 1; i--) {
            parent.removeChild(parent.childNodes[i]);
        }
    }
    if ( pageCount == 0 ) {
        parent.removeChild(parent.childNodes[2]);
    }
}


// 페이징 뒤로가기
function before() {
    pageCount -= 1;
    getDataBefore(itemList, pageCount);

}

// 페이징 넘어가기
function next() {
    pageCount += 1;
    getDataNext(itemList, pageCount)

}

// 현재 날짜 문자열 조작 
function toStringByFormatting(source, delimiter = '') {
    const year = source.getFullYear();
    const month = leftPad(source.getMonth() + 1);
    const day = leftPad(source.getDate());
    return [year, month, day].join(delimiter);
}

// 현재 날짜 문자열 조작 
function leftPad(value) {
    if (value >= 10) {
        return value;
    }
    return `0${value}`;
}

function setComma(label) {
    return label.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function setPlus(label) {
    return (label.toString()).concat(" ▲");
}






