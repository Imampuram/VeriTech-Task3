$(document).ready(function () {
    invokeService('http://localhost:8083/student/all');
});

function invokeService(endpoint) {
    $.ajax({
        url: endpoint,
        crossDomain: true,
        type: 'GET',
        success: function (response) {
            console.log('resp==', response);
            addAllColumnHeaders(response, "#excelDataTable");
            var len = response.length;

            for (var i = 0; i < len; i++) {
                var name = response[i].name;
                var mobile = response[i].mobile;
                var email = response[i].email;
                var course = response[i].course;
                var status = response[i].status;
                var enquiredOn = response[i].enquiredOn;

                var tr_str = "<tr>" +
                    "<td align='center'>" + name + "</td>" +
                    "<td align='center'>" + mobile + "</td>" +
                    "<td align='center'>" + email + "</td>" +
                    "<td align='center'>" + course + "</td>" +
                    "<td align='center'>" + status + "</td>" +
                    "<td align='center'>" + enquiredOn + "</td>" +
                    "</tr>";

                $("#excelDataTable").append(tr_str);
            }
        }
    });
}

function addAllColumnHeaders(myList, selector) {
    var columnSet = [];
    var headerTr$ = $('<tr/>');

    for (var i = 0; i < myList.length; i++) {
        var rowHash = myList[i];
        for (var key in rowHash) {
            if ($.inArray(key, columnSet) == -1) {
                columnSet.push(key);
                headerTr$.append($('<th/>').html(key));
            }
        }
    }
    $(selector).append(headerTr$);

    return columnSet;
}
$("a").click(function () {
    alert("The paragraph was clicked.");
});


function fetchstudent() {
    console.log('fetching student..');
    $.ajax({
        url: 'http://localhost:8083/student/all/87695468',
        crossDomain: true,
        type: 'GET',
        success: function (response) {
            console.log('resp==', response);
            addAllColumnHeaders(response, "#excelDataTable");
            var len = response.length;

            for (var i = 0; i < len; i++) {
                var name = response[i].name;
                var mobile = response[i].mobile;
                var email = response[i].email;
                var course = response[i].course;
                var status = response[i].status;
                var enquiredOn = response[i].enquiredOn;

                var tr_str = "<tr>" +
                    "<td align='center'>" + name + "</td>" +
                    "<td align='center'>" + mobile + "</td>" +
                    "<td align='center'>" + email + "</td>" +
                    "<td align='center'>" + course + "</td>" +
                    "<td align='center'>" + status + "</td>" +
                    "<td align='center'>" + enquiredOn + "</td>" +
                    "</tr>";

                $("#excelDataTable").append(tr_str);
            }
        }
    });
}



// Report Status

$(document).ready(function () {

    var $checkBox = $('#status'),
        $checkbox1 = $('#course'),
        $select1 = $('#course-option'),
        $select = $('#status-option');
    $checkBox.on('change', function (e) {
        if ($(this).is(':checked')) {
            $select.removeAttr('disabled');
        } else {
            $select.attr('disabled', 'disabled');
        }
    });
    $checkbox1.on('change', function (e) {
        if ($(this).is(':checked')) {
            $select1.removeAttr('disabled');
        } else {
            $select1.attr('disabled', 'disabled');
        }
    });
});
