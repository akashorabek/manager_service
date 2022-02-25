<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=["/js/products.js"] styles=["/css/products.css"]>

    <h4 class="title text-center pt-5">Все товары</h4>

    <div class="mt-3">
        <label>Поиск по названию</label>
        <form action="/products" method="post" class="d-flex">
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
            <#if products??>
                <#list products as product>
                    <tr class="product_tr" data-toggle="modal" data-target="#productDetailsModal">
                        <th class="product_tr_id" scope="row">${product.id}</th>
                        <td>${product.name}</td>
                        <td>${product.sellingPrice}</td>
                        <td>${product.quantity}</td>
                        <td>${product.inStock?string("Да", "Нет")}</td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>

    <ul class="pagination justify-content-center mt-4">
        <li class="page-item">
            <a class="page-link" href="#" tabindex="-1">Назад</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#">Вперёд</a>
        </li>
    </ul>

    <footer class="text-muted py-5">
        <div class="container">
            <p class="float-end mb-1">
                <a href="#">Вернуться наверх</a>
            </p>
            <h3 class="section-title text-default" style="visibility: visible;">Наши контакты: </h3>
            <div class="contact__phone">
                <p class="font-default-bold">+7 (707) 617 22 94</p>
            </div>
            <div class="contact__email">
                <p class="font-default-bold">Email: example@mail.ru</p>
                <p class="font-default-bold">web@auto-lavka.kz</p>
            </div>
        </div>
    </footer>

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