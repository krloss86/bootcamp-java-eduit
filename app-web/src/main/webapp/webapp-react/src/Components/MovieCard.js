import { Link } from 'react-router-dom';
import styles from './MovieCard.module.css'
export const MovieCard = ({ movie }) => {
    const imageUrl = "https://image.tmdb.org/t/p/w300/" + movie.poster_path;
    return (
        <li className={styles.movieCard}>
            <Link to={`/detail/${movie.id}`}>
                <img alt="alt" 
                    width={230}
                    heigh={345}
                    src={imageUrl}
                    className={styles.movieImage}
                    />
            </Link>
            <div>{movie.title}</div>
        </li>
    )
}
