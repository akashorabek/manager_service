<#import "partials/header.ftlh" as main>
<#import "partials/pagination.ftlh" as pagination>

<@main.renderWith scripts=[] styles=[]>


    <a class="btn btn-secondary" href="/tasks/add">Создать задачу</a>


    <div class="container mb-3">
       <table class="table table-hover mt-3">
          <thead class="table-light">
    <tr>
        <th>Наименование</th>
        <th>Дата создания</th>
        <th>Срок выполнения</th>
        <th>Приоритет</th>
    </tr>
    </thead>

    <#list page.content as task>
        <tr class="position-relative" style="background-color:<#if task.status == "Высокий">rgba(243, 216, 87);</#if><#if task.status == "Средний">rgba(255, 248, 138);</#if><#if task.status == "Текущий">rgba(255, 255, 222);</#if>">
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


    </table>
    </div>

    <@pagination.pagination page=page link="/tasks?"></@pagination.pagination>
</@main.renderWith>