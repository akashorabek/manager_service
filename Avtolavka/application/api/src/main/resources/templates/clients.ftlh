<#import "partials/header.ftlh" as main>
<#import "partials/pagination.ftlh" as pagination>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3">Клиенты</h1>
    <a class="btn btn-primary" href="/clients/add">Создать клиента</a>
    <a class="btn btn-primary" href="/orders/add">Создать КП</a>
    <a class="btn btn-primary" href="/products/send-price">Отправить прайс</a>
    <br>
    <div class="container mb-3">
        <table class="table table-hover mt-3">
            <thead class="table-light">
            <tr>
                <th>Id клиента</th>
                <th>Наименование</th>
                <th>Краткое наименовние</th>
                <th>Номер счета</th>
                <th>Адрес</th>
                <th>Телефон</th>
                <th>E-mail</th>
                <th>Статус</th>
            </tr>
            </thead>

            <#list page.content as client>
                <tr class="position-relative">
                    <td>${client.id}</td>
                    <td>
                        <a href="/clients/${client.id}" class="stretched-link" style="text-decoration: none; color: black">
                            ${client.name}
                        </a>
                    </td>
                    <td>${client.shortName}</td>
                    <td>${client.accountNumber}</td>
                    <td>${client.address}</td>
                    <td>${client.phone}</td>
                    <td>${client.email}</td>
                    <td>${client.status}</td>
                </a>
                </tr>
            </#list>
        </table>
    </div>
    <@pagination.pagination page=page link="/clients?"></@pagination.pagination>
</@main.renderWith>