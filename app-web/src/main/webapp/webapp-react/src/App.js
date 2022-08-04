import { BrowserRouter,Routes,Route, Link } from 'react-router-dom';
import styles from './App.module.css';
import { MovieDetail } from './components/MovieDetail';
import { Landing } from './components/Landing';

function App() {
  // console.log(styles);

  return (
    <BrowserRouter>
      <header>
        <Link to={'/'}>
          <div>
            <h1 className={styles.title}>Peliculas</h1>
          </div>
        </Link>
      </header>
      <main>
        <Routes>
          <Route path='/' element={<Landing/>}/>
          <Route path='/detail/:movieId' element={<MovieDetail/>}/>
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
