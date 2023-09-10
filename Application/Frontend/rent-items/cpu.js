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
        name: 'Lenovo (Intel Core I5 6Th Gen|8 Gb Ddr4 Ram|512 Gb Ssd) get it at -33% off per month',
        image: 'cpu1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'BitFry Gaming Pc Core I5 6Th Gen 3.6Ghz|16Gb Ddr4 Ram get it at -13% off per month',
        image: 'cpu2.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'Cyntexia Computer Desktop PC (Core i5-4570 / 16GB RAM ) get it at -28% off per month ',
        image: 'cpu3.png',
        price: 2000
    },
    {
        id: 4,
        name: 'Lenovo IdeaCentre 3 (AMD 3020e/4GB/256GB SSD), 90MV00MLIN get it at -70% off per month',
        image: 'cpu4.png',
        price: 15000
    },
    {
        id: 5,
        name: 'Zoonis I7 860 Extreme Gaming Pc (Core I7-860/16Gb Ram) get it at -6% off per month',
        image: 'cpu5.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'Lenovo (Renewed) Thinkcentre Desktop Computer Pc (Intel Core I5 2400/ 8 Gb Ram) get it at -5% off per month',
        image: 'cpu6.PNG',
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
