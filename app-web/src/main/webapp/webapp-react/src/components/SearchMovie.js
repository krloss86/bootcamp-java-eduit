import { useState } from 'react';
import { FaSearch } from "react-icons/fa";
import styles from './SearchMovie.module.css';
import { useLocation} from 'react-router';
import { useNavigate } from 'react-router-dom';

export function SearchMovie() {
    
    const query =  new URLSearchParams(useLocation().search);
    const history = useNavigate();
    const [searchKey, setSearchKey] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        history(`/?search=${searchKey}`);
    }

    return(
        <form onSubmit={handleSubmit} className={styles.searchContainer}>
            <div className={styles.searchBox}>
                <input placeholder='buscar' 
                    value={searchKey} 
                    className={styles.searchInput}
                    type="text"
                    onChange={(e) => setSearchKey(e.target.value) }/>
                <button type="submit" 
                    className={styles.searchButton}>
                    <FaSearch size={20}/>
                </button>
            </div>
        </form>
    );
}