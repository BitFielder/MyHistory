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
})