from konlpy.tag import Kkma
kkma = Kkma()
#기본 선언

text = "아버지가 방에 들어갑니다."
#텍스트 입력

morphs = kkma.morphs(text)
#데이터 개량 과정?같습니다.

print(morphs)
#결과 출력

pos = kkma.pos(text)
#데이터 임베딩 과정? morphs와는 다른 형식같습니다.

print(pos)
#출력

nouns = kkma.nouns(text)
print(nouns)
#이부턴 위와 유사합니다.

sentences = "오늘 날씨는 어때요? 내일은 덥다던데."
s = kkma.sentences(sentences)
print(s)