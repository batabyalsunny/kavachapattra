/**
 * 
 */

var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/join');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        initChat();
    });
}

function getConnectedUsers() {
	stompClient.subscribe('/queue/users/', function (response) {
		showUsers(JSON.parse(response.body));
    });
}

function initChat() {
	
	// Send the init request.
	stompClient.send("/chat/init", {}, JSON.stringify({'userId': $('#ownUserId').val()}));

	// Get own connection id.
	stompClient.subscribe("/queue/init/ack", response => {
		var connectionId = JSON.parse(response.body).connectionId;
		getConnectedUsers();
		getMessages(connectionId);
	});
}

function getMessages(connectionId) {
	// Subscribe to own connection id.
	stompClient.subscribe('/queue/recieve/' + connectionId, message => {
        showMessages(JSON.parse(message.body).content);
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage(chatId) {
    stompClient.send("/chat/send/" + chatId, {}, JSON.stringify({'content': $("#message").val()}));
}

function showMessages(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

function showUsers(user) {
	$("#users").append("<tr><td>" + user + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#send" ).click(function() { sendMessage('6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b'); });
});