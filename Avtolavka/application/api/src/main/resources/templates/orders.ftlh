<#import "partials/header.ftlh" as main>
<#import "partials/pagination.ftlh" as pagination>

<@main.renderWith scripts=["/js/orders.js"] styles=["/css/orders.css"]>

    <div class="pt-3">
        <a href="/orders/add" class="btn btn-primary">Создать КП</a>
    </div>

    <div class="row pt-3 mb-3">
        <#list page.content as order>
            <#if order.closed == false>
                <div class="col-4 gap-2">
                    <div class="card shadow-sm order_card" data-toggle="modal" data-target="#orderDetailsModal">
                        <div class="card-body">
                            <h2 class="title_order">Заявка (КП) №<span class="order_card_id">${order.id}</span></h2>
                            <p class="card-text">Имя клиента: ${order.client}</p>
                            <p class="card-text">Дата создания: ${order.dateCreation}</p>
                        </div>
                    </div>
                </div>
            </#if>
            <br>
            <#if order.closed == true>
                <div class="container mb-3">
                    <table class="table table-hover mt-3">
                        <thead class="table-light">
                        <tr>
                            <th>Заявка (КП) №</th>
                            <th>Имя клиента</th>
                            <th>Дата создания</th>
                            <th>Статус</th>
                        </tr>
                        </thead>
                        <tr class="position-relative">
                            <td>${order.id}</td>
                            <td> ${order.client}</td>
                            <td> ${order.dateCreation}</td>
                            <td>Закрыт</td>
                        </tr>
                    </table>
                </div>
            </#if>


        </#list>
    </div>

    <@pagination.pagination page=page link="/orders?"></@pagination.pagination>

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