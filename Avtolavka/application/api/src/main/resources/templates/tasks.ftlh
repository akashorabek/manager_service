<#import "partials/header.ftlh" as main>
<#import "partials/pagination.ftlh" as pagination>

<@main.renderWith scripts=[] styles=[]>


    <a class="btn btn-secondary" href="/tasks/add">Создать клиента</a>


    <div class="container mb-3">
       <table class="table table-hover mt-3">
          <thead class="table-light">
    <tr>
        <th>Наименование</th>
        <th>Дата создания</th>
        <th>Срок выполнения</th>
        <th>Статус</th>
    </tr>
    </thead>
<#--<#if tasks??>-->
    <#list page.content as task>
        <tr class="position-relative">
            <td>
                <a href="/tasks/${task.id}" class="stretched-link" style="text-decoration: none; color: black">
                    ${task.name}
                </a>
            </td>
            <td>${task.createDate}</td>
            <td>${task.deadline}</td>
            <td>${task.status}</td>
        </tr>
    </#list>
<#--</#if>-->

    </table>
    </div>

    <@pagination.pagination page=page link="/tasks?"></@pagination.pagination>
</@main.renderWith>