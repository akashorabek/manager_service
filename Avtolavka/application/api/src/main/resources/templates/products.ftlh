<#import "partials/header.ftlh" as main>
<#import "partials/pagination.ftlh" as pagination>

<@main.renderWith scripts=["/js/products.js"] styles=["/css/products.css"]>

    <h4 class="title text-center">Все товары</h4>

    <div class="mt-3">
        <label>Поиск по названию</label>
        <form action="/products" method="GET" class="d-flex">
            <input name="query" type="text" class="form-control search_input" placeholder="Введите название товара" required>
            <button class="btn btn-primary" type="submit">Искать</button>
        </form>
    </div>

    <div class="pt-3">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Конечная цена</th>
                <th scope="col">Количество</th>
                <th scope="col">В наличий</th>
            </tr>
            </thead>
            <tbody>
            <#list page.content as product>
                <tr class="product_tr" data-toggle="modal" data-target="#productDetailsModal">
                    <th class="product_tr_id" scope="row">${product.id}</th>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.inStock?string("Да", "Нет")}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <#if link??>
            <@pagination.pagination page=page link="/products?query=${link}&"></@pagination.pagination>
        <#else>
            <@pagination.pagination page=page link="/products?"></@pagination.pagination>
    </#if>

    <div class="modal fade" id="productDetailsModal" tabindex="-1" role="dialog" aria-labelledby="productDetailsModalTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="productDetailsModalTitle"></h5>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
</@main.renderWith>