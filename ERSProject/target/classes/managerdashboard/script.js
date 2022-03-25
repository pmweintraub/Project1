let user;

window.onload = async function(){

    let response = await fetch("http://localhost:9000/check");

    let responseBody = await response.json();

    if(!responseBody.success){
        window.location = "../";
    }

    if(responseBody.data.userRole == 2){
        window.location = "../managerdashboard/";
    }

    user = responseBody.data;
}