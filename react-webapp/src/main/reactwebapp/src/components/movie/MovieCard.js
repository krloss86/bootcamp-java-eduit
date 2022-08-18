import styles from './MovieCard.module.css';
import { Link } from 'react-router-dom';

export function MovieCard({movie}) {
    return (
        <li key={movie.id} className={styles.movieCard}>
            <Link to={`/detail/${movie.id}`}>
                <img 
                    className={styles.movieImg}
                    // width={230}
                    // height={340}
                    src={'https://image.tmdb.org/t/p/w300/' + movie.poster_path}
                    alt={movie.title}>
                </img>
            </Link>
            <div>
                {movie.title}
            </div>
        </li>
    )
}
