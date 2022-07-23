function DiasDeSemana({diasDeSemana,diaActual}) {
    // //desestructuring
    // params.params
    // params.algoMAs
    // {params}
    // {algoMas}
    console.log(diasDeSemana);
    console.log(diaActual);
    return (
        <div className='col'>
            <h1>Dias:</h1>
            <ul>
                {
                    diasDeSemana.map((dia, index) => {
                        return <>
                                <li className={dia === diaActual ? 'NEGRITA': ''} 
                                    key={index}>{dia}
                                </li>
                            </>
                    })
                }
            </ul>
        </div>
    );
}

export default DiasDeSemana;