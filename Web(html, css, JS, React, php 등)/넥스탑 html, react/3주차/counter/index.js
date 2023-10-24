const number = document.getElementById("number");
const plus = document.getElementById("plus");
const minus = document.getElementById("minus");

plus.onclick = () => {
    const current = parseInt(number.innerText, 10);
    number.innerText = current+1;
}

plus5.onclick = () => {
    const current = parseInt(number.innerText, 10);
    number.innerText = current+5;
}

minus.onclick = () => {
    const current = parseInt(number.innerText, 10);
    number.innerText = current-1;
}

minus5.onclick = () => {
    const current = parseInt(number.innerText, 10);
    number.innerText = current-5;
}

clear.onclick = () => {
    const current = parseInt(number.innerText, 10);
    number.innerText = 0;
}