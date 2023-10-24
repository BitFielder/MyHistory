import pymysql
db = None

# 아나콘다 파이썬을 통해 SQL을 연결하는 코드
# 거의 모든 SQL 파이썬 구문에 이 문장이 사용됩니다.
try:
    db = pymysql.connect(
        host='127.0.0.1',
        user='root',
        passwd='1234',
        db='homestead',
        charset='utf8'
    )
    print("DB 연결 성공")
except Exception as e:
    print(e)
finally:
    if db is not None:
        db.close()
        print("DB 연결 닫기 성공")