import { BrowserRouter,Routes,Route, Link } from 'react-router-dom';
import styles from './App.module.css';
import { MovieDetail } from './components/movie/MovieDetail';
import { LandingPage } from './components/landing/LandingPage';

function App() {
  // console.log(styles);

  return (
    <BrowserRouter basename='/apreact-webapp-1.0.0-SNAPSHOT'>
      <header>
        <Link to={'/'}>
          <div>
            <h1 className={styles.title}>Peliculas</h1>
          </div>
        </Link>
      </header>
      <main>
        <Routes>
          <Route path='/' element={<LandingPage/>}/>
          <Route path='/detail/:movieId' element={<MovieDetail/>}/>
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
