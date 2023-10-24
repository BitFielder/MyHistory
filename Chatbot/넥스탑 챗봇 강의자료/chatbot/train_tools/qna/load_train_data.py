import pymysql
import openpyxl
import sys
sys.path.append('../../')
from config.DatabaseConfig import *

def all_clear_train_data(db):
    sql = '''
        delete from chatbot_train_data
    '''
    with db.cursor() as cursor:
        cursor.execute(sql)
        
    sql = '''
        ALTER TABLE chatbot_train_data AUTO_INCREMENT=1
    '''
    with db.cursor() as cursor:
        cursor.execute(sql)
        
    #db에 저장
def insert_data(db, xls_row):
    intent, ner, query, answer, answer_img_url = xls_row
        
    sql = '''
        INSERT chatbot_train_data(intent, ner, query, answer, answer_image)
        values(
            '%s', '%s', '%s', '%s', '%s'
        )
    ''' % (intent.value, ner.value, query.value, answer.value, answer_ima_url.value)
        
    sql = sql.replace("'None'", "null")
        
    with db.cursor() as cursor:
        cursor.execute(sql)
        print('{} 저장'.format(query.value))
        db.commit()
            
train_file = './train_data.xlsx'
db = None
try:
    db = pymysql.connect(
        host='127.0.0.1',
        user='root',
        passwd='1234',
        db='homestead',
        charset='utf8'
    )
            
    all_clear_train_data(db)
            
    wb = openpyxl.load_workbook(train_file)
    sheet = wb['Sheet1']
    for row in sheet.iter_rows(min_row=2):
        insert_data(db, row)
                
    wb.close()
            
except Exception as e:
        print(e)
            
finally:
    if db is not None:
        db.close()