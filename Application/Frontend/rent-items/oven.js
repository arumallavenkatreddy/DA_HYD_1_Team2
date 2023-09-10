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
        name: 'Pigeon Oven Toaster Grill (12381) 9 Liters OTG without Rotisserie get it at -33% off per month',
        image: 'oven1.PNG',
        price: 699
    },
    {
        id: 2,
        name: 'Pigeon Electric Oven 20 Liters OTG with Grill and Rotisserie get it at -13% off per month',
        image: 'oven2.PNG',
        price: 475
    },
    {
        id: 3,
        name: 'Panasonic 20L Solo Microwave Oven (NN-ST26JMFDG) get it at -28% off per month ',
        image: 'oven3.png',
        price: 297
    },
    {
        id: 4,
        name: 'Whirlpool 20 L Solo Microwave Oven (MAGICOOK) get it at -70% off per month',
        image: 'oven4.png',
        price: 890
    },
    {
        id: 5,
        name: 'Tesora Digital Air Fryer Oven | Replaces OTG, Oven, Air Fryer get it at -6% off per month',
        image: 'oven5.PNG',
        price: 657
    },
    {
        id: 6,
        name: 'LG 20 L Solo Microwave Oven (MS2043BP, Black) get it at -5% off per month',
        image: 'oven6.PNG',
        price: 499
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
