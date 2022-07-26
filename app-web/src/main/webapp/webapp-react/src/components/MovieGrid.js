import { MovieCard } from './MovieCard';
import styles from './MovieGrid.module.css';
import { useState, useEffect } from 'react';

export function MovieGird() {

    //estado > steState
    const [peliculas, setPeliculas] = useState([]);

    //cuando se carga el componente se ejecuta "el que tiene []"
    useEffect( ()=> {
        //fetch
        //axios
        fetch('https://api.themoviedb.org/3/discover/movie?api_key=f4e274acbb7f90c87b86ade5c873c6c8&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate')
        .then(pepe => pepe.json())
        .then(data => setPeliculas(data.results));
    },[]);

    return (
        <ul className={styles.movieGrid}>
            {
              peliculas.map((movie) =>{
                return <MovieCard key={movie.id} movie={movie}></MovieCard>
              })
            }
        </ul>
    );
}
