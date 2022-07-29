// import movie from './movie.json';
import styles from './MovieDetail.module.css';
import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';

export const MovieDetail = () => {
    const {movieId} = useParams();
    const [movie,setMovie] = useState(null);
    
    useEffect(() => {
        fetch(`https://api.themoviedb.org/3/movie/${movieId}?api_key=f4e274acbb7f90c87b86ade5c873c6c8&language=en-US`)
        .then(pepe => pepe.json())
        .then(data => setMovie(data));
    },[movieId]);

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
