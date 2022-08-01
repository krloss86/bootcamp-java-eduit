import { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import styles from './MovieDetail.module.css';

export function MovieDetail() {

    // cuando la variable en la url
    // /algo/12345 es un pathParams

    //cuando es ?clave=valor es un query params (query string)

    //declaro el stado
    const [movie, setMovie] = useState(null);

    const [isLoading,setLoading] = useState(false)

    //esto lo vamos a tomar desde el pathParams
    const {movieId} = useParams();

    useEffect( () =>{
        setLoading(false);
        fetch(`https://api.themoviedb.org/3/movie/${movieId}?api_key=f4e274acbb7f90c87b86ade5c873c6c8&language=en-US`)
        .then(res => res.json())
        .then(data => {setMovie(data); setLoading(true)});
    },[]);

    //no mostar si la pelicula esta cargando.
    if(!movie) {
        return null;
    }

    const imageURL = 'https://image.tmdb.org/t/p/w500/' + movie.poster_path;
    
    return (
        <>
        {isLoading && <>  
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
        }
        {!isLoading &&   
            <div>
                <h1>Loading...</h1>
            </div>
        }
        </>
    );
}