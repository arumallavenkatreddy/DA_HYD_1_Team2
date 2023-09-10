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
        name: 'Hisense 45L Single Door Mini Refrigerator (RR46D4SBN) get it at -33% off per month',
        image: 'fridge1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'Haier 165 L 1 Star Direct Cool Single Door(HED-171RS-P) get it at -13% off per month',
        image: 'fridge2.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'Whirlpool 184 L (205 WDE CLS 2S SAPPHIRE ,2023 Model) get it at -28% off per month ',
        image: 'fridge3.png',
        price: 2000
    },
    {
        id: 4,
        name: 'Haier 190L Direct Cool Single Door(2023 Model, HED-204DS-P) get it at -70% off per month',
        image: 'fridge4.png',
        price: 5000
    },
    {
        id: 5,
        name: 'Haier 185 L 2 Star Direct Cool (HED-19TGG-N, Holyleaf Glass) get it at -6% off per month',
        image: 'fridge5.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'Haier 328L Inverter Double Door(2023 Model, HRF-3783YGG-P) get it at -5% off per month',
        image: 'fridge6.PNG',
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
