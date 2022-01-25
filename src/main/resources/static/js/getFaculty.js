function getFaculty() {
    // const request = new XMLHttpRequest();
    // const url = "schedule/faculty";
    // request.open('GET', url);
    // request.setRequestHeader('Content-Type', 'application/json');
    // request.addEventListener("readystatechange", () => {
    //     if (request.readyState === 4 && request.status === 200) {
    //         console.log( request.responseText );
    //     }
    // });
    // request.send();
    $.ajax({
        url: 'schedule/faculty',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            for (let key in data) {
                faculty.innerHTML += '<option value = "' + data[key].id+'">' + data[key].name + '</option>';
            }
        }, error: function (error) {
            alert(error);
        }
    });
}