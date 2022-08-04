import { MovieCard } from './MovieCard';
import styles from './MovieGrid.module.css';
import { useState, useEffect } from 'react';
import { get } from './../utils/httpClient';
import { Spinner } from './Spinner';
// import { useQuery } from '../hooks/useQuery';
import InfiniteScroll from 'react-infinite-scroll-component';

export function MovieGird({search}) {

    //estado > steState
    const [peliculas, setPeliculas] = useState([]);
    const [isLoading,setIsLoading] = useState(true);
    const [page,setPage] = useState(1);
    const [hasMore,setHasMore] = useState(true);

    //cuando se carga el componente se ejecuta "el que tiene []"
    useEffect( ()=> {
      setIsLoading(true);
      const urlSerch = search 
        ? '/search/movie?query='+search
        : '/discover/movie?page='+page;

       get(urlSerch)
       .then(data => {
          if(page > 1) {
            setPeliculas( (prevMovies) => prevMovies.concat(data?.results || []))//.sort
          }else {
            setPeliculas( data.results)//.sort
          }

          setIsLoading(false);
          setHasMore(data.page < data.total_pages);
      });
    },[search,page]);

    return (

    <InfiniteScroll
        dataLength={peliculas.length} //This is important field to render the next data
        hasMore={true}
        next={() => setPage( (prevPage) => prevPage + 1)}
        loader={<Spinner/>}
        >
        <ul className={styles.movieGrid}>
            {
              peliculas.map((movie) =>{
                return <MovieCard key={movie.id} movie={movie}></MovieCard>
              })
            }
        </ul>
    </InfiniteScroll>
    );
}
