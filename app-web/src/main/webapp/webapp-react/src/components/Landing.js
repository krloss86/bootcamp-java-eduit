import { MovieGird } from "./MovieGrid";
import { SearchMovie } from './SearchMovie';
import { useLocation } from 'react-router';

export function Landing() {

    const query =  new URLSearchParams(useLocation().search);
    const search = query.get("search");

    return (
        <>
            <SearchMovie/>
            <MovieGird key={search} search={search}/>
        </>
    );
}