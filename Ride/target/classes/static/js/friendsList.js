window.onload = function() {
	// creating xmlhttprequest object

	//alert("hello");
	console.log("freindslist");
	var request = new XMLHttpRequest();
	request.open("GET", "/friendsData");
	request.send();

	// this will be called when it receives response
	request.onload = function() {
		// console.log(request.responseText);
		let response = JSON.parse(request.responseText);
		console.log(request.responseText);

		
		var divElement = document.getElementById("friendsData");
		response.forEach(function(data) {
			divElement.innerHTML += "<p class='friendsList'>" + data.userName + "</p>";
			console.log(data.userName);

		})

	}

}
