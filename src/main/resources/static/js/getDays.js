function getDays() {
    $.ajax({
        url: 'schedule/day/',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            for (let key in data) {
                day.innerHTML += '<option value = "' + data[key].id + '">' + data[key].localDate + '</option>';
            }
        }, error: function (error) {
            console.log(error);
        }
    });
}