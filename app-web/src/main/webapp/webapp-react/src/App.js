import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import style from './App.module.css';
import { LandingPage } from './pages/LandingPage';
import { MovieDetail } from './pages/MovieDetail';

function App() {
  return (
      <BrowserRouter>
        <header>
          <Link to="/">
            <h1 className={style.title}>Movies</h1>
          </Link>
        </header>
        <main>
          <Routes>
            <Route path='/' element={<LandingPage />} />
            <Route path='/detail/:movieId' element={<MovieDetail/>}></Route>
          </Routes>
        </main>
      </BrowserRouter>
  );
}

export default App;
