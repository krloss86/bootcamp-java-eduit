import styles from './MovieCard.module.css';

export function MovieCard({movie}) {
    return (
        <li key={movie.id} className={styles.movieCard}>
            <img 
                className={styles.movieImg}
                // width={230}
                // height={340}
                src={'https://image.tmdb.org/t/p/w300/' + movie.poster_path}
                alt={movie.title}>
            </img>
            <div>
                {movie.title}
            </div>
        </li>
    )
}
