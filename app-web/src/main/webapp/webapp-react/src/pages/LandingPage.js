import React from 'react'
import { MoviesGrid } from './../Components/MoviesGrid';
import { Search } from './../Components/Search';

export function LandingPage() {
    return (
        <>
            <Search/>
            <MoviesGrid />
        </>
    )
}
