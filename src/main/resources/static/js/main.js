
$( function(){
    
    var $users = $('#users');
   
    
    $.ajax({
        type:'Get',
        url:'mpesa/users',
        success:function(users){
            $.each(users, function(i,user){
                $users.append(
                        '<tr>'+
                        '<th scope="row">' + (i+1) + '</th> ' +
                        '<td>' + user.firstName + '</td>' +
                        '<td>' + user.secondName + '</td>' +
                        '<td>' + user.thirdName + '</td>' +
                        '<td>' + user.phoneNumber + '</td>' +
                        ' <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registerModel" data-whatever="@mdo"> Edit </button></td>'
                        + '<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#accountModal"> Account </button></td>'
                        + '<td><a class="btn btn-danger text-light" th:href="@{#}"> Delete </a></td>' +
                        '</tr>');
            });
        }
    });
});