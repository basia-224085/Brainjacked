require('dotenv/config');
const express = require('express');
const app = express();
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');

const userRoute = require('./src/routes/users');

const url = process.env.DB_CONNECTION;
const port = process.env.PORT;

app.use(cors());
app.use(bodyParser.json());

app.use('/users', userRoute);

app.get('/', (req, res) => {
    res.send('Brainjack, hijack your brain!')
})

mongoose.connect(url, {
    useNewUrlParser: true,
    useUnifiedTopology: true
}, () => console.log('connected to Database '));

app.listen(port);