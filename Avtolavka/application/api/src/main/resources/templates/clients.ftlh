<#import "partials/header.ftlh" as main>
<#import "partials/paginationRest.ftlh" as pagination>

<@main.renderWith scripts=["/js/clients.js"] styles=["/css/clients.css"]>

    <div id="containerClients"></div>
    <@pagination.pagination page=page link="/clients?"></@pagination.pagination>

</@main.renderWith>