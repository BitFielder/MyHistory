import logo from './logo.svg';
import './App.css';
import React from 'react';
import { createGlobalStyle } from 'styled-components';
import Template from './components/Template';
import Head from './components/Head';
import List from './components/List';
import Create from './components/Create';
import { TodoProvider } from './TodoContext';

const GlobalStyle = createGlobalStyle`
  body {
    background: #e9ecef;
  }
`;

const App = () => {
  return (
    <TodoProvider>
      <GlobalStyle/>
      <Template>
        <Head/>
        <List/>
        <Create/>
      </Template>
    </TodoProvider>
  );
}

export default App;
