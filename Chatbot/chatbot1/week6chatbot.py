import streamlit as st
from streamlit_chat import message      #app으로 만들어줌
import pandas as pd
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity
import json
#기본 선언


@st.cache(allow_output_mutation=True)
def cached_model():
    model = SentenceTransformer('jhgan/ko-sroberta-multitask')
    return model
#자료 매번 불러올 필요 없이 저장하는 공간..?

@st.cache(allow_output_mutation=True)
def get_dataset():
    df = pd.read_json('synopsys_dataset.json')
    return df
#데이터셋 불러오기

model = cached_model()
df = get_dataset()


st.header('6주차 복습 챗봇(영화 시놉시스)')
#제목

if 'generated' not in st.session_state:
        st.session_state['generated'] = []

if 'past' not in st.session_state:
        st.session_state['past'] = []

#if 'context' not in st.session_state:
#        st.session_state['context'] = []
#입력받을 배열 데이터 초기화, context 주석 처리

with st.form('form', clear_on_submit=True):
        user_input = st.text_input('당신 : ','')
        submitted = st.form_submit_button('전송')
#입출력문 생성

if submitted and user_input:
    embedding = model.encode(user_input)

    df['distance'] = df['embedding'].map(lambda x: cosine_similarity([embedding],[x]).squeeze())
    answer = df.loc[df['distance'].idxmax()]
    #임베딩한 코드 적용

    st.session_state.past.append(user_input)
    st.session_state.generated.append(answer['answer'])
    #st.session_state.context.append(context['대기열'])
    #5주차에선 context 답변을 추가했지만 질문과 답변만 받을 것이기 때문에 뺏습니다.
    #질문, 답변 추가


    for i in range(len(st.session_state['past'])):
        message(st.session_state['past'][i], is_user=True, key=str(i) + '_user')
        if len(st.session_state['generated']) > i:
            message(st.session_state['generated'][i], key=str(i) +'_bot')
            #message(st.session_state['context'][i], key=str(i) +'_botContext')
            #context 주석처리
    #user가 입력한 답변에 대해 출력이 되지 않은 msg 찾아서 출력하는 구문