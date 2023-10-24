import streamlit as st
from streamlit_chat import message #app으로 만들어줌
import pandas as pd
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity
import json

#자료 매번 불러올 필요 없이 저장하는 공간..?
@st.cache(allow_output_mutation = True) 

#매번 열어야하는 불편함을 없애줌
def cached_model():
    model = SentenceTransformer('jhgan/ko-sroberta-multitask')
    return model

@st.cache(allow_output_mutation = True)
def get_dataset():
    df = pd.read_csv('wns.csv')
    df['embedding'] = df['embedding'].apply(json.loads)
    return df

model = cached_model()
df = get_dataset()

#제목
st.header('건강 상담 챗봇')

#초기화
if 'generated' not in st.session_state:
    st.session_state['generated'] = []

if 'past' not in st.session_state:
    st.session_state['past'] =[]
    #with문 활용
with st.form('form', clear_on_submit=True):
    user_input = st.text_input('당신: ', '')
    submitted = st.form_submit_button('전송')

if submitted and user_input:
    embedding = model.encode(user_input)
    df['distance'] = df['embedding'].map(lambda x: cosine_similarity([embedding],[x]).squeeze())
    answer = df.loc[df['distance'].idxmax()]

    #대화 내용 저장
    st.session_state.past.append(user_input)
    st.session_state.generated.append(answer['챗봇'])

#user가 입력한 답변에 대해 출력이 되지 않은 msg 찾아서 출력하는 구문..?
for i in range(len(st.session_state['past'])) :
    message(st.session_state['past'][i], is_user=True, key=str(i) + '_user')
    if len(st.session_state['generated']) > i :
        message(st.session_state['generated'][i], key=str(i) + '_bot')