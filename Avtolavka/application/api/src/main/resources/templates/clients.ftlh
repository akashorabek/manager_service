<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=["/css/clients.css"]>

    <br>
    <br>
    <h1 class="my-3">Клиенты</h1>
    <div class="container">
        <a class="as-button rounded-2" href="/clients/add">Создать клиента</a>
        <a class="as-button rounded-2" href="/orders/add">Создать КП</a>
        <a class="as-button rounded-2" href="/prices/send">Отправить прайс</a>
        <br>
        <br>
        <table class="mt-3">
            <tr>
                <th>Id клиента</th>
                <th>Наименование</th>
                <th>Номер счета</th>
                <th>Адрес</th>
                <th>Телефон</th>
                <th>E-mail</th>
                <th>Статус</th>
            </tr>
            <#list clients as client>
                <tr>
                    <td>${client.id}</td>
                    <td>
                        <a href="/clients/${client.id}">${client.name}</a>
                    </td>
                    <td>${client.accountNumber}</td>
                    <td>${client.address}</td>
                    <td>${client.phone}</td>
                    <td>${client.email}</td>
                    <td>${client.status}</td>
                </tr>
            </#list>
        </table>
    </div>
</@main.renderWith>