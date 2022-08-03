import { useEffect, useState } from 'react';
import { MovieCard } from './MovieCard';
// import movies from './movies.json';
import styles from './MovieGrid.module.css';
import { get } from './../utils/httpClient';
import { Spinner } from './Spinner';
import { useQuery } from '../hooks/useQuery';
import InfiniteScroll from 'react-infinite-scroll-component';

export function MoviesGrid({search}) {
    //estado > steState
    const [peliculas, setPeliculas] = useState([]);
    const [isLoading, setIsLoading] = useState(true)
    const [page,setPage] = useState(1);
    const [hasMore,setHasMore] = useState(true);

    // const query = useQuery();
    // const search = query.get("search");

    useEffect(() => {
        setIsLoading(true);
        const searchUrl = search
            ? '/search/movie?query=' + search + "&page="+page
            : '/discover/movie?page='+page;

        get(searchUrl)
            .then(data => {
                setPeliculas((prevMovies) => prevMovies.concat(data.results))
                setIsLoading(false);
                setHasMore(data.page < data.total_pages);
            });
    }, [search,page]);

    return (
        <InfiniteScroll
            dataLength={peliculas.length} //This is important field to render the next data
            hasMore={true}
            next={() => setPage((prevPage) => prevPage +1)}
            loader={<Spinner />}
        >
            <ul className={styles.moviesGrid}>
                {
                    peliculas.map((movie) => {
                        return <MovieCard key={Math.random() + movie.id} movie={movie}></MovieCard>
                    })
                    }
                </ul>
        </InfiniteScroll>
    );
}