$('#faculty').on('change', function() {
    var select = document.getElementById("faculty");
    var id = select.value;

    $.ajax({
        url: 'schedule/department/' + id,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            for (let key in data) {
                department.innerHTML += '<option value = "' + data[key].id + '">' + data[key].name + '</option>';
            }
        }, error: function (error) {
            alert(error);
        }
    });
});