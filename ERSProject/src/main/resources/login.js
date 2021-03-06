document.getElementById("login-form").addEventListener("submit", async function (event){
    event.preventDefault();

    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");

    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value
    }

    console.log(usernameInputElem.value, passwordInputElem.value)

    let response = await fetch("http://localhost:9000/login",{
        method: "POST",
        body: JSON.stringify(user)
    })

    let responseBody = await response.json();

    if(responseBody.success){
        if(responseBody.data.userRole == 2){
            window.location = "./managerdashboard";
        }else{
            window.location = "./employeedashboard";
        }
    }


})