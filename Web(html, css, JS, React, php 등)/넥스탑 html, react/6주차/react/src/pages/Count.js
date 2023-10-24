import React from "react";
import { useState } from "react";
import './Count.css';

const Count = () => {
    const [number, setNumber] = useState(0);

    const plus = () => {
        setNumber(number + 1);
    }
    const plus5 = () => {
        setNumber(number + 5);
    }
    const minus = () => {
        setNumber(number - 1);
    }
    const minus5 = () => {
        setNumber(number - 5);
    }
    const Clear = () => {
        setNumber(0);
    }
    return (
        <div>
            <div class="container">
                <header>counter</header>
                <h2>{number}</h2>
                <div class="btn">
                    <button onClick={plus}>+1</button>
                    <button onClick={minus}>-1</button>
                </div>
                <div class="btn">
                    <button onClick={plus5}>+5</button>
                    <button onClick={minus5}>-5</button>
                </div>
                <button onClick={Clear}>C</button>
            </div>
        </div>
    )
}

export default Count;