<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=["/js/orders_add.js"] styles=["/css/orders.css"]>

    <div class="order_add_wrapper row">
        <div class="order_add_left col-6">
            <form id="find_client_form" class="row mb-4">
                <div class="col-9">
                    <input id="clientInput" name="client" type="text" class="form-control" placeholder="Введите название клиента" required>
                </div>
                <div class="col-3">
                    <button type="submit" class="btn btn-primary w-100">Искать</button>
                </div>
            </form>
            <div class="client_names_wrapper mb-4"></div>
            <form class="add_order_form">
                <div class="client_name mb-4">
                    <p>Клиент: <b id="client_name">Не выбран</b></p>
                </div>
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
                                <th></th>
                            </tr>
                            </thead>
                            <tbody class="order_add_left_products"></tbody>
                        </table>
                    </div>
                </div>
                <button id="add_order_btn" disabled type="submit" class="btn btn-primary">Сохранить КП</button>
            </form>
        </div>
        <div class="col-6">
            <form id="find_product_form" class="row mb-4">
                <div class="col-9">
                    <input type="text" id="productInput" class="form-control" placeholder="Введите название товара" required>
                </div>
                <div class="col-3">
                    <button type="submit" class="btn btn-primary w-100">Искать</button>
                </div>
            </form>
            <table class="table table-hover table-bordered">
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
                <tbody class="order_add_right_products"></tbody>
            </table>
        </div>
    </div>

</@main.renderWith>