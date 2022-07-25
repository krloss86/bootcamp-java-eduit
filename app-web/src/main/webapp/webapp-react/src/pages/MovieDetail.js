import movie from './movie.json';
import styles from './MovieDetail.module.css';

export const MovieDetail = () => {
    const imageUrl = "https://image.tmdb.org/t/p/w500/" + movie.poster_path;
    return (
        <div className={styles.detailsContainer}>
            <img 
                className={`${styles.col} ${styles.movieImage}`}
                src={imageUrl} alt={movie.title} />
            <div className={styles.col}>
                <p><strong>Title: {movie.title}</strong></p>
                <p><strong>Description:</strong> {movie.overview}</p>
                <p><strong>Genders: {movie.genre_ids.map(g=>g.name).join(", ")} </strong></p>
            </div>
        </div>
    )
}
