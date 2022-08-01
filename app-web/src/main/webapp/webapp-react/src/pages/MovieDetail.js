// import movie from './movie.json';
import styles from './MovieDetail.module.css';
import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { get } from '../utils/httpClient';
import { Spinner } from '../Components/Spinner';

export const MovieDetail = () => {
    const {movieId} = useParams();
    const [movie,setMovie] = useState(null);
    const [isLoading,setIsLoading] = useState(true)
    
    useEffect(() => {
        setIsLoading(true);
        get(`/movie/${movieId}`)        
        .then(data => {
            setMovie(data);setIsLoading(false);
        });
    },[movieId]);

    if(isLoading) {
        return <Spinner/>
    }
    if(!movie) {
        return null;
    }
        
    const imageUrl = "https://image.tmdb.org/t/p/w500/" + movie.poster_path;
    return (
        <div className={styles.detailsContainer}>
            <img 
                className={`${styles.col} ${styles.movieImage}`}
                src={imageUrl} alt={movie.title} />
            <div className={styles.col}>
                <p><strong>Title: {movie.title}</strong></p>
                <p><strong>Description:</strong> {movie.overview}</p>
                <p><strong>Genders: {movie.genres.map(g=>g.name).join(", ")} </strong></p>
            </div>
        </div>
    )
}
