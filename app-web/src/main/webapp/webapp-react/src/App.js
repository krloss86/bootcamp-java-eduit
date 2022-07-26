import styles from './App.module.css';
import { MovieGird } from './components/MovieGrid';

function App() {
  // console.log(styles);

  return (
    <>
      <header>
        <h1 className={styles.primerParrafo}>Peliculas</h1>
      </header>
      <main>
        <MovieGird></MovieGird>
      </main>
    </>
  );
}

export default App;
