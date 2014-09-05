<Html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>

  <p>${exampleObject.name} and its ${exampleObject.value}</p>

  <ul>
    <#list systems as system>
      <li>${system_index + 1}. ${system.name} : ${system.value}</li>
    </#list>
  </ul>
 </body>
</Html> 