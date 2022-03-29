window.addEventListener("load", function(){
    // 진입점

    getData() // xml 불러오는거 
    .then(parse) // 가져온 xml 파싱하는거
    .then(view) // 화면에 그려주기

});


// 내 과제 문제점
// 1. js 파일 하나로 할 수 있었음 (심지어 html 파일도..)
// - 이건 몰랐다 
// 2. url 주는거 이름으로 할 수 있었음
// - 지금처럼 index로 하면 깨지기 쉬움
// 3. 페이징 간단하게 할 수 있었음 
// - 지금처럼 하면 너도 에바라는걸 알겠지

// 중요한 거
// api 호출시 에러처리는 필수 !!!! 


let page = 1;
let totalPage;
const pageSize = 5;
const globalItemList = []; // 이렇게 쓰다보면 계속 여기에 추가가되면서 흐름이 좋지 않은데 이 때 async, await 를 사용하게 되면 좋다 

// async funct{
// // const itemList = await getData();
// // // await를 사용하게 되면 바로 getData를 사용할 수 있게 된다 
// // tableGo(itemList.items);
// }





//xml 불러오는 함수

//parsing 하는 함수
//이 함수 안에서 itemList 대신에 globalItemList.push(item) 

//resolve(globalItemList) 리턴 전에 
// globalItemList = locationFilter('서울') 추가


function view(itemList){
    let items = pagenation(itemList);

    // tr 생성해서 하면 된다 

    // tbody = clear(); 
    tbody.innerHtml = ""; 
    // 이렇게하면 element들이 쭉 비게 된다 
    // 물론 child 가져서 그거 삭제해서 해도 됨 

}


function pagenation(itemList){
    let totalRows = itemArray.length;
    totalPage = Math.ceil(totalRows/pageSize);
    let startRow = (page-1) * pageSize;
    let endRow = startRow + pageSize;
    return itemList.slice(startRow, endRow);
}

// 다음 페이지
function nextPage(){
    if(page <totalPage){
        page = page + 1;
    }
}

// 이전 페이지 
function prevPage(){
    if(page>1){
        page = page-1;
    }
}


// 상세페이지에서 '서울'만 보여줄 때
function locationFilter(location){
    const result = []
    for(let i = 0 ; i<globalItemList.length; i++){
        if(globalItemList[i].gubun == 'location'){
            result.push(globalItemList[i].gubun)
        }
    }
    return result;
}