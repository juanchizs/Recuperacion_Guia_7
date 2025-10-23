let businessList = [];

function mainFunction() {
    const httpRequestType = document.getElementById('httpRequestType');
    const pathVariableInput = document.getElementById('PathVariable');
    const bodyTextarea = document.getElementById('body');
    const selectedValue = httpRequestType.value;


    switch(selectedValue) {
        case 'FindAll':
            fetch('http://localhost:8085/findAllBusiness')
                //guardamos la respuesta en una variable llamada businessList
                .then(response => response.json())
                .then(data => {
                    // Convertir cada objeto JSON a string y guardarlo en el array
                    businessList = data.map(item => JSON.stringify(item));
                    console.log('Lista guardada:', businessList);
                })
            break;

        case 'Save':
            // let options = {
            //     method: 'POST',//tipo de peticion HTTP
            //     //con esta mamada le decimos que tipo de contenido va a recibir, en este caso json
            //     headers: { 'Content-Type': 'application/json'},
            //     body: JSON.stringify(bodyTextarea.value)// conviertimos el texto del textarea a json
            // }
            // fetch('http://localhost:8085/saveBusiness', options)


            fetch("http://localhost:8085/saveBusiness", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: bodyTextarea.value
            })
                .then(response => response.json())
                .then(data => {
                    businessList.push(data); // Add the single object to the list
                    console.log("Business list:", businessList);
                })
                .catch(error => {
                    console.error("Error saving business:", error);
                });
            break;

        case 'delete':
            fetch('http://localhost:8085/deleteBusiness/' + pathVariableInput.value, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => {
                if (response.ok) {
                    console.log('Successfully deleted');
                } else {
                    console.error('Delete failed');
                }
            })
            .catch(error => console.error('Error:', error));
            break;

        case 'findBusinessById':
        case 'findBusinessByname':
        default:
    }
}



function checkTypeOfRequest() {
    const httpRequestType = document.getElementById('httpRequestType');
    const pathVariableInput = document.getElementById('PathVariable');
    const bodyTextarea = document.getElementById('body');
    const selectedValue = httpRequestType.value;
    console.log('Valor seleccionado:', selectedValue);

    switch(selectedValue) {
        case 'Save':
            pathVariableInput.style.display = 'none';
            bodyTextarea.style.display = 'block';
            break;
        case 'delete':
        case 'findBusinessById':
        case 'findBusinessByname':
            pathVariableInput.style.display = 'block';
            bodyTextarea.style.display = 'none';
            break;
        case 'FindAll':
        default:
            pathVariableInput.style.display = 'none';
            bodyTextarea.style.display = 'none';
    }
}