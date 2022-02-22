<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=["/js/orders.js"] styles=["/css/orders.css"]>

    <div class="pt-5">
        <button class="btn btn-primary" data-toggle="modal" data-target="#createOrderModal">Создать КП</button>
    </div>

    <div class="row pt-5">
        <#if orders??>
            <#list orders as order>
                <div class="col-4 gap-2">
                    <div class="card shadow-sm order_card" data-toggle="modal" data-target="#orderDetailsModal">
                        <div class="card-body">
                            <h2 class="title_order">Заявка (КП) №<span class="order_card_id">${order.id}</span></h2>
                            <p class="card-text">Имя клиента: ${order.client}</p>
                            <p class="card-text">Дата создания: ${order.dateCreation}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </#if>
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


    <div class="modal fade" id="orderDetailsModal" tabindex="-1" role="dialog" aria-labelledby="orderDetailsModalTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="orderDetailsModalTitle"></h5>
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

    <div class="modal fade" id="createOrderModal" tabindex="-1" role="dialog" aria-labelledby="createOrderModal" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Создание КП</h5>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Выбрать клиента</label>
                        <select class="form-select">
                            <#if clients??>
                                <#list clients as client>
                                    <option value="${client.id}">${client.name}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Выбрать товар</label>
                        <input class="form-control" placeholder="Поиск товаров">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

</@main.renderWith>