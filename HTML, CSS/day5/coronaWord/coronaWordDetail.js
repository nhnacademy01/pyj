const serviceKey = "9tCgfIMwqY9z9%2F5P3dO3F%2BM88YVNdYA3xzhMZBuHYn9UeBHvajp68NQXGJAlTDi33ZTOZLUsbKV0mFpTDSpjLg%3D%3D";
let pageCount = 0;
let itemList = [];

// 공공 Data에서 api로 값 가져오는 함수
const promise = new Promise((resolve, reject) => {

    var xhr = new XMLHttpRequest();
    var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson';
    var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey;
    // 주말에는 2022 03 25(금요일)로 테스트
    // 평일에는 currentDate로 
    const currentDate = toStringByFormatting(new Date())
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1');
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10');
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220301');
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent(currentDate);
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

    // nationNm 국가 
    // natDefCnt 누적
    // natDeathCnt 신규 (빨강 화살표)
    // natDeathRate 사망률 (%, 수)
    // stdDay 기준일시

    var index = parseInt(document.location.href.split("=")[1]);

    for (let i = items.length-index; i > index; i-=190) {
        let nationNm = items[i].getElementsByTagName("nationNm")[0].innerHTML;
        let stdDay = items[i].getElementsByTagName("stdDay")[0].innerHTML;
        let natDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;
        let natDeathCnt = items[i].getElementsByTagName("natDeathCnt")[0].innerHTML;
        let natDeathRate = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;

        console.log(nationNm)
        let item = {
            nationNm, // 국가
            stdDay, // 등록 날짜
            natDefCnt,  // 누적 확진자
            natDeathCnt, // 신규 확진자 
            natDeathRate // 전일대비 증감수
        }
        itemList.push(item)
    }

    return itemList;
}).then((itemList) => {
    getCityTitle(itemList[0].nationNm)
    getCityData(itemList);
}).catch(error => {
    console.log("error:" + error);
    alert(error);
}).finally(() => {
    console.log("무조건 실행!");
});

function getCityTitle(nationNm) {
    const h1 = document.createElement("h1");
    const title = document.createElement("h1");

    title.textContent = nationNm + " 코로나 현황";

    h1.insertAdjacentElement("beforeend", title);

    const div = document.getElementById("corona-country-detail-title");
    div.insertAdjacentElement("beforeend", h1);

}

function getCityData(itemList) {
    // nationNm 국가 
    // natDefCnt 누적
    // natDeathCnt 신규 (빨강 화살표)
    // natDeathRate 사망률 (%, 수)
    // stdDay 기준일시

    for (item of itemList) {

        const tr = document.createElement("tr");

        const stdDay = document.createElement("td");
        const natDefCnt = document.createElement("td");
        const natDeathCnt = document.createElement("td");
        const natDeathRate = document.createElement("td");
       
        stdDay.textContent = (toStringByFormatting(item.stdDay));
        natDefCnt.textContent = setComma(item.natDefCnt);
        natDeathCnt.textContent = setComma(item.natDeathCnt);
        natDeathRate.textContent = setPercent(item.natDeathRate);
        
        tr.insertAdjacentElement("beforeend", (stdDay));
        tr.insertAdjacentElement("beforeend", natDefCnt);
        tr.insertAdjacentElement("beforeend", (natDeathCnt));
        tr.insertAdjacentElement("beforeend", (natDeathRate));
        
        const table = document.getElementById("corona-country-detail-table");
        table.insertAdjacentElement("beforeend", tr);

    }

    console.log("끝")
}


// 현재 날짜 문자열 조작 
function toStringByFormatting(label) {
    return label.toString().slice(0, 13);
}


function setComma(label) {
    return label.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function setPercent(label){
    return (label.toString()).slice(0,4)+"%"
}
