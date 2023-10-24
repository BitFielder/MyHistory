import sys
sys.path.append('../')
from util.Preprocess import Preprocess

sent = "내일 오후 1시에 짜장면 먹으러 가자 ㅋㅋ"

p = Preprocess(userdic='user_dic.tsv')

pos = p.pos(sent)

ret = p.get_keywords(pos, without_tag=False)
print(ret)

ret = p.get_keywords(pos, without_tag=True)
print(ret)