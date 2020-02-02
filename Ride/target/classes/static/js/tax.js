'use strict';

function myFunction() {

	var fileId = document.getElementById("singleFileUploadInput");
	var files = fileId.files;

	if (files.length == 0) {
		alert("Invalid file");
	}
	var formData = new FormData();
	formData.append("file", files[0]);

	// creating xmlhttprequest object
	var request = new XMLHttpRequest();
	request.open("POST", "/uploadFile");
	request.send(formData);

	// this will be called when it receives response
	request.onload = function() {
		console.log(request.responseText);
		var response = JSON.parse(request.responseText);
		var download = document.getElementById("link");
		download.href = response
		download.removeAttribute("hidden")

	}

}

function submitFun() {
	document.getElementById("userForm").submit();
}