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
  <ul>
    <#list systems as system>
      <li>${system_index + 1}. ${system.name} : ${system.value}</li>
    </#list>
  </ul>
  <button type="button" class="btn btn-primary">Primary</button>
 </body>
</Html> 