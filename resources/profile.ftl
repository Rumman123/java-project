<Html>
<head>
  <title>${title}</title>
 <link href="bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet"> 
</head>
<body>
<p class="text-center">  <h1><u> <p class="text-center">${title}</u></h1></p>


  <ul class="list-unstyled">
    <#list systems as system>
      <table class="table table-bordered">
      
     <strong>  ${system.name}</strong>  :  <em>${system.value}</em>
      
      </table>
    </#list>
  </ul>
  <p>
  <button type="button" class="btn btn-default btn-sm">EDIT</button>
  <button type="button" class="btn btn-default btn-sm">SUBMIT</button>
</p>
 </body>
</Html> 