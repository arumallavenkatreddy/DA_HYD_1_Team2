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
        name: 'Redmi 80 cm (32 inches) HD Ready Smart LED Fire TV L32R8-FVIN (Black) get it at -33% off per month',
        image: 'tv1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'Samsung 80 cm (32 Inches) LED Smart TV UA32T4340BKXXL (Glossy Black) get it at -13% off per month',
        image: 'tv2.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'LG 80 cm (32 inches) HD Ready Smart LED TV 32LM563BPTC (Dark Iron Gray) get it at -28% off per month ',
        image: 'tv3.png',
        price: 20000
    },
    {
        id: 4,
        name: 'Samsung 108 cm 4K Ultra HD Smart LED TV UA43CUE60AKLXL (Black) get it at -70% off per month',
        image: 'tv4.png',
        price: 15000
    },
    {
        id: 5,
        name: 'VW 109 cm (43 inches) Playwall Frameless Series Full HD Android Smart LED TV VW43F1 (Black) get it at -6% off per month',
        image: 'tv5.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'Mi 125 cm (50 inches) X Series 4K Ultra HD Smart Android LED TV L50M7-A2IN (Black) get it at -5% off per month',
        image: 'tv6.PNG',
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
