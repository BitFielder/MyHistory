import './App.css';
import Monitor from './capstonez/Monitor'
import Main from './capstonez/Main'
import {BrowserRouter} from 'react-router-dom'
import { Link, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <button><Link to='/'>Main</Link></button>
      <button><Link to="/monitor">Monitor</Link></button>
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route path="/monitor" element={<Monitor />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
