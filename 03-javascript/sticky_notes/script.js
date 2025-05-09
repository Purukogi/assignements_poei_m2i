let noteTitle_elem = document.getElementById("noteTitle");
let noteBody_elem = document.getElementById("noteBody");
let noteColour_elem = document.getElementById("noteColour");
let noteRegister_elem = document.getElementById("noteRegister");
let noteArea_elem = document.getElementById("noteArea");

noteRegister_elem.addEventListener("click", () => {
    if(noteTitle_elem.value === "" || noteBody_elem.value === ""){
        window.alert("Sticky notes must have a title and some text!")
    }else{
        addNote();
    }
});

function addNote(){    

    let noteToAdd = document.createElement("div");
    let titleToAdd = document.createElement("h3");
    let bodyToAdd = document.createElement("p");
    let cancelButtonToAdd = document.createElement("img")

    cancelButtonToAdd.src = "images/close.png";
    cancelButtonToAdd.addEventListener("click", deleteNote);

    titleToAdd.innerText = noteTitle_elem.value;
    bodyToAdd.innerText = noteBody_elem.value;

    noteToAdd.appendChild(titleToAdd);
    noteToAdd.appendChild(cancelButtonToAdd);
    noteToAdd.appendChild(bodyToAdd);     

    noteToAdd.style.backgroundColor = noteColour_elem.value;       
    
    noteArea_elem.appendChild(noteToAdd);

}

function deleteNote(event) {
    if(window.confirm("Are you sure you want to delete that note?")){
        event.target.parentElement.remove();        
    }
}