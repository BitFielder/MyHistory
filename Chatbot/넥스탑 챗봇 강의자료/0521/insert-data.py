import pymysql
db = None
try:
    db = pymysql.connect(
        host='127.0.0.1',
        user='root',
        passwd='1234',
        db='homestead',
        charset='utf8'
    )
    sql = '''
    INSERT tb_student(name, age, address) values('Kei', 35, 
    'Korea')
    '''     #테이블에 데이터 레코드 하나 추가
    with db.cursor() as cursor:
        cursor.execute(sql)
    db.commit()
except Exception as e:
    print(e)
finally:
    if db is not None:
        db.close()