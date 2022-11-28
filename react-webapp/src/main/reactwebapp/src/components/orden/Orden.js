import React, { useEffect, useState } from 'react'
import { login, findOrdenes } from '../../utils/httpClient';

export function Orden() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const [jwtToken, setJwtToken] = useState(null);
    const [ordenes, setOrdenes] = useState([]);

    const getLogin = async () => {
        const res = await login(username, password)
        .then((response) => response.json())
        .then((data) => {
            console.log('Success:', data);
            setJwtToken(data.token);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    const getOrdenes = async () => {
        const res = await findOrdenes(jwtToken)
        .then((response) => response.json())
        .then((data) => {
            console.log('Success:', data);
            alert(data);
            setOrdenes(data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    /*
    useEffect(() => {
        console.log('buscando ordenes')
    },[jwtToken]);
    */
   
    return (
        <div>
            {!jwtToken && 
                <div>
                    <label htmlFor='username'>Username:</label>
                    <input id="username" value={username}
                        onChange={(e) => setUsername(e.target.value)} >
                    </input>

                    <label htmlFor='password'>Username:</label>
                    <input id="password" 
                        value={password}
                        type="password"
                        onChange={(e) => setPassword(e.target.value)} >
                    </input>

                    <button onClick={getLogin}>
                        Login
                    </button>
                </div>
            }
            {jwtToken && 
                <div>
                    <button onClick={getOrdenes}>
                        Get Ordenes
                    </button>

                    { ordenes && 
                        <div>
                            {JSON.stringify(ordenes)}
                        </div>
                    }
                </div>
            }
        </div>
    )
}
