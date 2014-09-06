<Html>
<head>
  <title>${title}</title>
 <link href="bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet"> 
</head>
<body>
<p class="text-center">  <h1><u>${title}</u></h1></p>
<div class="container">
${exampleObject.name} and its ${exampleObject.value}
</div>
  <ul class="list-unstyled">
    <#list systems as system>
      <table class="table table-bordered">
      
      ${system_index + 1}  ${system.name} </td> <td>${system.value}</td>
      </tr>
      </table>
    </#list>
  </ul>
  <p>
  <button type="button" class="btn btn-primary btn-sm">EDIT</button>
  <button type="button" class="btn btn-default btn-sm">SUBMIT</button>
</p>
 </body>
</Html> 