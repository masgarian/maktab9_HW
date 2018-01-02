$(document).ready(function() {
	//$("#ssc").html("This is Hello World by JQuery YUP");
	$("#pp23").html(" !!    JQuery  !!!vfdfve!");
	
	$("#studentLoad").click(function() {
		$("#studentsTable").find("tr:not(:nth-child(1)):not(:last-child)").remove();
		//$("#studentsTable").children( 'tr:not(:first)' ).remove();
		//$("#container > h2").remove();
		$("#studentAlert").html("Clean up table!");
		
		
		$("#studentAlert").html("sending request!");
		$.get("http://localhost:8080/HW7_WUI/api/students",function(data,status){
			$("#studentAlert").html("data recievd!");
			var i;
			for(i in data){
				//$("#studentsTable" ).append("<tr>" +
				$("#studentsTable tr:nth-last-child(2)" ).after("<tr>" +
					"<td contenteditable=\"true\">"+data[i].id +"</td>" +
					"<td contenteditable=\"true\">"+data[i].name +"</td>" +
					"<td contenteditable=\"true\">"+data[i].department +"</td>" +
					"<td contenteditable=\"true\">"+data[i].teacherId +"</td>" +
					"<th><input type=\"checkbox\"></th>" +
					
				"</tr>")
					}
			$("#studentAlert").html("done!");
		});
	});
	
	$("#studentAdd").click(function() {
		
		item={}
		item["id"]=$("#inpId").val();
		item["name"]=$("#inpName").val();
		item["department"]=$("#inpDepartment").val();
		item["teacherId"]=$("#inpTeacherId").val();		
		var student=JSON.stringify(item);

		 $.ajax({url: "http://localhost:8080/HW7_WUI/api/students",
			 type: "POST", 
			 contentType:"application/json; charset=utf-8" ,
			 data:student, 
			 success:function(result){
			 if(result="true"){
				 $("#studentAlert").html("ID: "+ $("#inpId").val()+" added to list");
			 }
		 }});
	});

	
	$("#studentUpdate").click(function(){
		$("#studentAlert").html("update!");
		var i=0;
		item={}
		$("#studentsTable tr > td" ).each(function(index,element){
			//$("#temp").append($(this).text());
			switch(i%4){
			case 0:
				item={}
				item["id"]=$(this).text();
				break;
			case 1:
				item["name"]=$(this).text();
				break;
			case 2:
				item["department"]=$(this).text();
				break;
			case 3:
				item["teacherId"]=$(this).text();
				var student=JSON.stringify(item);

				$.ajax({url: "http://localhost:8080/HW7_WUI/api/students"+"/"+item.id,
					type: "PUT", 
					contentType:"application/json; charset=utf-8" ,
					data:student, 
					success:function(result){
						if(result="true"){
							$("#studentAlert").html("ID: "+ item.id+" updated");
						}
					}});
				break;
			
			}
			i++;
		
		});
		
	});

	$("#studentDelete").click(function(){
		$("#studentAlert").html("Delete!");
		var i=0;
		var id=0;
		$("#studentsTable tr > td" ).each(function(index,element){
			//$("#temp").append($(this).text());
			switch(i%4){
			case 0:
				id=$(this).text();
				$("#studentAlert").html("id"+i);
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				$("#studentAlert").html("ch"+i);
				$(this).children("input").hide();
				alert($(this).children("input").is("checked"));
				if ($(this).children("input").is(":checked"))
				{
					alert("ok");
					
					$.ajax({url: "http://localhost:8080/HW7_WUI/api/students"+"/"+id,
						type: "DELETE", 
						//contentType:"application/json; charset=utf-8" , 
						success:function(result){
							if(result="true"){
								$("#studentAlert").html("ID: "+ id+" Deleted");
							}
						}
					})};
				break;
			case 4:
				$(this).children("input").hide();
				break;
				}
			i++;
		
		});
		
	});
});
