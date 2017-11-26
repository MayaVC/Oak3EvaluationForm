$(document).ready(function(){
    const url = "http://localhost:8086/evaluationform";
    const currentDate = new Date();
    const day = currentDate.getDate();
    const month = currentDate.getMonth() + 1;
    const year = currentDate.getFullYear();
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

//*******************functions ************************************************************************


function findAllInstructors() {
    $.ajax({
        type: "get",
        url: url + "/instructors",
        dataType: "json",
        success: function (response) {
            console.log("findAllInstructors : success");
            let instructors = response;
            let dynamicHTML;
            for (let instr of instructors){
                dynamicHTML += `<option value=${instr.id}>${instr.id} - ${instr.name}</option>`;
            }
            $("#dropdownlist-instructor").html(dynamicHTML);
        },
        error: function(){
            console.log("Error find all instructors")
        }
    });
}


findAllInstructors(); //get list of instructors for dropdown list
    
});