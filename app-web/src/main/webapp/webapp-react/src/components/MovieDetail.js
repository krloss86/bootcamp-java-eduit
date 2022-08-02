import { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import styles from './MovieDetail.module.css';
import { get } from './../utils/httpClient';
import { Spinner } from './Spinner';

export function MovieDetail() {
    const [movie, setMovie] = useState(null);
    const [isLoading,setLoading] = useState(true)
    const {movieId} = useParams();

    useEffect( () =>{
        setLoading(true);
        get(`/movie/${movieId}`)
        .then(data => {
            setMovie(data); 
            setLoading(false);
        });
    },[]);

    if(isLoading) {
        return <Spinner/>;
    }

    if(!movie) {
        return null;
    }

    const imageURL = 'https://image.tmdb.org/t/p/w500/' + movie.poster_path;
    
    return (
        <>
            <div className={styles.detailsContainer}>
                <img src={imageURL} 
                    alt={movie.title} 
                    width={500} 
                    height={'auto'}
                    className={styles.movieImage}>
                </img>
                <div className={styles.col}>
                    <p>Title: {movie.title}</p>
                    <p>Genders: {movie.genres.map(g =>  g.name).join(', ')}</p>
                    <p>Home Page:
                        <a className={styles.movieUrl} 
                            href={movie.homepage} 
                            target="_new">{movie.title}
                        </a>
                    </p>
                </div>
            </div>
            <Link to={'/'}>
                <p className={styles.volverLink}>Volver</p>
            </Link>         
        </>
    );
}