<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=[]>

    <h1 class="my-3 pt-4">Товары со своих складов</h1>
    <a class="btn btn-primary" href="#">Отправить</a>
    <div class="container">
        <table class="table table-hover mt-3">
            <thead class="table-light">
            <tr>
                <th>Id товара</th>
                <th>Название</th>
                <th>Цена продажи</th>
                <th>Наличие на складе</th>
                <th>Склад</th>
            </tr>
            </thead>

            <#list products as product>
                <tr class="position-relative">
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <#if product.inStock == true>
                        <td>в наличие</td>
                    <#else>
                        <td>Отсутствует</td>
                    </#if>
                    <td>${product.warehouse}</td>
                </tr>
            </#list>
        </table>
    </div>
</@main.renderWith>