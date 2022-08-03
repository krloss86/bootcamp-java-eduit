import React from 'react'
import { MoviesGrid } from './../Components/MoviesGrid';
import { Search } from './../Components/Search';
import { useQuery } from './../hooks/useQuery';

export function LandingPage() {
    const query = useQuery();
    const search = query.get("search");

    return (
        <>
            <Search/>
            <MoviesGrid key ={search} search={search}/>
        </>
    )
}
