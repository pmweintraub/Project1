let user;

window.onload = async function(){
     let response = await fetch("http://localhost:9000/check");

     let responseBody = await response.json();

     if(responseBody.success == false){
         window.location = "../";
     }

     if(responseBody.data.userRole == 1){
         window.location = "../employeedashboard/";
     }

     user = responseBody.data;
 }

async function createReimbursement(event){
    event.preventDefault();

    let amountInputElem = document.getElementById("amount");
    let descriptionInputElem = document.getElementById("description");
    let typeIdInputElem = document.getElementById("select-type");

    let request = {
        amount: amountInputElem.value,
        description: descriptionInputElem.value,
        usersAuthor: user,
        reimbType: typeIdInputElem.value
    }

    console.log(request)

    let response = await fetch("http://localhost:9000/reimbs/create",{
        method: "POST",
        body: JSON.stringify(user)
    })

    let responseBody = await response.json();

    console.log(responseBody)
    
}