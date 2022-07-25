import style from './App.module.css';
import { MoviesGrid } from './Components/MoviesGrid';

function App() {

  return (
    <>
      <header>
        <h1 className={style.title}>Movies</h1>
      </header>
      <main>
        <MoviesGrid />
      </main>
    </>
  );
}

export default App;
