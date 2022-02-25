<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=["/js/orders.js"] styles=["/css/orders.css"]>

    <div class="order_add_wrapper row">
        <div class="order_add_left col-6 pt-5">
            <select class="form-control form-control-lg">
                <#if clients??>
                    <#list clients as client>
                        <option>${client.name}</option>
                    </#list>
                </#if>
            </select>
            <div class="mt-4">
                <h4 class="title">Список товаров:</h4>
                <div class="mt-3">
                    <table class="table">
                        <thead class="table-light">
                        <tr>
                            <th>#</th>
                            <th>Название</th>
                            <th>Конечная цена</th>
                            <th>Количество</th>
                        </tr>
                        </thead>
                        <tbody class="order_add_left_products"></tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-6 pt-5">
            <div class="row gap-1 mb-4">
                <div class="col-8">
                    <input type="text" class="form-control form-control-lg" placeholder="Введите название товара">
                </div>
                <div class="col-3">
                    <button id="find_products_btn" class="btn btn-primary btn-lg">Искать</button>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Название</th>
                    <th>Конечная цена</th>
                    <th>Количество</th>
                    <th>В наличий</th>
                    <th></th>
                </tr>
                </thead>
                <tbody class="order_add_right_products">
                <#if products??>
                    <#list products as product>
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.sellingPrice}</td>
                            <td>${product.quantity}</td>
                            <td>${product.inStock?string("Да", "Нет")}</td>
                            <td><input type="checkbox" value="${product.id}" class="form-check-input product_checkbox"></td>
                        </tr>
                    </#list>
                </#if>
                </tbody>
            </table>
        </div>
    </div>

</@main.renderWith>