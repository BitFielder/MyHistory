from konlpy.tag import Komoran
#기본 import 선언

def word_ngram(bow, num_gram):
    text = tuple(bow)
    ngrams = [text[x:x + num_gram] for x in range(0, len(text))]
    return tuple(ngrams)
#입력문 데이터를 n그램 형식으로 임베딩하는 함수입니다.
#num_gram에 숫자를 몇을 설정하냐에 따라 형식이 바뀝니다.

def phoneme_ngram(bow, num_gram):
    sentence = ' '.join(bow)
    text = tuple(sentence)
    slen = len(text)
    ngrams = [text[x:x + num_gram] for x in range(0, slen)]
    return ngrams
#여기서 쓰이진 않는 것 같습니다. (더미 함수)

def similarity(doc1, doc2):
    cnt = 0
    for token in doc1:
        if token in doc2:
            cnt = cnt + 1
    return cnt/len(doc1)
#임베딩한 두 바이그램의 유사도를 비교하는 함수입니다.

sentence1 = '6월에 뉴턴은 선생님의 제안으로 트리니티에 입학하였다'
sentence2 = '6월에 뉴턴은 선생님의 제안으로 대학교에 입학하였다'
sentence3 = '나는 맛잇는 밥을 뉴턴 선생님과 함께 먹었습니다.'
#입력문을 3개 설정합니다.

komoran = Komoran()
bow1 = komoran.nouns(sentence1)
bow2 = komoran.nouns(sentence2)
bow3 = komoran.nouns(sentence3)
#개량합니다.

doc1 = word_ngram(bow1, 2)
doc2 = word_ngram(bow2, 2)
doc3 = word_ngram(bow3, 2)
#개량한 문장을 2-gram 형식으로 임베딩합니다.

print(doc1)
print(doc2)
print(doc3)
#임베딩한 문장을 출력합니다.

r1 = similarity(doc1, doc2)
r2 = similarity(doc3, doc1)
#유사도를 나타냅니다. r1은 첫번째와 두번째, r2는 세번째와 첫번째 문장을 비교합니다.

print(r1)
print(r2)
#결과를 프린트합니다.
#2-gram 형식은 2개단어 묶음 형식으로 임베딩되기 때문에
#첫번째 문장과 세번째 문장은 "뉴턴"과 "선생님"이란 단어가 공유하지만 유사도는 0으로 표기됩니다.