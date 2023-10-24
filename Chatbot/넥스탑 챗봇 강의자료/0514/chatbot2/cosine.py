from konlpy.tag import Komoran
import numpy as np
from numpy import dot
from numpy.linalg import norm
#기본 선언입니다. numpy를 비롯한 부가적인 기능을 추가하였습니다.

def cos_sim(vec1, vec2):
    return dot(vec1, vec2) / (norm(vec1) * norm(vec2))
#

def make_term_doc_mat(sentence_bow, word_dics):
    freq_mat = {}
    for word in word_dics:
        freq_mat[word] = 0
    for word in word_dics:
        if word in sentence_bow:
            freq_mat[word] += 1
    return freq_mat
#임베딩하기 쉽게 처리하는 함수..?

def make_vector(tdm):
    vec = []
    for key in tdm:
        vec.append(tdm[key])
    return vec
#문장의 유사도를 코사인 형식으로 비교하는 것 같습니다.

sentence1 = '6월에 뉴턴은 선생님의 제안으로 트리니티에 입학하였다'
sentence2 = '6월에 뉴턴은 선생님의 제안으로 대학교에 입학하였다'
sentence3 = '나는 맛잇는 밥을 뉴턴 선생님과 함께 먹었습니다.'
#입력문 선언입니다.

komoran = Komoran()
#개량 형식입니다.

bow1 = komoran.nouns(sentence1)
bow2 = komoran.nouns(sentence2)
bow3 = komoran.nouns(sentence3)
bow = bow1 + bow2 + bow3
#입력문들을 각각 개량합니다, 또한 for문 실행용 배열을 만듭니다.

word_dics = []
for token in bow:
    if token not in word_dics:
        word_dics.append(token)
#배열을 선언하고 개량한 입력문들을 각각 배열에 추가합니다.

freq_list1 = make_term_doc_mat(bow1, word_dics)
freq_list2 = make_term_doc_mat(bow2, word_dics)
freq_list3 = make_term_doc_mat(bow3, word_dics)
#문장 별로 임베딩하기 쉽게 처리하는 같습니다.

print(freq_list1)
print(freq_list2)
print(freq_list3)
#처리한 문장을 출력합니다.

doc1 = np.array(make_vector(freq_list1))
doc2 = np.array(make_vector(freq_list2))
doc3 = np.array(make_vector(freq_list3))
#입력문 별로 임베딩합니다.

r1 = cos_sim(doc1, doc2)
r2 = cos_sim(doc3, doc1)
#첫번째와 두번째 문장의 유사도를 비교합니다.

print(r1)
print(r2)
#마지막으로 출력합니다.