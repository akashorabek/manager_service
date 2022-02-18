<#import "partials/header.ftlh" as main>

<@main.renderWith scripts=[] styles=["/css/clients.css"]>

<div class="modal modal-sign position-static d-block bg-secondary py-5" role="dialog" id="modalSignin">
    <div class="modal-dialog" role="document">
        <div class="modal-content rounded-5 shadow">
            <div class="modal-header p-5 pb-4 border-bottom-0">
                <h2 class="fw-bold mb-0">Введите данные</h2>
            </div>
            <div class="modal-body p-5 pt-0">
                <#list orders as order>
                <form class>
                    <div class="form-floating mb-1">
                        <p class="title__order_id">${order.id}</p>
                    </div>
                    <div class="form-floating mb-2">
                        <input type="text" class="form-control rounded-2" id="floatingInput" placeholder="Клиент">
                        <label for="floatingInput">Имя клиента</label>
                    </div>
                    <div class="title__select_client">
                        <#list clients as client>
                        <form action="/clients">
                            <label for="clients">Выберите клиента</label>
                            <select name="clients" id="clients">
                                <option value="${client.name}"></option>
                                <option value="${client.name}"></option>
                                <option value="${client.name}"></option>
                            </select>
                        </form>
                        </#list>
                    </div>
                    <div class="container py-3 text-center">
                        <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#modal">КП</button>
                    </div>
                    <div class="modal fade" id="modal" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modalLabel">Информация</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                                </div>
                                <div class="modal-body">
                                    <img src="img/engineer_order.jpg" class="img-fluid" width="250" alt="">
                                    <p class="title__order_id">${order.id}</p>
                                    <p class="title__order_name">${order.name}</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-success" data-bs-dismiss="modal">Ок</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="w-100 mb-2 btn btn-outline-success" type="submit">Подтвердить</button>
                    <small class="text-muted">Нажимая на кнопку "подтвердить" непременно будет создана заявка (КП)</small>
                </form>
            </#list>
            </div>
        </div>
    </div>
</div>

</@main.renderWith>