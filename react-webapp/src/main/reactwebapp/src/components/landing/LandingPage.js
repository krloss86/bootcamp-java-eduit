import { useLocation } from 'react-router';
import { MovieGird } from "../movie/MovieGrid";
import { SearchMovie } from '../search/SearchMovie';

export function LandingPage() {

    const query =  new URLSearchParams(useLocation().search);
    const search = query.get("search");

    return (
        <>
            <SearchMovie/>
            <MovieGird key={search} search={search}/>
        </>
    );
}