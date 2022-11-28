import { BrowserRouter,Routes,Route, Link } from 'react-router-dom';
import styles from './App.module.css';
import { MovieDetail } from './components/movie/MovieDetail';
import { LandingPage } from './components/landing/LandingPage';
import { Orden } from './components/orden/Orden';

function App() {
  // console.log(styles);

  return (
    <BrowserRouter basename='/'>
      <header>
        <Link to={'/'}>
          <div>
            <h1 className={styles.title}>Peliculas</h1>
          </div>
        </Link>
        <Link to={'/ordenes'}>
          <div>
            <h1 className={styles.title}>Ordenes</h1>
          </div>
        </Link>
      </header>
      <main>
        <Routes>
          <Route path='/' element={<LandingPage/>}/>
          <Route path='/detail/:movieId' element={<MovieDetail/>}/>
          <Route path='/ordenes' element={<Orden/>}/>
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
