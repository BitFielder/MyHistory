from konlpy.tag import Komoran
import numpy as np
komoran = Komoran()
#기본 선언입니다.

text = "오늘 날씨는 구름이 많네요"
#입력값입니다.

nouns = komoran.nouns(text)
print(nouns)

dics = {}
for word in nouns:
    if word not in dics.keys():
        dics[word] = len(dics)
#빈 배열을 선언하고 for문을 통해 배열을 채워줍니다. 

print(dics)
#배열을 보여줍니다.

nb_classes = len(dics)
targets = list(dics.values())
one_hot_targets = np.eye(nb_classes)[targets]
print(one_hot_targets)
#2차원 배열을 만든 것 같은데... 잘 모르겠습니다.