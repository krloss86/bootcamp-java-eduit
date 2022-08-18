const API = 'https://api.themoviedb.org/3';

export function get(path) {
    //'/movie/discovey'
    //'/movie/132123'
    return fetch(API + path,
        {
            headers: {
                Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNGUyNzRhY2JiN2Y5MGM4N2I4NmFkZTVjODczYzZjOCIsInN1YiI6IjYyZGYxZDZmZWE4NGM3MTRlNmZiYzBmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IuHRrSkvk92RXJLBicJXLBcZweGth3GdEByi1iPfBjo',
                "Content-Type":'application/json;character=utf8'
            },    
        }
    ).then(res =>  {
        if (res.status >= 200 && res.status <= 299) {
            return res.json()
          } else {
            return [];
          }
    })
    
    
}