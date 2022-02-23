<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <br>
    <br>
    <h1 class="my-3">Клиенты</h1>
    <div class="container">
        <a class="btn btn-primary" href="/clients/add">Создать клиента</a>
        <a class="btn btn-primary" href="/orders/add">Создать КП</a>
        <a class="btn btn-primary" href="/prices/send">Отправить прайс</a>
        <br>
        <br>
        <table class="table table-hover mt-3">
            <thead class="table-light">
            <tr>
                <th>Id клиента</th>
                <th>Наименование</th>
                <th>Номер счета</th>
                <th>Адрес</th>
                <th>Телефон</th>
                <th>E-mail</th>
                <th>Статус</th>
            </tr>
            </thead>

            <#list clients as client>
                <tr class="position-relative">
                    <td>${client.id}</td>
                    <td>
                        <a href="/clients/${client.id}" class="stretched-link" style="text-decoration: none; color: black">
                            ${client.name}
                        </a>
                    </td>
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
</@main.renderWith>