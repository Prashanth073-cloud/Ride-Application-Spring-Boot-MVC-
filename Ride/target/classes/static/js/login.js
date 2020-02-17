$=(id)=>document.getElementById(id);

onSubmit = ()=>{
	
	//event.preventDefault();
	alert("clicked")
	$("submit").submit();
		
}

window.onload=function(){
	$("submit").onclick=onSubmit;
}