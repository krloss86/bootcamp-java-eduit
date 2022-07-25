import styles from './MovieCard.module.css'
export const MovieCard = ({ movie }) => {
    // console.log(styles)
    const imageUrl = "https://image.tmdb.org/t/p/w300/" + movie.poster_path;
    return (
        <li className={styles.movieCard}>
            <img alt="alt" 
                width={230}
                heigh={345}
                src={imageUrl}
                className={styles.movieImage}
                />
            <div>{movie.title}</div>
        </li>
    )
}
