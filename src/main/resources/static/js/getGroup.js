$('#course').on('change', function() {

    var select_department = document.getElementById("department");
    var id = select_department.value;

    var select_course = document.getElementById("course");
    var course = select_course.value;

    $.ajax({
        url: 'schedule/group/' + course + '/' + id,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            for (let key in data) {
                group.innerHTML += '<option value = "' + data[key].id+'">' + data[key].name + '</option>';
            }
        }, error: function (error) {
            alert(error);
        }
    });
});