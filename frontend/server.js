const express = require('express');
const axios = require('axios');
const app = express();

app.get('/', async (req, res) => {
    try{
        const response = await axios.get('http://localhost:8080');
        res.send(`<h1>${response.data}</h1>`);
    }catch (err){
        res.send('<h1>Error fetching from backend</h1>')
    }
});

app.listen(3000, ()=> console.log("Frontend running on port 3000"));