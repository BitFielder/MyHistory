import requests
import pandas as pd
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity
import json
#선언

token = '5700717380:AAGUt03PyuWn331mULUdFQDdyEslL1dcraQ'
chat_id = 5265615675
#토큰(챗봇 api) 404 오류 시 일반적으로 이쪽에 문제가 있습니다.

def cached_model():
    model = SentenceTransformer('jhgan/ko-sroberta-multitask')
    return model
#기본 선언..? 함수

def get_dataset():
    df = pd.read_csv('wns.csv')
    df['embedding'] = df['embedding'].apply(json.loads)
    return df
#데이터 불러오기

model = cached_model()
df = get_dataset()
#함수 실행

last_update_id = None
#아이디 값 선언/초기화

while True:
    url = f"https://api.telegram.org/bot{token}/getUpdates"
    if last_update_id:
        url += f"?offset={last_update_id + 1}"
    response = requests.get(url)
    if response.status_code != 200:
        continue
#유저가 입력한 대화 정보를 받아오기 위해 아이디 값 찾기

    data = response.json()

    for update in data["result"]:
        text = update["message"]["text"]
        chat_id = update["message"]["chat"]["id"]
        update_id = update["update_id"]
    #json data에서 text, chat_id, update_id 추출
    #맨 위의 while문 안에 이어서 계속 작성합니다.
        last_update_id = update_id

        embedding = model.encode(text)
        df['distance'] = df['embedding'].map(lambda x:cosine_similarity([embedding], [x]).squeeze())
        answer = df.loc[df['distance'].idxmax()]
        #질문 데이터 임베딩

        bot_message = answer['챗봇']

        print(answer['distance'])
        print(answer['유저'])
        print(answer['챗봇'])
        #여기까지는 5주차때 했던 streamlit 코드 참조해서 사용

        url = f"https://api.telegram.org/bot{token}/sendMessage?chat_id={chat_id}&text={bot_message}"
        requests.get(url)
        #Telegram을 통해 출력