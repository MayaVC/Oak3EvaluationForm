$(document).ready(function(){
    var currentDate = new Date();
    var day = currentDate.getDate();
    var month = currentDate.getMonth() + 1;
    var year = currentDate.getFullYear();
    $("#currentDate").html(day.toString()+"-"+month.toString()+"-"+year.toString());

    $("#select-topic").change(function(e){
        var arraySubTopicsAndTopics = new Array();
        var arraySubTopics = $(this).val();
        for (var index = 0; index < arraySubTopics.length; index++) {
            arraySubTopicsAndTopics[index].push([arraySubTopics[index], $(this.options[index]).closest('optgroup').prop('id')]);            
        }

        console.log("arraySubTopicsAndTopics = " + arraySubTopicsAndTopics);

        /* var theSelect = $(this);
        var optgroups = theSelect.getElementsByTagName('optgroup');
        var arrSubTopics = {};// object for selected subtopics
        for (var i = 0; i < optgroups.length; i++) {
            l=optgroups[i].getAttribute('id');
            releasearr[l] = [];
            var options = optgroups[i].getElementsByTagName('option');
        
            for (var j = 0; j < options.length; j++) {
                releasearr[l].push(options[j].innerHTML);
                if(options[j].selected){ // check if options is selected
                    arr[l]= [];// making array of optgroup
                    arr[l].push(options[j].innerHTML);
                }
            }
        } */




        /* alert("topic = " + e.target.parentNode.id); */
        /* arrayTopics = $(this).parentNode;
        arraySubTopics = $(this).val();
        console.log("arToppics = " + $(this.options[this.selectedIndex]).closest('optgroup').prop('id'));
        console.log("arSubToppics = " + arraySubTopics); */
    });

/* $("#submitform").click(function(){
  $.ajax({
      type: "method",
      url: "url",
      data: jsonFullString,
      dataType: "dataType",
      success: function (response) {
          
      }
  });
})   */  

    
});