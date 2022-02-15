<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[]>

    <h1 class="my-3">Clients</h1>
    <div class="container">
        <#list clients as client>
            ${client.id} ${client.name}
        </#list>
    </div>
</@main.renderWith>