import { useEffect } from 'react';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import style from './App.module.css';
import { LandingPage } from './pages/LandingPage';
import { MovieDetail } from './pages/MovieDetail';


function App() {
  let movies = [];
  useEffect(() => {
    fetch('https://api.themoviedb.org/3/discover/movie',
    {
      headers: {
        Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNGUyNzRhY2JiN2Y5MGM4N2I4NmFkZTVjODczYzZjOCIsInN1YiI6IjYyZGYxZDZmZWE4NGM3MTRlNmZiYzBmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IuHRrSkvk92RXJLBicJXLBcZweGth3GdEByi1iPfBjo',
        "Content-Type": 'application/json;charset=utf8'
      },
    }
    );
  });
  return (
    <>
      <BrowserRouter>
        <header>
          <Link to="/">
            <h1 className={style.title}>Movies</h1>
          </Link>
          {/* <Link to="/">Home</Link>
          <Link to="/movie">Movie</Link>
          <Link to="/detail">Detalle</Link> */}
        </header>
      <main>
        <Routes>
          <Route path='/' element={<LandingPage />} />
          <Route path='/movie'>Movie Section</Route>
          <Route path='/detail/:movieId' element={<MovieDetail/>}></Route>
        </Routes>
      </main>
      </BrowserRouter>
    </>
  );
}

export default App;
