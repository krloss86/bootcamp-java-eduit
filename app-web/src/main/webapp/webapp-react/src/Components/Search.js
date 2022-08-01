import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './Search.module.css';
import { FaSearch } from 'react-icons/fa';
import { useQuery } from "../hooks/useQuery";

export function Search() {
 
    const [searchText,setSearchText] = useState("");
    const history = useNavigate ();
    
    const query = useQuery();
    const search = query.get("search");

    const handleSubmit = (e)=> {
        e.preventDefault();
        history("/?search="+searchText)
    }

    useEffect(() => {
        console.log(search);
        setSearchText(search || "");
    }, [search]);

    return (
        <form className={styles.searchContainer} onSubmit={handleSubmit}>
      <div className={styles.searchBox}>
        <input
          className={styles.searchInput}
          type="text"
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
        />
        <button className={styles.searchButton} type="submit">
          <FaSearch size={20} />
        </button>
      </div>
    </form>
    );
}