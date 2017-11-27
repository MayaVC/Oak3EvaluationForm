$(document).ready(function(){
    const url = "http://localhost:8086/evaluationform";
    const currentDate = new Date();
    const day = currentDate.getDate();
    const month = currentDate.getMonth() + 1;
    const year = currentDate.getFullYear();
    $("#currentDate").html(day.toString()+"-"+month.toString()+"-"+year.toString());


//******************** event listeners **********************************************

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
    console.log("findAllInstructors : function");
    $.ajax({
        type: "get",
        url: url + "/instructors",
        dataType: "json",
        success: function (response) {
            console.log("findAllInstructors : success");
            console.log("response = " + response);
            let instructors = response;
            let dynamicHTML = "";
            for (let instr of instructors){
                dynamicHTML += `<option value=${instr.id}>${instr.id}  ${instr.name}</option>`;
            }
            console.log("dynamicHTML = " + dynamicHTML);
            $("#dropdownlist-instructor").html(dynamicHTML);
        },
        error: function(){
            console.log("Error find all instructors");
        }
    });
}

function findAllCourses() {
    console.log("findAllCourses : function");
    $.ajax({
        type: "get",
        url: url + "/courses",
        dataType: "json",
        success: function (response) {
            console.log("findAllCourses : success");
            console.log("response = " + response);
            let courses = response;
            let dynamicHTML = "";
            for (let aCourse of courses){
                dynamicHTML += `<option value=${aCourse.id}>${aCourse.id}  ${aCourse.name}</option>`;
            }
            console.log("dynamicHTML = " + dynamicHTML);
            $("#dropdownlist-course").html(dynamicHTML);
        },
        error: function(){
            console.log("Error find all courses");
        }
    });
}

function findQuestionsByCategory(category) {
    console.log("findQuestionsByCategory : function");
    $.ajax({
        type: "get",
        url: url + "/questions/" + category,
        dataType: "json",
        success: function (response) {
            console.log("findQuestionsByCategory : success");
            console.log("response = " + response);
            let questions = response;
            let dynamicHTML = "";
            for (let aQuestion of questions) {
                dynamicHTML += `<div class="col-md-5 col-sm-12 col-xs-12">
                                    <label>
                                        ${aQuestion.name}
                                    </label>
                                </div>
                                <div class="col-md-7 col-sm-12 col-xs-12">
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="0">0
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category} id="score1" value="1">1
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category} id="score2" value="2">2
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category} id="score3" value="3">3
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category} id="score4" value="4">4
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category} id="score5" value="5">5
                                        </label>
                                    </div>
                                </div>`;
            }
            console.log("dynamicHTML = " + dynamicHTML);
            $("#questions-cat-general").html(dynamicHTML);
        },
        error: function () {
            console.log("Error find questions by category");
        }
    });
}

function findAllQuestions() {
    findQuestionsByCategory("GENERAL");
    //findQuestionsByCategory("CONTENT");
    //findQuestionsByCategory("CLASSROOM");
    //findQuestionsByCategory("INSTRUCTOR");
}

//*********************** methods *******************************

findAllInstructors(); //get list of instructors for dropdown list

findAllCourses(); //get list of courses for dropdown list

findAllQuestions(); //get list of questions by category

    
});