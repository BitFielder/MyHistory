from konlpy.tag import Okt
okt = Okt()
#기본 선언, Okt 형식입니다.

text = "아버지가 방에 들어갑니다."
#입력값
morphs = okt.morphs(text)
print(morphs)

pos = okt.pos(text)
print(pos)

nouns = okt.nouns(text)
print(nouns)

text = "오늘 날씨가 좋아요ㅎㅎ~"
#입력값을 이렇게 변경합니다.

print(okt.normalize(text))
#위의 개량 과정 두 줄을 한 줄으로 간결화시켰습니다.
print(okt.phrases(text))