function saveStudent() {

    let id = $('#student_id').val();
    let name = $('#student_name').val();
    let email = $('#student_email').val();
    let phone = $('#student_phone').val();

    $.ajax({
        type: "POST",
        url: "/students/saveStudent",
        data: {id: id, name: name, email: email, phone: phone},
        success: function (response) {
            console.log(response);
            let finalResponse = JSON.stringify(response);
            $('#responseDiv').html("Your response: " + finalResponse);
        },
        error: function (error) {
            console.log(error);
        }
    });
}