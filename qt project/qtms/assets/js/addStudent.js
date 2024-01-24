 
      $( document ).ready(function() {
		  
	     getAllCourses();getRegStatuses();submitStudRegForm();
		
	  });
	  
	  function submitStudRegForm() {
	       const btn = document.querySelector('#regsubmit');
           const form = document.querySelector('#studregform');
		   console.log('form==',form);
           btn.addEventListener('click', (event) =>  {
		   event.preventDefault();
		   let data = new FormData(form);
		   let userValues = Object.fromEntries(data.entries());
		   let studjson = JSON.stringify(userValues);
		   console.log('json string==',studjson);
		   var url = 'http://localhost:9091/student/create';
		   var http = new XMLHttpRequest();
		   http.open('POST', url, true);
		   //Send the proper header information along with the request
		   http.setRequestHeader('Content-type', 'application/json');
		   http.onreadystatechange = function() {//Call a function when the state changes.
		   if(http.readyState == 4 && http.status == 200) {
			  alert(http.responseText);
			  console.log('response Recived successfully..');
		   }
		 }
		 http.send(studjson);
		 console.log('request submitted successfully..');
		
       });
	}
      
  function getAllCourses() {
  
            $.ajax({
            url: 'http://localhost:9091/course/all',
            type: 'GET',
            success:function(response){
			console.log(response);
              var len = response.length;
			   for( var i = 0; i<len; i++){
                    var id = response[i]['id'];
                    var name = response[i]['name'];
                    
                    $("#course").append("<option value='"+id+"'>"+name+"</option>");
				}
			 }
			});
  
  }
  function getRegStatuses() {
  
            $.ajax({
            url: 'http://localhost:9091/student/registration/status/all',
            type: 'GET',
            success:function(response){
			console.log(response);
              var len = response.length;
			   for( var i = 0; i<len; i++){
                    var codevalue = response[i]['codevalue'];                  
                    $("#studregsts").append("<option value='"+codevalue+"'>"+codevalue+"</option>");
				}
			 }
			});
  
  }
  
  