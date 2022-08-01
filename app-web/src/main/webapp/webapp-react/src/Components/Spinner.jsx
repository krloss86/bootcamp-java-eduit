import React from 'react'
import {FaSpinner} from 'react-icons/fa';
import styles from './Spinner.module.css';

export function Spinner() {
  return (
    <div className={styles.spinner}>
        <FaSpinner size={60} className={styles.spinning}/>
    </div>
  )
}
