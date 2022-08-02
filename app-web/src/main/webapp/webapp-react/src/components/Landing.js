import { MovieGird } from "./MovieGrid";
import { SearchMovie } from './SearchMovie';

export function Landing() {
    return (
        <>
            <SearchMovie/>
            <MovieGird/>
        </>
    );
}