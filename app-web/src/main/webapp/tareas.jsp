<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase2 HTML</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body onload="bootstrapApp();">
    <main>
    	<div id="root"></div>
    </main>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Components/App.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Components/Container.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Components/List.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Components/Item.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Components/index.js"></script>
</html>