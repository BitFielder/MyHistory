from gensim.models import Word2Vec
from konlpy.tag import Komoran
import time
#선언입니다.

def read_review_data(filename):
    with open(filename, 'r', encoding='UTF-8') as f:
        data = [line.split('\t') for line in
f.read().splitlines()]
        data = data[1:] 
    return data
#데이터 읽기 함수입니다.

start = time.time()
#현재 시간입니다. (실행 시 초기 시간)

print('1) 말뭉치 데이터 읽기 시작')
review_data = read_review_data('./ratings.txt')
#텍스트에서 데이터를 받아옵니다.

print(len(review_data))
print('1) 말뭉치 데이터 읽기 완료: ', time.time() - start)
#위의 과정에서 걸린 시간을 나타내줍니다. (초기 시간에서 현재 시간을 뺍니다.)

print('2) 형태소에서 명사만 추출 시작')
komoran = Komoran()
docs = [komoran.nouns(sentence[1]) for sentence in review_data]
print('2) 형태소에서 명사만 추출 완료: ', time.time() - start)
#지금까지에서 komoran 과정으로 데이터를 추출하고, 시간을 나타냅니다.
#출력 시간은 초기 시간과 현재시간을 비교하는 것이라서 데이터 읽는 시간이 포함됩니다.

print('3) word2vec 모델 학습 시작')
model = Word2Vec(sentences=docs, vector_size=200, window=4, min_count=2, sg=1)
#모델 학습 코드입니다.
print('3) word2vec 모델 학습 완료: ', time.time() - start)


print('4) 학습된 모델 저장 시작')
model.save('nvmc.model')
#모델을 저장하는 코드입니다.
print('4) 학습된 모델 저장 완료: ', time.time() - start)

print("corpus_count : ", model.corpus_count)
#데이터를 가져온 총 횟수입니다
print("corpus_total_words : ", model.corpus_total_words)
#단어의 총 횟수입니다.