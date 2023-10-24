from konlpy.tag import Komoran
komoran = Komoran(userdic='./user_dic.tsv')
#기본 선언입니다. 일부 단어 묶음 규칙을 추가하는데 user_dic.tsv를 참조합니다.

text = "자연어처리는 엔엘피라고 한다."
text2 = "나 저번주에 스즈메의 문단속을 봤어."
#입력문입니다.

pos = komoran.pos(text)
pos2 = komoran.pos(text2)
#komoran 형식으로 개량합니다.

print(pos)
print(pos2)
#출력합니다.