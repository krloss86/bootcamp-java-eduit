const API = 'https://api.themoviedb.org/3';

export function get(path) {
    return fetch(`${API}${path}`,
    {
      headers: {
        Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNGUyNzRhY2JiN2Y5MGM4N2I4NmFkZTVjODczYzZjOCIsInN1YiI6IjYyZGYxZDZmZWE4NGM3MTRlNmZiYzBmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IuHRrSkvk92RXJLBicJXLBcZweGth3GdEByi1iPfBjo',
        "Content-Type": 'application/json;charset=utf8'
      },
    }
    ).then(res => res.json());
}