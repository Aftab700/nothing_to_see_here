from flask import Flask
from flask_cors import CORS
import json
import random


app = Flask(__name__)
CORS(app)


with open("Daily_Stoic.json") as f:
    json_data = json.load(f)


@app.route("/")
def hello_world():
    return "Hello from Flask!"


@app.route("/api")
def random_stoic_quote():
    global json_data
    return random.choice(json_data)
