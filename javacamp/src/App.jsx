import './App.css';
import "bootstrap/dist/css/bottstrap.min.css"
import { Route, Routes } from 'react-router-dom';
import Login from "./components/pages/Login"
import Main from "./components/pages/Main"
import HackerNews from "./components/pages/HackerNews"

function App({ authService }) {
  return (
    <>
      <Routes>
        <Route path="/" exact={true} element={<Main />} />
        <Route path="/main/:userId" 
              exact={true} 
              element={<Main authService={authService} />} />
        <Route path="/hacker" exact={true} element={<HackerNews />} />
      </Routes>
    </>  
  );
}

export default App;
