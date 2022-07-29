import { useEffect, useState } from 'react';
import { MovieCard } from './MovieCard';
// import movies from './movies.json';
import styles from './MovieGrid.module.css';
export function MoviesGrid() {
    //estado > steState
    const [peliculas, setPeliculas] = useState([]);

    useEffect(() => {
        fetch('https://api.themoviedb.org/3/discover/movie',
        {
          headers: {
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNGUyNzRhY2JiN2Y5MGM4N2I4NmFkZTVjODczYzZjOCIsInN1YiI6IjYyZGYxZDZmZWE4NGM3MTRlNmZiYzBmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IuHRrSkvk92RXJLBicJXLBcZweGth3GdEByi1iPfBjo',
            "Content-Type": 'application/json;charset=utf8'
          },
        }
        ).then(pepe => pepe.json())
        .then(data => setPeliculas(data.results));
    },[]);

    return (
        <ul className={styles.moviesGrid}> 
            {
                peliculas.map((movie) => {
                    return <MovieCard key={movie.id} movie={movie}></MovieCard>
                })
            }
        </ul>
    );
}