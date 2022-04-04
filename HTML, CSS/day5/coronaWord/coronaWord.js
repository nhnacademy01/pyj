const serviceKey = "9tCgfIMwqY9z9%2F5P3dO3F%2BM88YVNdYA3xzhMZBuHYn9UeBHvajp68NQXGJAlTDi33ZTOZLUsbKV0mFpTDSpjLg%3D%3D";
let pageCount = 0;
let itemList = [];
const googleMap = [];

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
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220325');
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220325');
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

    for (let i = 0; i < items.length; i++) {
        let nationNmEn = items[i].getElementsByTagName("nationNmEn")[0].innerHTML;
        let nationNm = items[i].getElementsByTagName("nationNm")[0].innerHTML;
        let natDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;
        let natDeathCnt = items[i].getElementsByTagName("natDeathCnt")[0].innerHTML;
        let natDeathRate = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;
        let createDt = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;

        let item = {
            nationNmEn,
            nationNm, // 국가
            natDefCnt, // 누적확진자
            natDeathCnt, // 신규확진자
            natDeathRate // 사망률
        }
        itemList.push(item);
    }
    itemList = itemList.reverse();

    return itemList;
}).then((itemList) => {
    getCountryData(itemList);
}).catch(error => {
    console.log("error:" + error);
    alert(error);
}).finally(() => {
    console.log("무조건 실행!");
    getMap(itemList);
});



function getMap(){
    var mapData = ["Country","Popularity"]
    googleMap.push(mapData)
    let count = 0;
    for(item of itemList){
        if(count>9){
            break;
        } 
        mapData = []
        mapData.push(item.nationNmEn)
        mapData.push(parseInt(item.natDeathCnt))
        googleMap.push(mapData)
        count += 1;
    }
    
}

// 페이징 x
function getCountryData(itemList) {
    // nationNm 국가 
    // natDefCnt 누적
    // natDeathCnt 신규 (빨강 화살표)
    // natDeathRate 사망률 (%, 수)
    let count = 1;

    for (item of itemList) {
        const tr = document.createElement("tr");

        const nationNm = document.createElement("a");
        nationNm.id = "corona-country-table-td-local";
        nationNm.href = "coronaWordDetail.html?name=" + count;

        nationNm.tagName = "a href"
        const natDefCnt = document.createElement("td");
        const natDeathCnt = document.createElement("td");
        natDeathCnt.id = "corona-country-table-td-incDec";
        const natDeathRate = document.createElement("td");

        nationNm.textContent = item.nationNm;
        natDefCnt.textContent = setComma(item.natDefCnt);
        natDeathCnt.textContent = setPlus(setComma(item.natDeathCnt));
        natDeathRate.textContent = setPercent(item.natDeathRate);

        tr.insertAdjacentElement("beforeend", nationNm);
        tr.insertAdjacentElement("beforeend", natDefCnt);
        tr.insertAdjacentElement("beforeend", natDeathCnt);
        tr.insertAdjacentElement("beforeend", natDeathRate);
        const table = document.getElementById("corona-country-table");
        table.insertAdjacentElement("beforeend", tr);
        count += 1;
    }
    console.log("끝")
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

function setPercent(label){
    return (label.toString()).slice(0,3)+"%"
}



