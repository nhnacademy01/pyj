const serviceKey = "9tCgfIMwqY9z9%2F5P3dO3F%2BM88YVNdYA3xzhMZBuHYn9UeBHvajp68NQXGJAlTDi33ZTOZLUsbKV0mFpTDSpjLg%3D%3D";

// 공공 Data에서 api로 값 가져오는 함수
const promise = new Promise((resolve, reject) => {

    var xhr = new XMLHttpRequest();
    var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson'; /*URL*/
    var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
    // let currentDate = toStringByFormatting(new Date())

    let currentDate = "20220326"
    console.log(currentDate)
    // 여기 왜이러징
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent("20220301"); /**/
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
    // items.reverse;
    console.log(items)
    let cityList = [];

    var index = parseInt(document.location.href.split("=")[1]);

    for (let i = items.length-index-1; i > index; i -= 19) {
        let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
        let gubun = items[i].getElementsByTagName("gubun")[0].innerHTML;
        let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;
        let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;

        let item = {
            createDt, // 등록 날짜
            gubun,
            defCnt, // 확진자수
            incDec // 전일대비 증감수
        }
        cityList.push(item)
    }
    // cityList = cityList.reverse();
    console.log(cityList)

    return cityList;
}).then((cityList) => {
    getCityTitle(cityList[0].gubun)
    getCityData(cityList);
}).catch(error => {
    console.log("error:" + error);
    alert(error);
}).finally(() => {
    console.log("무조건 실행!");
});

function getCityTitle(gubun){
    console.log(gubun)
    const h1 = document.createElement("h1");
    const title = document.createElement("h1");

    title.textContent = gubun +" 코로나 현황";

    h1.insertAdjacentElement("beforeend", title);

    const div = document.getElementById("corona-city-detail-title");
    div.insertAdjacentElement("beforeend", h1);

}

function getCityData(cityList) {
    // createDt, // 등록 날짜
    // gubun, // 시도명
    // defCnt, // 확진자수
    // incDec // 전일대비 증감수

    //원래꺼
    for (item of cityList) {
        const tr = document.createElement("tr");

        const localTd = document.createElement("td");
        const defCntTd = document.createElement("td");
        const incDecTd = document.createElement("td");

        localTd.textContent = toStringByFormatting(item.createDt);
        defCntTd.textContent = setComma(item.defCnt);
        incDecTd.textContent = setPlus(setComma(item.incDec));
        incDecTd.id = "corona-city-detail-incdec";

        tr.insertAdjacentElement("beforeend", localTd);
        tr.insertAdjacentElement("beforeend", (defCntTd));
        tr.insertAdjacentElement("beforeend", (incDecTd));
        const table = document.getElementById("corona-city-detail-table");
        table.insertAdjacentElement("beforeend", tr);

    }

    console.log("끝")
}


// 현재 날짜 문자열 조작 
function toStringByFormatting(label) {
    return label.toString().slice(0,10);
}


function setComma(label) {
    return label.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function setPlus(label) {
    return (label.toString()).concat(" ▲");
}
