import requests

token = '5700717380:AAGUt03PyuWn331mULUdFQDdyEslL1dcraQ'
chat_id = 5265615675
#API 코드, 챗 아이디는 직접 넣어야합니다.
bot_message = "hello"
url = f'https://api.telegram.org/bot{token}/sendMessage?chat_id={chat_id}&text={bot_message}'
requests.get(url)
#텔레그램의 기존에 만들었던 챗봇에 hello라고 답변하기