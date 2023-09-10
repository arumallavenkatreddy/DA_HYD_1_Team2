let openShopping = document.querySelector('.shopping');
let closeShopping = document.querySelector('.closeShopping');
let list = document.querySelector('.list');
let listCard = document.querySelector('.listCard');
let body = document.querySelector('body');
let total = document.querySelector('.total');
let quantity = document.querySelector('.quantity');

openShopping.addEventListener('click', ()=>{
    body.classList.add('active');
})
closeShopping.addEventListener('click', ()=>{
    body.classList.remove('active');
})

let products = [
    {
        id: 1,
        name: 'nverter Split AC (Copper, AiSense, Four-Way Convertible, Quad Swing, Inverter Tec, MicroFilter, Super-Chill Mode, Auto-Clean, AR15SIN5GMEC, 2023 Model, White) get it at -33% off per month',
        image: 'ac1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'Blue Star 1.5 Ton 5 Star Convertible 5 in 1 Cooling Inverter Split AC (Copper, 4 Way Swing, Stabalizer Free Operation, Dust Filter, , 2023Model, IC518YNU, White) get it at -13% off per month',
        image: 'ac2.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'Casa Copenhagen Evaporative Personal Air Cooler Small Cold Air Fan with for Room,Office,Desk - 27.1ltrRZ31.8 (White & Black) with Diet Personal Tower Air Cooler!get it at -28% off per month ',
        image: 'ac3.png',
        price: 20000
    },
    {
        id: 4,
        name: 'Lloyd 1.5 Ton 3 Star Inverter Split AC (5 in 1 Convertible, Copper, Anti-Viral + PM 2.5 Filter, 2023 Model, White, GLS18I3FWAMC) get it at -70% off per month',
        image: 'ac4.png',
        price: 15000
    },
    {
        id: 5,
        name: 'Lloyd 1.5 Ton 4 Star Fixed Speed Window AC (Copper, 2023 Model, White with Golden Deco Strip, GLW18C4YWGEW) get it at -6% off per month',
        image: 'ac5.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'NU 1.5 Ton 3 Star 4 in 1 Convertible Inverter Split AC (Copper Condenser, NUAC153SCIA, White)29.5 x 100 x 23 Centimeters 2023 Model get it at -5% off per month',
        image: 'ac6.PNG',
        price: 1499
    }
];
let listCards  = [];
function initApp(){
    products.forEach((value, key) =>{
        let newDiv = document.createElement('div');
        newDiv.classList.add('item');
        newDiv.innerHTML = `
            <img src="../assets/img/${value.image}">
            <div class="title">${value.name}</div>
            <div class="price">${value.price.toLocaleString()}</div>
            <button onclick="addToCard(${key})">Add To Card</button>`;
        list.appendChild(newDiv);
    })
}
initApp();
function addToCard(key){
    if(listCards[key] == null){
        // copy product form list to list card
        listCards[key] = JSON.parse(JSON.stringify(products[key]));
        listCards[key].quantity = 1;
    }
    reloadCard();
}
function reloadCard(){
    listCard.innerHTML = '';
    let count = 0;
    let totalPrice = 0;
    listCards.forEach((value, key)=>{
        totalPrice = totalPrice + value.price;
        count = count + value.quantity;
        if(value != null){
            let newDiv = document.createElement('li');
            newDiv.innerHTML = `
                <div><img src="../assets/img/${value.image}"/></div>
                <div>${value.name}</div>
                <div>${value.price.toLocaleString()}</div>
                <div>
                    <button onclick="changeQuantity(${key}, ${value.quantity - 1})">-</button>
                    <div class="count">${value.quantity}</div>
                    <button onclick="changeQuantity(${key}, ${value.quantity + 1})">+</button>
                </div>`;
                listCard.appendChild(newDiv);
        }
    })
    total.innerText = totalPrice.toLocaleString();
    quantity.innerText = count;
}
function changeQuantity(key, quantity){
    if(quantity == 0){
        delete listCards[key];
    }else{
        listCards[key].quantity = quantity;
        listCards[key].price = quantity * products[key].price;
    }
    reloadCard();
}
