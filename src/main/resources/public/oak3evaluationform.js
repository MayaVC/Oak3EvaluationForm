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


function showAllInstructors() {
    //console.log("showAllInstructors : function");
    $.ajax({
        type: "get",
        url: url + "/instructors",
        dataType: "json",
        success: function (response) {
            //console.log("showAllInstructors : success");
            //console.log("response = " + response);
            let instructors = response;
            let dynamicHTML = "";
            for (let instr of instructors){
                dynamicHTML += `<option value=${instr.id}>${instr.id}  ${instr.name}</option>`;
            }
            //console.log("dynamicHTML = " + dynamicHTML);
            $("#dropdownlist-instructor").html(dynamicHTML);
        },
        error: function(){
            console.log("Error show all instructors");
        }
    });
}

function showAllCourses() {
    //console.log("showAllCourses : function");
    $.ajax({
        type: "get",
        url: url + "/courses",
        dataType: "json",
        success: function (response) {
            //console.log("showAllCourses : success");
            //console.log("response = " + response);
            let courses = response;
            let dynamicHTML = "";
            for (let aCourse of courses){
                dynamicHTML += `<option value=${aCourse.id}>${aCourse.id}  ${aCourse.name}</option>`;
            }
            //console.log("dynamicHTML = " + dynamicHTML);
            $("#dropdownlist-course").html(dynamicHTML);
        },
        error: function(){
            console.log("Error show all courses");
        }
    });
}

function showQuestionsByCategory(category) {
    //console.log("showQuestionsByCategory : function");
    $.ajax({
        type: "get",
        url: url + "/questions/" + category,
        dataType: "json",
        success: function (response) {
            //console.log("showQuestionsByCategory : success");
            //console.log("response = " + response);
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
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="0" checked required>0
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="1" required>1
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="2" required>2
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="3" required>3
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="4" required>4
                                        </label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="radio" name=${aQuestion.category}Q${aQuestion.id} id=${aQuestion.id} value="5" required>5
                                        </label>
                                    </div>
                                </div>`;
            }
            //console.log("dynamicHTML = " + dynamicHTML);
            category = category.toLowerCase();
            $("#questions-cat-"+category).html(dynamicHTML);
        },
        error: function () {
            console.log("Error show questions by category");
        }
    });
}

function showAllQuestions() {
    showQuestionsByCategory("GENERAL");
    showQuestionsByCategory("CONTENT");
    showQuestionsByCategory("CLASSROOM");
    showQuestionsByCategory("INSTRUCTOR");
}

function showAllTopics() {
    //console.log("showAllTopics : function");
    $.ajax({
        type: "get",
        url: url + "/topics",
        dataType: "json",
        success: function (response) {
            //console.log("showAllTopics : success");
            //console.log("response = " + response);
            let topics = response;
            let dynamicHTML = "";
            for (let aTopic of topics){
                dynamicHTML += `<optgroup id=topic${aTopic.id} label=${aTopic.name} class="topic">
                                </optgroup>`;
            }
            //console.log("dynamicHTML = " + dynamicHTML);
            $("#select-subtopic").html(dynamicHTML);
            showAllSubtopics(); //show all subtopics of each topic
        },
        error: function(){
            console.log("Error show all topics");
        }
    });
}

function showAllSubtopics() {
    //get all <optgroup> elements in document
    let allOptgroups = document.getElementsByClassName("topic");
    for (let aOptgroup of allOptgroups) {
        // extract id of optgroup by deleting the word "topic" of "topic#"
        let aTopicId = aOptgroup.id.substring(5);
        console.log("optgroup id = " + aTopicId);
        showAllSubtopicsByTopicId(aTopicId);
    }
}

function showAllSubtopicsByTopicId(topicId) {
    //console.log("findAllSubTopicsByTopicId : function");
    $.ajax({
        type: "get",
        url: url + "/subtopics/"+topicId,
        dataType: "json",
        success: function (response) {
            console.log("findAllSubtopicsByTopiId : success");
            let subtopics = response;
            let dynamicHTML = "";
            for (let aSubtopic of subtopics){
                dynamicHTML += `<option value=${aSubtopic.id}>${aSubtopic.name}</option>`;
            }
            console.log("dynamicHTML subtopics= " + dynamicHTML);
            $("#topic"+topicId).html(dynamicHTML);
        },
        error: function(){
            console.log("Error find all subtopicsByTopicId");
        }
    });
}

//*********************** methods *******************************

showAllInstructors(); //get list of instructors for dropdown list

showAllCourses(); //get list of courses for dropdown list

showAllQuestions(); //show list of questions by category

showAllTopics(); //show all topics

});