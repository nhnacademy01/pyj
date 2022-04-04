
// // url 이동
// // 웹에서 파라미터값 넘길러면 

// // indexedDB.html?location=서울
// // 그냥 이렇게 넘기면 한글이 깨진다

// const local='서울';
// console.log("encode:" + encodeURIComponent(local));
// console.log("decode:" + decodeURIComponent("%EC%84%9C%EC%9A%B8"));


// //현제 주소값 구하기
// console.log("location.href=" + location.href);

// const paramsString = "?local=%EC%84%9C%EC%9A%B8";
// const  searchParams = new URLSearchParams(paramsString);
// let local = searchParams.get("local");
// console.log("local=" + local);



// // 페이징
// const pageSize=5;
//     const itemArray = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22];

//     function pagination(page = 1){
//         let totalRows = itemArray.length;
//         let startRow = (page -1) * pageSize;
//         let endRow = startRow + pageSize;

//         console.log("startRow:" + startRow);
//         console.log("endRow:" + endRow);
//         console.table(itemArray.slice(startRow, endRow));
//     }

//     pagination(1);
//     pagination(2);
//     pagination(3);
//     pagination(4);
//     pagination(5);