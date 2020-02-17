$=(id)=>document.getElementById(id);

onSubmit = ()=>{
	
	//event.preventDefault();
	
	var name=$("name").value;
	var groupName=$("groupName").value;
	var email=$("email").value;
	var password=$("password").value;
	var resetPassword=$("resetPassword").value;
	
	if(password.localeCompare(resetPassword)==0){
		$("submit").submit();
	}else{
		alert("failed");
	}
		
}

window.onload=function(){
	$("submit").onclick=onSubmit;
}