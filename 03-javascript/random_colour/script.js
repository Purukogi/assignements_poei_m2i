let randomize_elem = document.getElementById("randomize");
let colouredBlock_elem = document.getElementById("colouredBlock")

randomize_elem = addEventListener("click", randomizeColour);

function randomizeColour(){
    colourString = "#";

    for(let i = 0; i < 6; i++){
        let randomNumber = parseInt(15*Math.random());
        if(randomNumber > 9){
            switch(randomNumber){
                case 10:
                    colourString += "A";
                    break;
                case 11:
                    colourString += "B";
                    break;
                case 12:
                     colourString += "C";
                    break;
                case 13:
                    colourString += "D";
                    break;
                case 14:
                    colourString += "E";
                    break;
                case 15:
                    colourString += "F";
                    break;
            }
        }else{
            colourString += randomNumber.toString();
        }
    }

    console.log(colourString);
    colouredBlock_elem.style.backgroundColor = colourString;

}