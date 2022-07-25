import style from './App.module.css';
import { MoviesGrid } from './components/MoviesGrid';
import {BrowserRouter, Routes, Route }  from 'react-router-dom';


function App() {

  return (
    <>
      <header>
        <h1 className={style.title}>Movies</h1>
      </header>
      <main>
        {/* <MoviesGrid /> */}
        <BrowserRouter>
          <Routes>
              <Route path='/' element={<MoviesGrid/>}>
              </Route>
          </Routes>
        </BrowserRouter>
      </main>
    </>
  );
}

export default App;
