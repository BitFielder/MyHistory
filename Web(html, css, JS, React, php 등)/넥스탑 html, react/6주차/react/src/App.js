import './App.css';
import Home from './pages/Home'
import About from './pages/About'
import Count from './pages/Count'
import Input from './pages/Input'
import Input2 from './pages/Input2'
import { Link, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <nav>
        <Link to="/">Home</Link>ㅣ
        <Link to="/about">About</Link>ㅣ
        <Link to="/count">Count</Link>ㅣ
        <Link to="/input">Input</Link>ㅣ
        <Link to="/input2">Input2</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/about" element={<About />}></Route>
        <Route path="/count" element={<Count />}></Route>
        <Route path="/input" element={<Input />}></Route>
        <Route path="/input2" element={<Input2 />}></Route>
      </Routes>
    </div>
  );
}

export default App;
