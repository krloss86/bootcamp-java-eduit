import { useState } from 'react';

export function SearchMovie() {
    
    const [searchKey, setSearchKey] = useState('');

    const updateSearch = (e)  => {
        setSearchKey(e.target.value)
    }

    const searchMovie = () => {
        //consultar un api con el parametros = searchKey

        // https://api.themoviedb.org/3/search/movie?query=${searchKey}&api_key=<<api_key>>&language=en-US&page=1&include_adult=false

        alert(searchKey);
    }

    return(
        <>
        <input placeholder='buscar' 
            value={searchKey} onChange={(e) => updateSearch(e) }/>
        <button onClick={searchMovie}>
            Buscar
        </button>
        </>
    );
}