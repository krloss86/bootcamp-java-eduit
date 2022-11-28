const API = 'https://api.themoviedb.org/3';
const ORDEN_API = 'http://localhost:8080';

export function get(path) {
    //'/movie/discovey'
    //'/movie/132123'
    return fetch(API + path,
        {
            headers: {
                Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNGUyNzRhY2JiN2Y5MGM4N2I4NmFkZTVjODczYzZjOCIsInN1YiI6IjYyZGYxZDZmZWE4NGM3MTRlNmZiYzBmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IuHRrSkvk92RXJLBicJXLBcZweGth3GdEByi1iPfBjo',
                "Content-Type": 'application/json;character=utf8'
            },
        }
    ).then(res => {
        if (res.status >= 200 && res.status <= 299) {
            return res.json()
        } else {
            return [];
        }
    })
}

export async function login(username, password) {
    /*
    return fetch(ORDEN_API + '/auth/login',
        {
            headers: {
                Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmNGUyNzRhY2JiN2Y5MGM4N2I4NmFkZTVjODczYzZjOCIsInN1YiI6IjYyZGYxZDZmZWE4NGM3MTRlNmZiYzBmMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.IuHRrSkvk92RXJLBicJXLBcZweGth3GdEByi1iPfBjo',
                "Content-Type":'application/json;character=utf8'
            },    
        }
    ).then(res => {
        if (res.status >= 200 && res.status <= 299) {
            return res.json()
        } else {
            return [];
        }
    })
    */
   console.log(ORDEN_API,username,password);

   const body = JSON.stringify({ username: username, password: password });
   console.log(body);
    return fetch(ORDEN_API + '/auth/login', {
        method: 'POST', // or 'PUT'
        headers: {
            'Content-Type': 'application/json',
        },
        body: body,
    })/*
        .then((response) => response.json())
        .then((data) => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    */
}

export async function findOrdenes(jwt) {
    return fetch(ORDEN_API + '/orden',
        {
            headers: {
                Authorization: `Bearer ${jwt}`,
                "Content-Type":'application/json;character=utf8'
            },    
        }
    );
}