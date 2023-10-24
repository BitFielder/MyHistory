from gensim.models import Word2Vec

model = Word2Vec.load('nvmc.model')
print("corpus_total_words : ", model.corpus_total_words)
#총 단어 갯수입니다.

print('사랑 : ', model.wv['사랑'])
#사랑이라는 단어의 임베딩 벡터를 나타냅니다. (엄청나게 긺)

print("일요일 = 월요일\t", model.wv.similarity(w1='일요일', w2='월요일'))
#유사도를 비교합니다.
print("안성기 = 배우\t", model.wv.similarity(w1='안성기', w2='배우'))

print("대기업 = 삼성\t", model.wv.similarity(w1='대기업', w2='삼성'))

print("일요일 = 삼성\t", model.wv.similarity(w1='일요일', w2='삼성'))

print("히어로 = 삼성\t", model.wv.similarity(w1='히어로', w2='삼성'))

print(model.wv.most_similar("안성기", topn=5))
#안성기와 가장 유사한 단어 5가지를 출력합니다.

print(model.wv.most_similar("시리즈", topn=5))