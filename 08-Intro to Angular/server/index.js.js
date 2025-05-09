const host = "localhost";
const port = 8000;

const express = require("express");
const app = express();
const cors = require("cors");

app.use(express.json());
// Enables CORS
app.use(cors());

app.listen(port, host, () => {
    console.log(`Server runs on http://${host}:${port}`);    
});

const users = [
    {username: "Etienne", password: "etienne"}
];
const messages = [];

app.get("/users", (req, res) => {
    res.send(users.map(user => user.username));
});

app.post("/check-user", (req, res) => {
    
    const username = req.body.username;
    const password = req.body.password;

    if(!username || !password) {
        res.status(400).send("Missing username or password!");
        return;
    }

    if(users.some(user => user.username === username && user.password === password)) {
        res.status(200).send({
            'username': username
        });
    } else {
        res.status(404).send("Incorrect username or password!");
        return;
    }
});

app.post("/users", (req, res) => {
    
    const username = req.body.username;
    const password = req.body.password;

    if(!username || !password) {
        res.status(400).send("Missing username or password!");
        return;
    }

    if(users.some(user => user.username === username)){
        res.status(400).send("This username is not available!");
        return;
    }

    users.push({
        'username': username,
        'password': password
    });

    res.status(201).send({"username": username});
});

app.get("/messages", (req, res) => {
    res.status(200).send(messages);
});

app.post("/messages", (req, res) => {

    const author = req.body.author;
    const content = req.body.content;

    if(!content) {
        res.status(400).send("The message can't be empty!");
        return;
    }

    messages.push({
        'author': author,
        'date': new Date(),
        'content': content
    });

    res.status(201).send("Message sent successfully!");
});

app.get('/doc', (req, res) => {
    res.status(200).send({
        "routes" : [
            {"method" : "GET", "path" : "/users", "description" : "Get the username of all registered users",  "params" : []},
            {"method" : "POST", "path" : "/check-user", "description" : "Checks if the given user exists. Returns its username if it is found, or a 404 if it isn't.", "params" : ["username", "password"]},
            {"method" : "POST", "path" : "/users", "description" : "Add the given user to the app users.", "params" : ["username", "password"]},
            {"method" : "GET", "path" : "/messages", "description" : "Get all messages.", "params" : []},
            {"method" : "POST", "path" : "/messages", "description" : "Add the given message to the app messages. Automatically gives it the correct timestamp.", "params" : ["author", "content"]}
        ]
    });
});

