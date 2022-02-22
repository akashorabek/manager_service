<#macro renderWith title="Avtolavka" scripts=[] styles=[]>

    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>

        <link rel="stylesheet" href="/css/bootstrap.min.css">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <header class="header">
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Avtolavka</a>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="/">Главная</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/orders">Заявки (КП)</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/clients">Клиенты</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Товары</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <label>
                        <input class="form-control me-2" type="search" placeholder="Найти">
                        </label>
                        <button class="btn btn-outline-success" type="submit" aria-label="Search">Найти</button>
                        <button type="submit" class="btn btn-outline-success btn-sm">
                            <span class="glyphicon glyphicon-log-out">Выйти</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
    </header>

    <div class="container mt-5">
        <#nested>
    </div>

    <#list scripts as scriptSource>
        <script src="/js/jquery.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>

</#macro>