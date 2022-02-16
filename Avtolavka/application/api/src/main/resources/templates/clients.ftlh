<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[]>

    <h1 class="my-3">Clients</h1>
    <div class="container">
        <table id="table">
            <tr>
                <th>Id клиента</th>
                <th>Наименование</th>
                <th>Номер счета</th>
                <th>Адрес</th>
                <th>Телефон</th>
                <th>E-mail</th>
            </tr>
            <#list clients as client>
                <tr>
                    <td>${client.id}</td>
                    <td>${client.name}</td>
                    <td>${client.accountNumber}</td>
                    <td>${client.address}</td>
                    <td>${client.phone}</td>
                    <td>${client.email}</td>
                </tr>
            </#list>
        </table>
    </div>
</@main.renderWith>