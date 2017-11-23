$(document).ready(function(){
    var currentDate = new Date();
    var day = currentDate.getDate();
    var month = currentDate.getMonth() + 1;
    var year = currentDate.getFullYear();
    $("#currentDate").html(day.toString()+"-"+month.toString()+"-"+year.toString());
});