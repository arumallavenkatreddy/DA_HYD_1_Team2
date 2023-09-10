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
        name: 'Lenovo ThinkPad E14 Intel Core i7 12th Gen 14" FHD IPS Thin and Light Laptop, 21E3S05B00 get it at -33% off per month',
        image: '1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'Apple iPhone 14 (128 GB) - Blue Dual-camera system: 12MP Main, with Portrait mode, Depth Control get it at -13% off per month',
        image: 'iphone.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'Hisense Refigerator 564 L Inverter Frost-Free with Water Dispenser (RS564N4SBNW, Black Stainless)get it at -28% off per month ',
        image: 'fridge.png',
        price: 20000
    },
    {
        id: 4,
        name: 'Sony Bravia 4K Ultra HD  KD-65X82L(Black) 164 cm (65 inches) 4K Ultra HD Smart LED Google TV KD-65X82L (Black)get it at -70% off per month',
        image: 'tv.webp',
        price: 15000
    },
    {
        id: 5,
        name: 'Jabra Evolve 40 MS(Black)3.5 mm jack for better connectivity-The 3.5 mm jack lets you connect to your personal device get it at -6% off per month',
        image: 'jabra.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'HUL 8L Water Purifier RO+ Product Dimensions	14.2L x 13.8W x 17.6H Centimeters Package Information	Glass Power Electric get it at -5% off per month',
        image: 'wateerpurifier.PNG',
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
