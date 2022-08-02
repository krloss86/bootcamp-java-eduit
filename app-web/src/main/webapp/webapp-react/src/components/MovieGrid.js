import { MovieCard } from './MovieCard';
import styles from './MovieGrid.module.css';
import { useState, useEffect } from 'react';
import { get } from './../utils/httpClient';
import { useLocation } from 'react-router-dom';
import { Spinner } from './Spinner';
// import { useQuery } from '../hooks/useQuery';

export function MovieGird() {

    //estado > steState
    const [peliculas, setPeliculas] = useState([]);
    const query =  new URLSearchParams(useLocation().search);
    // const query =  useQuery();
    const search = query.get("search");
    const [isLoading,setIsLoading] = useState(true);

    //cuando se carga el componente se ejecuta "el que tiene []"
    useEffect( ()=> {
      setIsLoading(true);
      const urlSerch = search 
        ? '/search/movie?query='+search
        : '/discover/movie';

       get(urlSerch)
       .then(data => {
          setPeliculas(data.results)
          setIsLoading(false);
      });
    },[search]);

    if(isLoading) {
      return <Spinner/>
    }

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
