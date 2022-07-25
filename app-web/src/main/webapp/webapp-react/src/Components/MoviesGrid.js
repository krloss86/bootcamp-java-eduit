import { MovieCard } from './MovieCard';
import movies from './movies.json';
import styles from './MovieGrid.module.css';
export function MoviesGrid() {
    // console.log(movies);
    return (
        <ul class={styles.moviesGrid}> 
            {
                movies.map((movie) => {
                    return <MovieCard key={movie.id} movie={movie}></MovieCard>
                })
            }
        </ul>
    );
}