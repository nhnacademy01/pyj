let serviceKey = "9tCgfIMwqY9z9%2F5P3dO3F%2BM88YVNdYA3xzhMZBuHYn9UeBHvajp68NQXGJAlTDi33ZTOZLUsbKV0mFpTDSpjLg%3D%3D";

var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220310'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220315'); /**/
xhr.open('GET', url + queryParams);

let itemList = [];
fetch(url + queryParams)
    .then(response => response.text())
    .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
    .then(data => data.getElementsByTagName("item"))
    .then(function (items) {
        for (let i = 0; i < items.length; i++) {
            let accDefRate = items[i].getElementsByTagName("accDefRate")[0].innerHTML;
            let accExamCnt = items[i].getElementsByTagName("accExamCnt")[0].innerHTML;
            let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
            let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML;
            let seq = items[i].getElementsByTagName("seq")[0].innerHTML;
            let stateDt = items[i].getElementsByTagName("stateDt")[0].innerHTML;
            let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML;

            let item = {
                accDefRate,
                accExamCnt,
                createDt,
                deathCnt,
                seq,
                stateDt,
                updateDt
            }
            itemList.push(item);

        }
        itemList = itemList.reverse();

        let dateCountRaw = []
        let dateCount = []
        let deathCnt = []
        let accDefRate = []
        let update = []
        for (let i = 0; i < 6; i++) {
            dateCountRaw.push(itemList[i].createDt)
            dateCount.push(itemList[i].createDt.slice(0, 11))
            deathCnt.push(itemList[i].deathCnt)
            accDefRate.push(Math.floor(itemList[i].accDefRate * 1000000))
            update.push(itemList[i].updateDt)
        }

        addTable();
        function addTable() {
            var table = document.getElementById('table-body');
            for (let i = 0; i < 6; i++) {
                var row = `<tr>
                            <td>${dateCountRaw[i]}</td>
                            <td>${accDefRate[i]}</td>
                            <td>${deathCnt[i]}</td>
                            <td>${update[i]}</td>
                            </tr>`
                table.innerHTML += row
            }

        }

        // 차트 js
        var context = document
            .getElementById('myChart')
            .getContext('2d');
        var myChart = new Chart(context, {
            type: 'line', // 차트의 형태
            data: { // 차트에 들어갈 데이터
                labels: dateCount,
                datasets: [
                    { //데이터
                        label: '확진자(누적)', //차트 제목
                        fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
                        data: accDefRate,
                        backgroundColor: 'rgba(255, 0, 0, 0.7)',
                        borderColor: 'rgba(255,0,0, 0.7)',
                        borderWidth: 1 //경계선 굵기
                    },
                    {
                        label: '사망자(누적)',
                        type: 'line',
                        fill: false,
                        data: deathCnt,
                        backgroundColor: 'rgb(0, 0, 255, 0.7)',
                        borderColor: 'rgb(0, 0, 255, 0.7)'
                    }
                ]
            },
            options: {
                tooltips: {
                    mode: 'label',
                    label: 'mylabel',
                },
                scales: {
                    yAxes: [
                        {
                            ticks: {
                                beginAtZero: true,
                                max: 10000000,
                                callback: function (label, index, labels) { return label.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","); }
                            }
                        }
                    ]
                }
            }
        });

    }

    ).catch((error) => { console.log(error) });