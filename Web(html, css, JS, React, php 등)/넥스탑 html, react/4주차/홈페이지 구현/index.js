let gnb = document.querySelectorAll("#gnb > li");
let gnbElement = document.querySelector("#gnb");

for (let i = 0; i<gnb.length; i++){
    gnb[i].addEventListener("mouseover",() =>{
        gnbElement.classList.add("on");
    });
}

let headerElement = document.querySelector("#header");

header.addEventListener("mouseout", (e) =>{
    if(e.target.id == "gnb"){
        gnbElement.classList.remove("on");
    }
});

const open = document.getElementById("open");
const close = document.getElementById("close");
const modal = document.querySelector(".modal-wrapper");

open.onclick = () => {
    modal.style.display = "flex";
}

close.onclick = () => {
    modal.style.display = "none";
}

