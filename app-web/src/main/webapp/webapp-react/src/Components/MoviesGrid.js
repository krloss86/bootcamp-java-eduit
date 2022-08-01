import { useEffect, useState } from 'react';
import { MovieCard } from './MovieCard';
// import movies from './movies.json';
import styles from './MovieGrid.module.css';
import { get } from './../utils/httpClient';
import { Spinner } from './Spinner';
import { useQuery } from '../hooks/useQuery';
export function MoviesGrid() {
    //estado > steState
    const [peliculas, setPeliculas] = useState([]);
    const [isLoading,setIsLoading] = useState(true)

    const query = useQuery();
    const search = query.get("search");

    useEffect(() => {
        setIsLoading(true);
        const searchUrl = search
         ? '/search/movie?query='+search
         : '/discover/movie';

        
        get(searchUrl)
        .then(data => {
            setPeliculas(data.results)
            setIsLoading(false);
        });
    },[search]);

    if(isLoading) {
        return <Spinner/>
    }
    
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