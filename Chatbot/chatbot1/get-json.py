import requests
import json

token = '5700717380:AAGUt03PyuWn331mULUdFQDdyEslL1dcraQ'
chat_id = 5265615675
bot_message = "hello"
url = f"https://api.telegram.org/bot{token}/getUpdates"
data = requests.get(url).json()
print(url)
#텔레그램의 기존에 만들었던 챗봇에서 자신이 쓴 채팅기록 내용

with open('chat.json', 'w', encoding='utf-8') as file:
    json.dump(data, file, indent="\t", ensure_ascii=False)
#채팅기록 가져오기
