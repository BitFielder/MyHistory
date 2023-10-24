const mysql = require('mysql');  // mysql 모듈 로드
const conn = {  // mysql 접속 설정
    host: '112.175.184.59',
    port: '33',
    user: 'ashe152',
    password: 'sniping45!',
    database: 'ashe152'
};

let connection = mysql.createConnection(conn); // DB 커넥션 생성
connection.connect();   // DB 접속
 
sql = "SELECT * FROM testtable";
 
connection.query(sql, function (err, results, fields) { 
    if (err) {
        console.log(err);
        console.log('실패')
    }
    console.log(results);
});
 
 
connection.end(); // DB 접속 종료