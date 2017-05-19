var response;
var obj;
source = new EventSource('stream');
source.onmessage = function (e) {

    obj = JSON.parse(e.data);
    response = obj;
    console.log(response);
};


console.log(response);

//Lets add the keyboard controls now
$(document).keydown(function (e) {
    var key = e.which;
    document.getElementById("keypress").value = key;
    sendPlayerPosition();

});

// TODO Send Keystroke to server			   
function sendPlayerPosition() {
    if (true) {
        var xmlhttprequest = new XMLHttpRequest();
        var keypress = document.getElementById("keypress").value;
        //send keystroke to servlet
        xmlhttprequest.open("POST", "UpdateGame?keypress=" + keypress, true);
        xmlhttprequest.send();
    } else {
        return;
    }
}

function restart() {
        var xmlhttprequest = new XMLHttpRequest();
             
        //send keystroke to servlet
        xmlhttprequest.open("DELETE", "restart game", true);
        xmlhttprequest.send();
}

function restart1() {
        var xmlhttprequest = new XMLHttpRequest();
             
        //send keystroke to servlet
        xmlhttprequest.open("DELETE", "restart game", true);
        xmlhttprequest.send();
        window.location = "";
}


/*Canvas stuff*/
var canvas = $("#canvas");
var ctx = canvas[0].getContext("2d");
var w = canvas.width();
var h = canvas.height();

/*Lets save the cell width in a variable for easy control*/
var cw = 10; /*width of one element (food/players)*/

/*Lets paint the canvas now*/
ctx.fillStyle = "white";
ctx.fillRect(0, 0, w, h);
ctx.strokeStyle = "black";
ctx.strokeRect(0, 0, w, h);


function init() {

    /* Trigger the paint function every 100ms to update the canvas*/
    if (typeof game_loop !== "undefined")
        clearInterval(game_loop);
    game_loop = setInterval(paint, 100);

    
}

init();

/*Lets paint the player now*/
function paint() {

    /*Lets paint the canvas now*/
    ctx.fillStyle = "white";
    ctx.fillRect(0, 0, w, h);
    ctx.strokeStyle = "black";
    ctx.strokeRect(0, 0, w, h);

    /*Lets paint players*/
    var players = response.PLAYERS;
    var pLength = players.length;

    for (i = 0; i < pLength; i++) {
        paint_player(players[i][0], players[i][2], players[i][3]);
        updateScoreboard(players[i][0], players[i][1]);
    }

    /*Lets paint the food*/
    var foods = response.DOTS;
    var fLength = foods.length;

    for (i = 0; i < fLength; i++) {
        paint_food(foods[i][0], foods[i][1], foods[i][2]);
    }
    
    check(players, foods);


}

function check(players, foods) {   //printing result
    var Length = foods.length;
    var eat_count = 0;

    for (i = 0; i < Length; i++) {
        if (foods[i][1] === -1 && foods[i][2] === -1) {
            eat_count++;
        }
    }

    if (eat_count === Length) {

        var mx = Math.max(players[0][1], players[1][1], players[2][1], players[3][1]);

        document.write("<!DOCTYPE html>");
        document.write("<head>");
        document.write("</head>");
        document.write("<body>");
        document.write("<html lang=\"en\">");
        document.write(" <center><h1>Game Over</h1> <center>");
        document.write("<div>");
        document.write("<table>");
        document.write("<tr style=\"background-color: #4CAF50;\">");
        document.write("<th><center>Player</center></th>");
        document.write("<th><center>Score</center></th>");
        document.write("</tr>");
        document.write("<tr>");
        document.write("<td>PLAYER1</td>");
        document.write("<td><center>" + players[0][1] + "</center></td>");
        document.write("</tr>");
        document.write("<tr style=\"background-color: #f2f2f2;\">");
        document.write("<td>PLAYER2</td>");
        document.write("<td><center>" + players[1][1] + "</center></td>");
        document.write("</tr>");
        document.write("<tr>");
        document.write("<td>PLAYER3</td>");
        document.write("<td><center>" + players[2][1] + "</center></td>");
        document.write("</tr>");
        document.write("<tr style=\"background-color: #f2f2f2;\">");
        document.write("<td>PLAYER4</td>");
        document.write("<td><center>" + players[3][1] + "</center></td>");
        document.write("</tr>");
        document.write("</table>");
        document.write("</div>");

        if (players[0][1] === mx) {
            document.write(" <center><h3>Player 1 WINS...!!!</h3><center>");
        }
        if (players[1][1] === mx) {
            document.write(" <center><h3>Player 2 WINS...!!!</h3><center>");
        }
        if (players[2][1] === mx) {
            document.write(" <center><h3>Player 3 WINS...!!!</h3><center>");
        }
        if (players[3][1] === mx) {
            document.write(" <center><h3>Player 4 WINS...!!!</h3><center>");

        }
        
        document.write("<div>");
        document.write("<button onclick=\"restart1()\">Play Again!!!</button>");
        document.write("<script src=\"script.js\"></script>");
        document.write("</div>");
        document.write("</body>");
        document.write("</html>");
        
        clearInterval(game_loop);
    }
}


paint();

/*Function to paint players*/
function paint_player(type, x, y) {
    switch (type) {
        case "P1":
            ctx.fillStyle = "yellow";
            ctx.strokeStyle = "black";
            break;
        case "P2":
            ctx.fillStyle = "orange";
            ctx.strokeStyle = "black";
            break;
        case "P3":
            ctx.fillStyle = "cyan";
            ctx.strokeStyle = "black";
            break;
        case "P4":
            ctx.fillStyle = "pink";
            ctx.strokeStyle = "black";
            break;
        default:
            ctx.fillStyle = "yellow";
            ctx.strokeStyle = "black";
    }
    ctx.beginPath();
    ctx.arc((x * cw) + 5, (y * cw) + 5, 5, 0, 2 * Math.PI, false);
    ctx.fill();
    ctx.stroke();

}

/*Function to paint food particles*/
function paint_food(type, x, y) {
    switch (type) {
        case "R":
            ctx.fillStyle = "red";
            ctx.strokeStyle = "red";
            break;
        case "G":
            ctx.fillStyle = "green";
            ctx.strokeStyle = "green";
            break;
        case "B":
            ctx.fillStyle = "blue";
            ctx.strokeStyle = "blue";
            break;
        default:
            ctx.fillStyle = "red";
            ctx.strokeStyle = "red";
    }
    ctx.beginPath();
    ctx.arc((x * cw) + 5, (y * cw) + 5, 5, 0, 2 * Math.PI, false);
    ctx.fill();
    ctx.stroke();
}

function updateScoreboard(id, score) {
    var scoreId = "td." + id;
    var scoreValue = "td.Score" + id;
    $(scoreId).text(id);
    $(scoreValue).text(score);
}
