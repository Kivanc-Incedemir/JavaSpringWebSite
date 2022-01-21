document.addEventListener('DOMContentLoaded',() =>{

    //card options
    const cardArray = [{
        name: 'fries',
        img: 'assets/img/game_images/fries.png'

    },{
        name: 'fries',
         img: 'assets/img/game_images/fries.png'

    },{
        name: 'cheeseburger',
        img: 'assets/img/game_images/cheeseburger.png'

    },
    {
        name: 'cheeseburger',
        img: 'assets/img/game_images/cheeseburger.png'

    },
    {
        name: 'hotdog',
        img: 'assets/img/game_images/hotdog.png'

    }, {
        name: 'hotdog',
        img: 'assets/img/game_images/hotdog.png'

    },
    {
        name: 'ice-cream',
        img: 'assets/img/game_images/ice-cream.png'

    },{
        name: 'ice-cream',
        img: 'assets/img/game_images/ice-cream.png'

    },
    {
        name: 'milkshake',
        img: 'assets/img/game_images/milkshake.png'

    },  {
        name: 'milkshake',
        img: 'assets/img/game_images/milkshake.png'

    },
    {
        name: 'pizza',
        img: 'assets/img/game_images/pizza.png'

    },
    {
        name: 'pizza',
        img: 'assets/img/game_images/pizza.png'

    }]

    cardArray.sort(()=> 0.5 - Math.random());

    const grid = document.querySelector('.grid');
    const resultDisplay = document.querySelector('#result');
    let cardsChosen=[];
    let cardsChosenId=[];
    let cardsWon = []
    //create board
    function createBoard() {
        for(let i = 0; i<cardArray.length; i++){
            const card = document.createElement('img');
            card.setAttribute('src','assets/img/game_images/blank.png');
            card.setAttribute('data-id',i);
            card.addEventListener('click',flipcard);
            grid.appendChild(card);
        }
    }

    function checkForMatch() {
        const cards = document.querySelectorAll('img');
        const optionOneId = cardsChosenId[0];
        const optionTwoId = cardsChosenId[1];
        if(optionOneId == optionTwoId){
            cards[optionOneId].setAttribute('src','assets/img/game_images/blank.png');
            cards[optionTwoId].setAttribute('src','assets/img/game_images/blank.png');
            alert('You have clicked the same image!');
        }

       else if(cardsChosen[0] == cardsChosen[1])
        {
            alert('You found a match');
            cards[optionOneId].setAttribute('src','assets/img/game_images/white.png');
            cards[optionTwoId].setAttribute('src','assets/img/game_images/white.png');
            cards[optionOneId].removeEventListener('click',flipcard);
            cards[optionTwoId].removeEventListener('click',flipcard);
            cardsWon.push(cardsChosen);
        } else{
            cards[optionOneId].setAttribute('src','assets/img/game_images/blank.png');
            cards[optionTwoId].setAttribute('src','assets/img/game_images/blank.png');
            alert('Sorry try again!');
        }
        cardsChosen = [];
        cardsChosenId =[];
        resultDisplay.textContent = cardsWon.length;
        if(cardsWon.length ===  cardArray.length/2){
            resultDisplay.textContent = "Congratulations! You found them all!";
        }
        }
    

    function flipcard() {
        let cardId = this.getAttribute('data-id');
        cardsChosen.push(cardArray[cardId].name);
        cardsChosenId.push(cardId);
        this.setAttribute('src',cardArray[cardId].img);
        if(cardsChosen.length === 2 ){
            setTimeout(checkForMatch,500);
        }
    }
    createBoard();

})