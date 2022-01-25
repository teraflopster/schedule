// function getLecture() {
//     const request = new XMLHttpRequest();
//     const url = "schedule/lecture/02.16.2022/10";
//     request.open('GET', url);
//     request.setRequestHeader('Content-Type', 'application/json');
//     request.responseType = "json";
//     request.addEventListener("readystatechange", () => {
//         if (request.readyState === 4 && request.status === 200) {
//                 console.log( request );
//         }
//     });
//     request.send();
// }

$('#day').on('change', function() {

    $("#lessons").html("");

    var day_id = document.getElementById("day");
    var dayId = day_id.value;

    var select_group = document.getElementById("group");
    var id = select_group.value;

    $.ajax({
        url: "schedule/lecture/" + dayId + "/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            let count = 1;
            for (let key in data) {
                lessons.innerHTML += '<p>' + count++ + " " + data[key].theme + " "
                    + data[key].teacher + " " + data[key].lectureHall + '</p>';
            }
        }, error: function (error) {
            alert(error);
        }
    });
});