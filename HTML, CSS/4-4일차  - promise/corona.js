const serviceKey = "RrGcQbYsc561%2BAzCWcOjbUcajvb49hI5RhNXWaqvYX7%2BBO%2FgxoMt6fDRBnB9CXpR4Xv%2BslSdw4SP%2BvUz4htFWg%3D%3D";
//promise javascript 내장된 내장 객체
//비동기적인 호출을 수행할 때 콜백함수 대신에 유용하게 사용할 수 있는 object
//state(상태)
/**
 * pending : API서버에  호출 중
 * fulfilled : 서버에서 api 호출이 성공
 * rejected : 네트워크 문제 또는 서버 문제가 생기면 
 * 
 */
//성공하면 resolve 호출
//기능을 수행하던 중 실폐하면 resect 호출
//Producer(정보를 제공하는 쪽)
//promise 내부에서 시간이 걸리는 작업들을 진행 -> 비동기적 호출
//promise가 생성되는 순간 실행 됩니다. promise에 전달한 execotur (resolve, reject) 함수가 실행됨 
const promise = new Promise( (resolve, reject) =>{
    const xhr = new XMLHttpRequest();
    const url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"; /*URL*/
    let queryParams = "?" + encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
    queryParams += "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /**/
    queryParams += "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("10"); /**/
    queryParams += "&" + encodeURIComponent("startCreateDt") + "=" + encodeURIComponent("20220301"); /**/
    queryParams += "&" + encodeURIComponent("endCreateDt") + "=" + encodeURIComponent("20220324"); /**/
    xhr.open("GET", url + queryParams);
    xhr.onreadystatechange = function () {
        if(this.readyState == 4){
            if(this.status == 200){
                let msg = this.responseXML.getElementsByTagName("resultMsg")[0].innerHTML;
                if(msg=="NORMAL SERVICE."){
                    resolve(this.responseXML);
                }else{
                    reject(new Error(msg));
                }
            }else if(this.status == 403){
                reject(new Error("Forbidden"));
            }else if(this.status == 404){
                reject(new Error("Not Found"));
            }else if(this.status == 500 ){
                reject(new Error("Internal Server Error"));
            }else{
                reject(new Error("Unknown Error"));
            }
        }
    };
    xhr.send("");
});

//Consumer(정보를 소비하는 쪽) : then, catch, finally 
promise.then((xmlDoc)=>{
    let items = xmlDoc.getElementsByTagName("item");
    let itemList = [];
    for (let i = 0; i < items.length; i++) {
        console.log(items[i]);
        let decideCnt = items[i].getElementsByTagName("decideCnt")[0].innerHTML
        let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML
        let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML
        let seq = items[i].getElementsByTagName("seq")[0].innerHTML
        let stateDt = items[i].getElementsByTagName("stateDt")[0].innerHTML
        let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML

        let item = {
            decideCnt,
            createDt,
            deathCnt,
            seq,
            stateDt,
            updateDt,
        };
        itemList.push(item);
    }
    return itemList;
}).then((itemList)=>{
    plus(itemList);
    show(itemList);
}).catch(error=>{
    console.log("error:" + error);
    alert(error);
}).finally(()=>{
    console.log("무조건 실행!");
});

function plus(itemList){
    
    for (item of itemList) {
        const tr = document.createElement("tr");

        console.log(item);
        const dateTd = document.createElement("td");
        const decideCntTd = document.createElement("td");
        const deathCntTd = document.createElement("td");
        const updateTd = document.createElement("td");
        deathCntTd.textContent = item.deathCnt;
        decideCntTd.textContent = item.decideCnt;
        dateTd.textContent = item.createDt;
        updateTd.textContent = item.updateDt;

        tr.insertAdjacentElement("beforeend", dateTd);
        tr.insertAdjacentElement("beforeend", decideCntTd);
        tr.insertAdjacentElement("beforeend", deathCntTd);
        tr.insertAdjacentElement("beforeend", updateTd);
        const table = document.getElementById("tb1");
        table.insertAdjacentElement("beforeend", tr);
    }
}



function show(itemList) {
    let arr1 = new Array(itemList.length);
    let arr2 = new Array(itemList.length);
    let arr3 = new Array(itemList.length);

    for(let i=0; i < itemList.length; ++i){
        
        arr1[i] = itemList[i].createDt;
        arr2[i] = itemList[i].decideCnt;
        arr3[i] = itemList[i].deathCnt;

    }

    var context = document.getElementById('myChart').getContext('2d');
        var myChart = new Chart(context, {
            type: 'line', // 차트의 형태
            data: { // 차트에 들어갈 데이터
                labels:
                    arr1
                        ,
                datasets: [
                    { //데이터
                        label: '확진자(누적)', //차트 제목
                        fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                        data: 
                            arr2
                        ,
                        backgroundColor: [
                            //색상
                            'rgb(255, 99, 132)',
                        ],
                        borderColor: [
                            //경계선 색상
                            'rgb(255, 99, 132)',
                        ],
                        borderWidth: 1 //경계선 굵기
                    } ,
                    {
                        label: '사망자(누적)', //차트 제목
                        fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                        data:
                            arr3
                        ,
                        backgroundColor: [
                            //색상
                            'rgb(0,0,255)',
                        ],
                        borderColor: [
                            //경계선 색상
                            'rgb(0,0,255)',
                        ],
                        borderWidth: 1 //경계선 굵기
                    }
                ]
            },
            options: {
                scales: {
                    yAxes: [
                        {
                            ticks: {
                                beginAtZero: true
                            }
                        }
                    ]
                }
            }
        });
}