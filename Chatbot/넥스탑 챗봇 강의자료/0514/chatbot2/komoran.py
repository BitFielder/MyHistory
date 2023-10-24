from konlpy.tag import Komoran
komoran = Komoran()
#기본 선언, 이번엔 Komoran이라는 외부 함수를 사용합니다.

text = "아버지가 방에 들어갑니다."
#텍스트 입력값
morphs = komoran.morphs(text)
print(morphs)
#kkma와 마찬가지로 입력값을 개량합니다.
#단순히 문장을 형식에 맞게 쪼개는 형식이라서 임베딩과는 거리가 있습니다.

pos = komoran.pos(text)
print(pos)
#형식이 달라졌을 뿐 위의 개량 과정과 유사합니다.
nouns = komoran.nouns(text)
print(nouns)