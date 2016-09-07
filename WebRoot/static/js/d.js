function add(){
      var obj=document.getElementById("d1");
	   obj.innerHTML="&nbsp;&nbsp;今天是："+new Date().toLocaleString();
	}


    setInterval("add()",100);